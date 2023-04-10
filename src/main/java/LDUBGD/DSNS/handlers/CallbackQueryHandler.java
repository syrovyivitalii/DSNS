package LDUBGD.DSNS.handlers;

import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.model.*;
import LDUBGD.DSNS.repository.*;
import LDUBGD.DSNS.services.UkraineAlarmScheduledTasks;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CallbackQueryHandler implements Handler<CallbackQuery> {
    private final MessageSender messageSender;
    private final RegionsRepository regionsRepository;
    private final MenuRepository menuRepository;
    private final PhotoRepository photoRepository;
    private final InlineKeyboardRepository inlineKeyboardRepository;
    final
    UserLoginRepository userLoginRepository;
    final
    UkraineAlarmScheduledTasks ukraineAlarmScheduledTasks;

    public CallbackQueryHandler(MessageSender messageSender, RegionsRepository regionsRepository, MenuRepository menuRepository, PhotoRepository photoRepository, InlineKeyboardRepository inlineKeyboardRepository, UserLoginRepository userLoginRepository, UkraineAlarmScheduledTasks ukraineAlarmScheduledTasks) {
        this.messageSender = messageSender;
        this.regionsRepository = regionsRepository;
        this.menuRepository = menuRepository;
        this.photoRepository = photoRepository;
        this.inlineKeyboardRepository = inlineKeyboardRepository;
        this.userLoginRepository = userLoginRepository;
        this.ukraineAlarmScheduledTasks = ukraineAlarmScheduledTasks;
    }

    @Override
    public void choose(CallbackQuery callbackQuery) {
        //замінити повідомлення
        Integer messageId = callbackQuery.getMessage().getMessageId();
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
        editMessageText.setMessageId(messageId);
        //надіслати нове повідомлення
        Message message = callbackQuery.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setParseMode(ParseMode.HTML);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(message.getChatId()));

        if (explosive().contains(callbackQuery.getData())) {
            Photo photo = photoRepository.findByMenu(callbackQuery.getData());
            sendPhoto.setPhoto(new InputFile(photo.getUrl()));
            messageSender.sendPhoto(sendPhoto);

            Menu menu = menuRepository.findByNameMenu(callbackQuery.getData());
            sendMessage.setText(menu.getMenu());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().startsWith("regionId:")) {
            String[] params = callbackQuery.getData().split(":");
            int regionId = Integer.parseInt(params[1]);
            Long userId = Long.parseLong(params[2]);
            Optional<UserLogin> optionalUserLogin = userLoginRepository.findByTelegramId(userId);
            UserLogin userLogin;
            if (!optionalUserLogin.isPresent()) {
                userLogin = new UserLogin(userId, message.getChatId());
            } else {
                userLogin = optionalUserLogin.get();
                if (userLogin.getChatId() == null) {
                    userLogin.setChatId(message.getChatId());
                }
            }
            Regions region01 = regionsRepository.getById(regionId);
            userLogin.setRegion(region01);
            userLoginRepository.save(userLogin);
            messageSender.sendRegion(sendMessage, sendPhoto, optionalUserLogin);

            messageSender.sendMessage(sendMessage);
        }

    }
    // записування усіх видів вибухівки в список
    private List <String> explosive(){
        List<InlineKeyboard> explosions = inlineKeyboardRepository.findByMenu("\uD83D\uDCD6 Читати ще");
        List <String> nameExplosive = new ArrayList<>();
        for (InlineKeyboard inlineKeyboard: explosions){
            nameExplosive.add(inlineKeyboard.getCallback());
        }
        return nameExplosive;
    }
}
