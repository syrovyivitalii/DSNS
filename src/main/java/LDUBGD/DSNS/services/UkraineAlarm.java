package LDUBGD.DSNS.services;

import LDUBGD.DSNS.model.*;
import LDUBGD.DSNS.repository.CommunityRepository;
import LDUBGD.DSNS.repository.RegionsRepository;
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
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UkraineAlarm {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private RegionsRepository regionsRepository;
    @Autowired
    CommunityRepository communityRepository;

    @Value("${alarm.key}")
    private String alarmKey;
    @Value("${alarm.geoserver}")
    private String geoserver;
    @Value("${alarm.imgHeight}")
    private long imgHeight = 600;


    /**
     * Формує заголовки HTTP запиту
     *
     * @return
     */
    private HttpEntity<String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorizatio" +
                "n", alarmKey);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }


    /**
     * Отримати всі тривоги на теперішній час
     *
     * @return
     */
    public List<Alert> getAlerts() {
        ResponseEntity<Alert[]> responseEntity = restTemplate.exchange("/alerts", HttpMethod.GET, getHeaders(), Alert[].class);
//        ResponseEntity<String> responseEntity = restTemplate.exchange("/alerts", HttpMethod.GET, getHeaders(), String.class);
        if (responseEntity.getStatusCode().isError()) {
            return new ArrayList<>();
        }
        return Arrays.asList(responseEntity.getBody());
    }

    /**
     * Перетворює дату з формату yyyy-MM-dd HH:mm:ss у формат dd.MM.y
     * yyy HH:mm:ss
     * |
     * 2023-02-04 15:35:50 -> 09.02.2023 20:26:38
     *
     * @param dt
     * @param add
     * @return
     */
    public String convertDate(String dt, boolean add) {
        //yyyy-mm-ddThh:mm:ss.sssZ
        String res = "";
        try {
            //Parsing the given String to Date object
            Instant instant = Instant.parse(dt);
            if (add) {
                Duration between = Duration.between(instant, Instant.now());
                if (between.toDaysPart() > 0) {
                    res += between.toDaysPart() + " д.";
                }
                if (between.toHoursPart() > 0) {
                    res += between.toHoursPart() + " год.";
                }
                res = "\nтриває " + res + between.toMinutesPart() + " хв.";
            }
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").withZone(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(timezone)));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
            res = formatter.format(instant) + res;
        } catch (Exception e) {
            log.error(e.getMessage());
            res = dt;
        }
        return res;
    }


    /**
     * Отримати поточний стан по регіону
     *
     * @param regId
     * @return
     */
    public String getAlert(String regId) {
        ResponseEntity<Alert[]> responseEntity = restTemplate.exchange("/alerts/" + regId, HttpMethod.GET, getHeaders(), Alert[].class);
        if (responseEntity.getStatusCode().isError() || responseEntity.getBody().length == 0) {
            return "";
        }
        Alert alert = responseEntity.getBody()[0];
        if (alert.getActiveAlerts().length == 0) {
//            return "<green><b>Зараз немає тривоги. </b><br>Попередня була " + convertDate(alert.getLastUpdate() + "</green>");
            return "\uD83D\uDFE2<i>Зараз немає тривоги. </i>\nПопередня закінчилася " + convertDate(alert.getLastUpdate(), false);
        }
        ActiveAlerts activeAlert = alert.getActiveAlerts()[0];
        Optional<Regions> byId = regionsRepository.findById(Integer.parseInt(activeAlert.getRegionId()));
        String regionName = "";
        if (byId.isPresent()) {
            regionName = byId.get().getRegionName();
        }
//        return "<red>"+activeAlert.getType()+ " " +  convertDate(activeAlert.getLastUpdate()) + "</red>";
        return "\uD83D\uDD34<b>" + activeAlert.getType() + "</b>\n" + regionName + "\n " + convertDate(activeAlert.getLastUpdate(), true);
    }


    /**
     * https://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
     *
     * @param regionId
     * @return
     */
    public InputStream getJpg(int regionId) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();

            IRegionInfo b = communityRepository.getRegionReqParam(regionId).get(0);
            String bbox = b.getBbox().substring(4, b.getBbox().length() - 1).replace(" ", ",");

            log.info(b.getBbox());
            log.info(b.getFid());

//            log.info(new UrlEncodedFormEntity(urlParameters).toString());
//            HttpGet request = new HttpGet("http://10.44.64.30:8088/geoserver/topp/wms?SERVICE=WMS&VERSION=1.1.1&REQUEST=GetMap&FORMAT=image%2Fjpeg&TRANSPARENT=true&STYLES&LAYERS=topp%3Acommunity&exceptions=application%2Fvnd.ogc.se_inimage&FEATUREID=978&SRS=EPSG%3A4326&WIDTH=600&HEIGHT=600&BBOX=23.92547607421875%2C49.24346923828125%2C24.74945068359375%2C50.06744384765625");
            HttpGet request = new HttpGet();
            URI uri = new URIBuilder(geoserver)
                    .addParameter("SERVICE", "WMS")
                    .addParameter("VERSION", "1.1.1")
                    .addParameter("REQUEST", "GetMap")
                    .addParameter("FORMAT", "image/png")
                    .addParameter("TRANSPARENT", "true")
                    .addParameter("STYLES", "")
                    .addParameter("LAYERS", "topp:community_view")
                    .addParameter("exceptions", "application/vnd.ogc.se_inimage")
                    .addParameter("FEATUREID", b.getFid())
                    .addParameter("SRS", "EPSG:4326")
                    .addParameter("HEIGHT", String.valueOf(imgHeight))
                    .addParameter("WIDTH", String.valueOf((long) (imgHeight * IRegionInfo.calcRatio(bbox))))
                    .addParameter("BBOX", bbox)
                    .build();
            request.setURI(uri);
            request.addHeader("content-type", "image/png");
            HttpResponse response = null;
            log.info(uri.toString());

            response = httpClient.execute(request);

            org.apache.http.HttpEntity entity = response.getEntity();
//            BufferedImage img = ImageIO.read(entity.getContent());
            return entity.getContent();
//            return img;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
    public ResponseEntity<AlertStatus> getAlertsStatus() {
        return restTemplate.exchange("/alerts/status", HttpMethod.GET, getHeaders(), AlertStatus.class);
    }
}
