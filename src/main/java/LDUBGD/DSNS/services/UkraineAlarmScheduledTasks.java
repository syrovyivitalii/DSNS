package LDUBGD.DSNS.services;

import LDUBGD.DSNS.DSNSBot;
import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.model.*;
import LDUBGD.DSNS.repository.CommunityRepository;
import LDUBGD.DSNS.repository.RegionsRepository;
import LDUBGD.DSNS.repository.UserLoginRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class UkraineAlarmScheduledTasks {
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    MessageSender messageSender;
    @Autowired
    UkraineAlarm ukraineAlarm;
    @PersistenceContext
    private EntityManager entityManager;
    AlertStatus lastAlertStatus = new AlertStatus();
    List<Alert> lastAlerts = new ArrayList<>();

    /**
     * Повертає true якщо статус відмінний від попередньо збереженого
     *
     * @return
     */
    private boolean isLastAlertsStatus() {
        // TODO: 09.02.23 Зберігати lastAlertStatus в БД або у файлі, щоб після перевантаження
        ResponseEntity<AlertStatus> responseEntity = ukraineAlarm.getAlertsStatus();
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

    /**
     * Знаходить різницю із попереднім станом, зміни відсилає всім хто підписаний на регіон
     * Зберігає попередній стан
     *
     * @param alerts
     */
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
                String txt = String.format("\uD83D\uDD34 %s%n%s\n%s",
                        Arrays.stream(alert.getActiveAlerts()).findFirst().get().getType(), alert.getRegionName(),
                        ukraineAlarm.convertDate(alert.getLastUpdate(), false));
                sendText(alert.getRegionId(), txt);
            }
        }
        lastAlerts = alerts;
    }

    /**
     * відсилає всім хто підписаний на регіон regId або підпорядковані райони
     * Тобто якщо тривога в Луганській області(16), сповіщення прийде і в районах (84-86) і громадах (801-817)
     *
     * @param regId
     * @param txt
     */
    private void sendText(String regId, String txt) {
        log.info("{}: {}", regId, txt);
//        List<UserLogin> userLogins = userLoginRepository.findAll();
        List<UserLogin> userLogins = userLoginRepository.findAllInRegion(Integer.parseInt(regId));
        for (UserLogin user : userLogins) {
            if (user.getChatId() != null) {
                String sendTxt = txt;
                messageSender.sendMessage(SendMessage.builder().chatId(user.getChatId()).parseMode("html").text(sendTxt).build());
            }
        }
    }

    @Scheduled(fixedRateString = "${alarm.fixedRate}")
    public void reportCurrentTime() {
        try {
            if (isLastAlertsStatus()) {
                setLastAlerts(ukraineAlarm.getAlerts());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
