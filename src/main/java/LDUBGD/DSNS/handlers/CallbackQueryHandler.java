package LDUBGD.DSNS.handlers;

import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.model.*;
import LDUBGD.DSNS.repository.*;
import LDUBGD.DSNS.services.InlineButton;
import LDUBGD.DSNS.services.ReplyKeyboard;
import LDUBGD.DSNS.services.Start;
import LDUBGD.DSNS.services.UkraineAlarmScheduledTasks;
import org.springframework.beans.factory.annotation.Autowired;
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
    InlineButton inlineButton = new InlineButton();
    Start start = new Start();

    ReplyKeyboard replyKeyboard = new ReplyKeyboard();

    @Autowired
    VolunteeringRepository volunteeringRepository;

    @Autowired
    FirstAidRepository firstAidRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private RegionsRepository regionsRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private InlineKeyboardRepository inlineKeyboardRepository;

    @Autowired
    UserLoginRepository userLoginRepository;
    @Autowired
    UkraineAlarmScheduledTasks ukraineAlarmScheduledTasks;


    public CallbackQueryHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
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
        } else if (callbackQuery.getData().equals("91")) {
            String dBQuestionOne = volunteeringRepository.getQuestionOne();
            sendMessage.setText(dBQuestionOne);
            sendMessage.setReplyMarkup(replyKeyboard.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        } else if (callbackQuery.getData().equals("92")) {
            String dBQuestionTwo = volunteeringRepository.getQuestionOne();
            sendMessage.setText(dBQuestionTwo);
            sendMessage.setReplyMarkup(replyKeyboard.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        } else if (callbackQuery.getData().equals("93")) {
            String dBQuestionThree = volunteeringRepository.getQuestionOne();
            sendMessage.setText(dBQuestionThree);
            sendMessage.setReplyMarkup(replyKeyboard.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        } else if (callbackQuery.getData().equals("94")) {
            String dBQuestionFour = volunteeringRepository.getQuestionOne();
            sendMessage.setText(dBQuestionFour);
            sendMessage.setReplyMarkup(replyKeyboard.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
            // TODO: 14.02.23 Чи потрібно?!
        } else if (callbackQuery.getData().equals("Мобільний пристрій")) {
//            Optional<Hromady> hromadyList = hromadyRepository.findById(252);
//            List<Hromady> hromada = hromadyRepository.hromada(24.621005, 49.245382);
            sendMessage.setText("Надішліть вашу геолокацію для подальшої обробки\uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        } else if (callbackQuery.getData().startsWith("regionId:")) {
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
        List<InlineKeyboard> explosions = inlineKeyboardRepository.findByMenu("вибухівка");
        List <String> nameExplosive = new ArrayList<>();
        for (InlineKeyboard inlineKeyboard: explosions){
            nameExplosive.add(inlineKeyboard.getCallback());
        }
        return nameExplosive;
    }
}
