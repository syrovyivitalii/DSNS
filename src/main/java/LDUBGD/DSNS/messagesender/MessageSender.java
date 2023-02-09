package LDUBGD.DSNS.messagesender;

import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public interface MessageSender {
    void sendMessage(SendMessage sendMessage);

    void sendEditMessage(EditMessageText editMessageText);

    void sendPhoto(SendPhoto sendPhoto);
    void sendLocation(SendLocation sendLocation);
}
