package LDUBGD.DSNS.handlers;

import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.model.*;
import LDUBGD.DSNS.repository.*;
import LDUBGD.DSNS.services.InlineButton;
import LDUBGD.DSNS.services.ReplyKeyboard;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MessageHandler implements Handler<Message> {
    @Setter
    private MessageSender messageSender;
    private final RegionsRepository regionsRepository;
    private final MenuRepository menuRepository;
    private final KeyboardRepository keyboardRepository;
    private final PhotoRepository photoRepository;
    private final InlineKeyboardRepository inlineKeyboardRepository;
    private final ReplyKeyboard replyKeyboard;
    private final InlineButton inlineButton;
    final
    UserLoginRepository userLoginRepository;
    final
    CommunityRepository communityRepository;

    private static final int MAX_MESSAGE_LENGTH = 4096; // максимальна довжина повідомлення в Telegram

    public MessageHandler(MessageSender messageSender, RegionsRepository regionsRepository, MenuRepository menuRepository, KeyboardRepository keyboardRepository, PhotoRepository photoRepository, InlineKeyboardRepository inlineKeyboardRepository, ReplyKeyboard replyKeyboard, InlineButton inlineButton, UserLoginRepository userLoginRepository, CommunityRepository communityRepository) {
        this.messageSender = messageSender;
        this.regionsRepository = regionsRepository;
        this.menuRepository = menuRepository;
        this.keyboardRepository = keyboardRepository;
        this.photoRepository = photoRepository;
        this.inlineKeyboardRepository = inlineKeyboardRepository;
        this.replyKeyboard = replyKeyboard;
        this.inlineButton = inlineButton;
        this.userLoginRepository = userLoginRepository;
        this.communityRepository = communityRepository;
    }

    @Override
    public void choose(Message message) {
        Long userId = message.getFrom().getId();
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
        if (message.hasLocation()) {
            Location location = message.getLocation();
            userLogin.setX(location.getLongitude());
            userLogin.setY(location.getLatitude());
            List<Community> community = communityRepository.community(userLogin.getX(), userLogin.getY());
            SendMessage sendMessage = new SendMessage();
            // TODO: 09.02.23 Поки що вибирає лише громаду, передбачити можливість вибрати район або область inline button
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            if (!community.isEmpty()) {
                Community hromada = community.get(0);
                userLogin.setRegion(hromada.getRegionId());
                sendMessage.setText(String.format("%s%n%s", hromada.getDistrict(), hromada.getCommunity()));
            } else {
                sendMessage.setText(String.format("Громаду не знайдено (%s:%s)", userLogin.getX(), userLogin.getY()));
            }
            messageSender.sendMessage(sendMessage);
            log.info(message.getLocation().toString());
            userLoginRepository.save(userLogin);
        }
        if (message.hasContact()) {
            Contact contact = message.getContact();
            userLogin.setPhone(contact.getPhoneNumber());
            userLogin.setFirstName(contact.getFirstName());
            userLogin.setLastName(contact.getLastName());
            userLoginRepository.save(userLogin);
            log.info(message.getContact().toString());
        }
        if (message.hasText()) {
            //виведення повідомлення користувача в консоль
            log.info("{}:{}", userId, message.getText());
            //взаємодія з конкретним чатом
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            sendMessage.setParseMode(ParseMode.HTML);
            //надсилання фото в конкретний чат
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(String.valueOf(message.getChatId()));
            //надсилання відео
            SendVideo sendVideo = new SendVideo();
            sendVideo.setChatId(message.getChatId());

            List<Keyboard> toMenu = keyboardRepository.findByMenu("в меню");
            Menu nameMenu;
            List<Keyboard> keyboardMenu;
            Photo photo;
            switch (message.getText()) {
                //старт програми
                case "/start":
                    nameMenu = menuRepository.findByNameMenu("старт");
                    String getMenuStart = nameMenu.getMenu();
                    sendMessage.setText(getMenuStart);

                    List<Keyboard> keyboardFirstStart = keyboardRepository.findByMenu("перший старт");
                    List<Keyboard> keyboardStart = keyboardRepository.findByMenu("старт");
                    ReplyKeyboardMarkup keyboard;

                    if (optionalUserLogin.isPresent()) {
                        keyboard = replyKeyboard.getCreateKeyboard(keyboardStart);
                    } else {
                        keyboard = replyKeyboard.getCreateKeyboard(keyboardFirstStart);
                    }
                    sendMessage.setReplyMarkup(keyboard);

                    break;
                case "\uD83D\uDCD6 Моя громада":
                    messageSender.sendRegion(sendMessage, sendPhoto, optionalUserLogin);
                    break;

                case "3":
                case "\uD83D\uDD14 Мінування":
                case "\uD83C\uDD98 Зона бойових дій":
                case "\uD83E\uDDE9 Для дітей":
                case "4":
                case "⛑ Допомога потерпілим":
                case "\uD83E\uDEC0\uD83E\uDEC1️ Серцево-легенева реанімація":
                case "\uD83D\uDD19 Повернутися":
                case "\uD83C\uDFE5 Зовнішня кровотеча":
                case "⛑ Опіки/Обмороження":
                case "\uD83E\uDDB4 Травми кісток":
                case "\uD83D\uDC55 Травми грудної клітки":
                case "\uD83D\uDC81Емоційна підтримка":
                case "\uD83D\uDC64 Емоційні стани":
                case "5":
                case "\uD83D\uDCCB Волонтерам":
                case "\uD83D\uDCCB Працівникам ДСНС":
                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());

                    keyboardMenu = keyboardRepository.findByMenu(message.getText());
                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(keyboardMenu));
                    break;
                case "\uD83D\uDCD6 Читати ще":
                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());

                    List<InlineKeyboard> inlineKeyboardExplosives = inlineKeyboardRepository.findByMenu(message.getText());
                    sendMessage.setReplyMarkup(inlineButton.getCreateInlineKeyboard(inlineKeyboardExplosives));
                    break;
                case "1":
                case "311":
                case "314":
                case "315":
                case "316":
                case "\uD83E\uDDE9 Форма спілкування":
                case "\uD83D\uDDDE Мапа розмінувань":
                case "6":
                case "\uD83D\uDCCB Алгоритм дій":
                    photo = photoRepository.findByMenu(message.getText());
                    sendPhoto.setPhoto(new InputFile(photo.getUrl()));
                    messageSender.sendPhoto(sendPhoto);

                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());

                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(toMenu));
                    break;
                case "312":
                case "313":
                case "\uD83C\uDD95 Освоєння звичок":
                case "\uD83C\uDF92 Підготовленість":
                case "☢️ Радіація":
                case "\uD83E\uDDE4 Хімічна загроза":
                case "\uD83D\uDEDF Заходи безпеки":
                case "\uD83D\uDCDC Інформованість":
                case "422":
                case "423":
                case "424":
                case "425":
                case "511":
                case "512":
                case "513":
                case "514":
                case "521":
                case "522":
                case "523":
                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());

                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(toMenu));
                    break;
                case "321":
                case "322":
                case "323":
                case "324":
                case "325":
                case "326":
                case "421":
                    Photo nameOfVideo = photoRepository.findByMenu(message.getText());
                    InputStream videoStream = MessageHandler.class.getClassLoader().getResourceAsStream("video/"+ nameOfVideo.getUrl());

                    sendVideo.setVideo(new InputFile(videoStream,nameOfVideo.getUrl()));
                    messageSender.sendVideo(sendVideo);

                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());

                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(toMenu));
                    break;
                case "2":
                case "\uD83D\uDCCC Розмова з дітьми":
                case "Більше інформації ➡️":
                case "\uD83D\uDCAD Забруднення":
                    photo = photoRepository.findByMenu(message.getText());
                    sendPhoto.setPhoto(new InputFile(photo.getUrl()));
                    messageSender.sendPhoto(sendPhoto);

                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());

                    keyboardMenu = keyboardRepository.findByMenu(message.getText());
                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(keyboardMenu));
                    break;
                case "\uD83D\uDC68\uD83C\uDFFC Дорослий":
                case "\uD83D\uDC66\uD83C\uDFFC Дитина":
                case "\uD83D\uDC76\uD83C\uDFFC Немовля":
                case "\uD83C\uDF21 Термічний опік":
                case "⚡️ Електричний опік":
                case "\uD83E\uDD76 Обмороження":
                case "\uD83D\uDD39Відкритий перелом":
                case "\uD83D\uDD39Закритий перелом":
                case "\uD83D\uDD39Вивих":
                case "\uD83E\uDDE0 Травма голови":
                case "\uD83D\uDD2A Проникаюча травма":
                case "⛑ Закрита травма":
                case "\uD83D\uDFE5 з рани кінцівки та з можливістю її чіткої візуалізації":
                case "\uD83D\uDFE7 з рани кінцівки та без можливісті її чіткої візуалізації":
                case "\uD83D\uDFE8 з рани яка локалізована в пахвових, пахвинних ділянках, сідниць та основи шиї":
                case "⚠️ Травми хребта":
                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    sendMessage.setText(nameMenu.getMenu());
                    break;
                case "\uD83D\uDCCD Поділитись розташуванням":
                case "\uD83D\uDCCD Змінити розташування":
                    log.info("isUserChat :{}", message.getChat().isUserChat());
                    nameMenu = menuRepository.findByNameMenu("поділитись розташуванням");
                    sendMessage.setText(nameMenu.getMenu());
                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> keyboardLocation = new ArrayList<>();
                    List<InlineKeyboardButton> rowLine;
                    List<Regions> states = regionsRepository.getStates();
                    for (Regions state : states) {
                        rowLine = new ArrayList<>();
                        rowLine.add(InlineKeyboardButton.builder()
                                .text(state.getRegionName())
                                .callbackData("regionId:" + state.getRegionId() + ":" + userId).build());
                        keyboardLocation.add(rowLine);
                    }
                    inlineKeyboardMarkup.setKeyboard(keyboardLocation);
                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    break;
                case "\uD83E\uDE78 Кровотеча":
                case "\uD83D\uDE80ДМД в умовах бойових дій":
                    nameMenu = menuRepository.findByNameMenu(message.getText());
                    keyboardMenu = keyboardRepository.findByMenu(message.getText());
                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(keyboardMenu));
                    String text = nameMenu.getMenu();
                    int messageCount = (int) Math.ceil((double) text.length() / MAX_MESSAGE_LENGTH); // calculate the number of messages
                    for (int i = 0; i < messageCount; i++) {
                        int startIndex = i * MAX_MESSAGE_LENGTH;
                        int endIndex = Math.min(startIndex + MAX_MESSAGE_LENGTH, text.length());
                        String messageText = text.substring(startIndex, endIndex);
                        sendMessage.setText(messageText);
                        messageSender.sendMessage(sendMessage);
                    }
                    return;
                //меню
                case "\uD83D\uDD19 Меню":
                case "Меню":
                default:
                    nameMenu = menuRepository.findByNameMenu("меню");
                    sendMessage.setText(nameMenu.getMenu());

                    keyboardMenu = keyboardRepository.findByMenu("меню");
                    sendMessage.setReplyMarkup(replyKeyboard.getCreateKeyboard(keyboardMenu));
            }
            //відправлення повідомлення
            messageSender.sendMessage(sendMessage);
        }

    }
}
