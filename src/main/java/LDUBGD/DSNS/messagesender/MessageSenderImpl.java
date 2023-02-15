package LDUBGD.DSNS.messagesender;

import LDUBGD.DSNS.DSNSBot;
import LDUBGD.DSNS.model.Regions;
import LDUBGD.DSNS.model.UserLogin;
import LDUBGD.DSNS.services.UkraineAlarm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.InputStream;
import java.util.Optional;

@Service
@Slf4j
public class MessageSenderImpl implements MessageSender {
    private DSNSBot dsnsBot;
    @Autowired
    private UkraineAlarm ukraineAlarm;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            dsnsBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendEditMessage(EditMessageText editMessageText) {
        try {
            dsnsBot.execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendPhoto(SendPhoto sendPhoto) {
        try {
            dsnsBot.execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendLocation(SendLocation sendLocation) {
        try {
            dsnsBot.execute(sendLocation);
        } catch (TelegramApiException e) {
            log.error(e.getMessage()
            );
        }
    }

    @Override
    public void sendRegion(SendMessage sendMessage, SendPhoto sendPhoto, Optional<UserLogin> optionalUserLogin) {
        UserLogin userLogin;
        if (!optionalUserLogin.isPresent()
                || optionalUserLogin.get().getRegion() == null) {
            sendMessage.setText("Ви ще не обрали громаду");
            return;
        } else {
            userLogin = optionalUserLogin.get();
        }
//        sendMessage.setChatId(String.valueOf(message.getChatId()));
        Regions region02 = userLogin.getRegion();
        sendMessage.setParseMode("html");
        sendMessage.setText(region02.getText("\n") + "\n\n" +
                ukraineAlarm.getAlert(region02.getRegionId().toString()));

        InputStream jpg02 = ukraineAlarm.getJpg(region02.getRegionId());
        if (jpg02 != null) {
            sendPhoto.setPhoto(new InputFile(jpg02, "dd"));
        }
        sendPhoto(sendPhoto);
    }

    @Autowired
    public void setDsns(DSNSBot dsnsBot) {
        this.dsnsBot = dsnsBot;
    }
}
