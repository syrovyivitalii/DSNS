package LDUBGD.DSNS.services;

import LDUBGD.DSNS.DSNSBot;
import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.model.*;
import LDUBGD.DSNS.repository.CommunityRepository;
import LDUBGD.DSNS.repository.UserLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ScheduledTasks {
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    CommunityRepository communityRepository;
    @Autowired
    MessageSender messageSender;
    private DSNSBot dsnsBot;

    @Autowired
    RestTemplate restTemplate;

    @PersistenceContext
    private EntityManager entityManager;
//    @Autowired
//    CloseableHttpClient closeableHttpClient;

    @Value("${alarm.key}")
    private String alarmKey;
    @Value("${alarm.geoserver}")
    private String geoserver;

    AlertStatus lastAlertStatus = new AlertStatus();
    List<Alert> lastAlerts = new ArrayList<>();

    private HttpEntity<String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorizatio" +
                "n", alarmKey);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }

    /**
     * Повертає true якщо статус відмінний від попередньо збереженого
     *
     * @return
     */
    private boolean isLastAlertsStatus() {
        ResponseEntity<AlertStatus> responseEntity = restTemplate.exchange("/alerts/status", HttpMethod.GET, getHeaders(), AlertStatus.class);
        if (responseEntity.getStatusCode().isError()) {
            return false;
        }
        AlertStatus alertStatus = responseEntity.getBody();
        if (lastAlertStatus.equals(alertStatus)) {
            return false;
        }
        lastAlertStatus = alertStatus;
        return true;
    }

    public String getAlert(String regId) {
        ResponseEntity<Alert[]> responseEntity = restTemplate.exchange("/alerts/" + regId, HttpMethod.GET, getHeaders(), Alert[].class);
        if (responseEntity.getStatusCode().isError() || responseEntity.getBody().length == 0) {
            return "";
        }
        Alert alert = responseEntity.getBody()[0];
        if (alert.getActiveAlerts().length == 0) {
            return "Немає тривоги";
        }
        ActiveAlerts activeAlert = alert.getActiveAlerts()[0];
        return String.format("%s %s", activeAlert.getType(), activeAlert.getLastUpdate());
    }

    private List<Alert> getAlerts() {
        ResponseEntity<Alert[]> responseEntity = restTemplate.exchange("/alerts", HttpMethod.GET, getHeaders(), Alert[].class);
//        ResponseEntity<String> responseEntity = restTemplate.exchange("/alerts", HttpMethod.GET, getHeaders(), String.class);
        if (responseEntity.getStatusCode().isError()) {
            return new ArrayList<>();
        }
        return Arrays.asList(responseEntity.getBody());
    }

    private void setLastAlerts(List<Alert> alerts) {
        //vidbii
        for (Alert alert : lastAlerts) {
            if (!alerts.contains(alert)) {
                String txt = String.format("\uD83D\uDFE2 Відбій %s", alert.getRegionName());
                sendText(alert.getRegionId(), txt);
            }
        }

        for (Alert alert : alerts) {
            if (!lastAlerts.contains(alert)) {
//               "Tr"
                String txt = String.format("\uD83D\uDD34 %s%n%s", Arrays.stream(alert.getActiveAlerts()).findFirst().get().getType(), alert.getRegionName());
                sendText(alert.getRegionId(), txt);
            }
        }
        lastAlerts = alerts;
    }

    private void sendText(String regId, String txt) {
        log.info("{}: {}", regId, txt);
        List<UserLogin> userLogins = userLoginRepository.findAll();
        for (UserLogin user : userLogins) {
            if (user.getChatId() != null) {
                String sendTxt = txt;
                messageSender.sendMessage(SendMessage.builder().chatId(user.getChatId()).text(sendTxt).build());
            }
        }
    }


    /**
     * https://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
     * @param regionId
     * @return
     */
    public InputStream getJpg(int regionId) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();


            String sqlScript = "select cast(st_extent(geom) as varchar), string_agg(cast (region_id as varchar), ',')  from community where region_id in (select region_id from get_sub_region("+regionId+")) ";
//            String getRegionBBox(int region_id);
            Query q = entityManager.createNativeQuery(sqlScript);
            List resultList = q.getResultList();
            if(resultList.isEmpty()){
                return null;
            }
            Object bb = resultList.get(0);

            String repositoryRegionBBox = communityRepository.getRegionBBox(regionId);

//            log.info(new UrlEncodedFormEntity(urlParameters).toString());
//            HttpGet request = new HttpGet("http://10.44.64.30:8088/geoserver/topp/wms?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&FORMAT=image%2Fjpeg&TRANSPARENT=true&STYLES&LAYERS=topp%3Acommunity&exceptions=application%2Fvnd.ogc.se_inimage&FEATUREID=978&SRS=EPSG%3A4326&WIDTH=600&HEIGHT=600&BBOX=23.92547607421875%2C49.24346923828125%2C24.74945068359375%2C50.06744384765625");
//            HttpGet request = new HttpGet("http://10.44.64.30:8088/geoserver/topp/wms");
            HttpGet request = new HttpGet();
//                    "?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&FORMAT=image%2Fjpeg&TRANSPARENT=true&STYLES&LAYERS=topp%3Acommunity&exceptions=application%2Fvnd.ogc.se_inimage&FEATUREID=978&SRS=EPSG%3A4326&WIDTH=600&HEIGHT=600&BBOX=23.92547607421875%2C49.24346923828125%2C24.74945068359375%2C50.06744384765625");
            URI uri = new URIBuilder(geoserver)
                    .addParameter("SERVICE","WMS")
                    .addParameter("VERSION", "1.1.1")
                    .addParameter("REQUEST", "GetMap")
                    .addParameter("FORMAT", "image/png")
                    .addParameter("TRANSPARENT", "true")
                    .addParameter("STYLES", "")
                    .addParameter("LAYERS", "topp:community_view")
                    .addParameter("exceptions", "application/vnd.ogc.se_inimage")
                    .addParameter("FEATUREID", "1217")
                    .addParameter("SRS", "EPSG:4326")
                    .addParameter("WIDTH", "768")
                    .addParameter("HEIGHT", "339")
                    .addParameter("BBOX", repositoryRegionBBox)
                    .build();
            request.setURI(uri);
            request.addHeader("content-type", "image/png");
            HttpResponse response = null;

            response = httpClient.execute(request);


            org.apache.http.HttpEntity entity = response.getEntity();
//            BufferedImage img = ImageIO.read(entity.getContent());
            return  entity.getContent();
//            return img;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    @Scheduled(fixedRateString = "${alarm.fixedRate}")
    public void reportCurrentTime() {
        try {

            if (isLastAlertsStatus()) {
                setLastAlerts(getAlerts());
            }
//        List<Community> communityAlarm = communityRepository.getCommunityAlarm();
            List<Community> communityAlarm = new ArrayList<>();
            if (communityAlarm.isEmpty()) {
                log.info("{}", lastAlertStatus);
            } else {
                log.info("{}", communityAlarm.size());
                List<UserLogin> byHromada = userLoginRepository.findByHromada(communityAlarm);
                for (UserLogin user : byHromada) {
                    if (user.getChatId() != null) {
                        String sendTxt = "Test " + user.getRegion().getCommunity();
                        messageSender.sendMessage(SendMessage.builder().chatId(user.getChatId()).text(sendTxt).build());
                    }
                }


//            dsnsBot.
//                    EditMessageText.builder().build());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
