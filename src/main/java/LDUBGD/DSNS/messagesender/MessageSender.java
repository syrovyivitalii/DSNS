package LDUBGD.DSNS.messagesender;

import LDUBGD.DSNS.model.UserLogin;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

import java.util.Optional;

public interface MessageSender {
    void sendMessage(SendMessage sendMessage);

    void sendEditMessage(EditMessageText editMessageText);

    void sendPhoto(SendPhoto sendPhoto);
    void sendLocation(SendLocation sendLocation);

    void sendRegion(SendMessage sendMessage, SendPhoto sendPhoto, Optional<UserLogin> optionalUserLogin);
    void sendVideo(SendVideo sendVideo);
}
