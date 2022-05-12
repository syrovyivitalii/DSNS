package LDUBGD.DSNS.messagesender;

import LDUBGD.DSNS.DSNSBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private DSNSBot dsnsBot;

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
    public void sendPhoto(SendPhoto sendPhoto){
        try {
            dsnsBot.execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setDsns(DSNSBot dsnsBot) {
        this.dsnsBot = dsnsBot;
    }
}
