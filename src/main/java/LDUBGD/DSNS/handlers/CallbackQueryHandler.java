package LDUBGD.DSNS.handlers;

import LDUBGD.DSNS.aid.CardiopulmonaryResuscitation;
import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.services.InlineButton;
import LDUBGD.DSNS.services.Menu;
import LDUBGD.DSNS.services.Start;
import LDUBGD.DSNS.services.Volunteering;
import LDUBGD.DSNS.services.WeaponsAndAmmunition;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class CallbackQueryHandler implements Handler <CallbackQuery> {
    private final MessageSender messageSender;
    CardiopulmonaryResuscitation CPR = new CardiopulmonaryResuscitation();
    WeaponsAndAmmunition weaponsAndAmmunition = new WeaponsAndAmmunition();
    InlineButton inlineButton = new InlineButton();
    Start start = new Start();
    Volunteering volunteering = new Volunteering();
    Menu menu = new Menu();

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
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(message.getChatId()));
        if (callbackQuery.getData().equals("CPR-Old")){
            editMessageText.setText(CPR.get_CPR_Old());
            messageSender.sendEditMessage(editMessageText);
        }else if (callbackQuery.getData().equals("CPR-Young")){
            editMessageText.setText(CPR.get_CPR_Young());
            messageSender.sendEditMessage(editMessageText);
        }else if(callbackQuery.getData().equals("CPR-Baby")) {
            editMessageText.setText(CPR.get_CPR_Baby());
            messageSender.sendEditMessage(editMessageText);
        }else if (callbackQuery.getData().equals("1EmergenciesInUkraine")){
            editMessageText.setText("facebook");
            messageSender.sendEditMessage(editMessageText);
        }else if (callbackQuery.getData().equals("4WeatherInUkraine")){
            editMessageText.setText("weather");
            messageSender.sendEditMessage(editMessageText);
        }else if (callbackQuery.getData().equals("Directory")){
            editMessageText.setText("facebook");
            messageSender.sendEditMessage(editMessageText);
        }else if (callbackQuery.getData().equals("InformationWhatToDo")){
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            sendPhoto.setPhoto(new InputFile("https://mkrada.gov.ua/files/GROMADIANI/1.jpg"));
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Lepestok")){
            sendPhoto.setPhoto(new InputFile("https://kremenchug.ua/uploads/posts/2022-03/thumbs/1647511814_bomba_danger_1.jpg"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("ClusterBomb")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275744138_4818974004882699_9186870680064444071_n.jpg?_nc_cat=111&ccb=1-6&_nc_sid=730e14&_nc_ohc=HEnfyofTNdIAX_OCySd&_nc_ht=scontent.fiev22-2.fna&oh=00_AT__2hRLwOqvlWwqI2zOmUQoy3zwtXq4d-9QJ8DGPY72kg&oe=627C0F92"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("Mortar")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275715354_4818974694882630_5510938058894636651_n.jpg?_nc_cat=102&ccb=1-6&_nc_sid=730e14&_nc_ohc=AyORwh3L4OUAX-y729K&_nc_ht=scontent.fiev22-2.fna&oh=00_AT8SOPHGzxANjXiZrN9ga-I6PJRfDwxc1_0B4BZCt2gFpw&oe=627BF53D"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("Rocket")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275785126_4818974468215986_6491329752657154785_n.jpg?_nc_cat=110&ccb=1-6&_nc_sid=730e14&_nc_ohc=4b4TGfz_TuYAX8cfy2M&_nc_ht=scontent.fiev22-2.fna&oh=00_AT8Wknb1otFrkqFB3VJj19RWJ2d5CLYp4sQgj6-wjVIKlA&oe=627CB6ED"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("GrenadeWithJetEngine")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275790399_4818974098216023_5647376408163105310_n.jpg?_nc_cat=111&ccb=1-6&_nc_sid=730e14&_nc_ohc=lXdZr90ELiEAX_JtJnH&tn=3OWEUHxk7hv7dzlD&_nc_ht=scontent.fiev22-2.fna&oh=00_AT_ZCIDC3bt-RS_13_wXhQuxjWJl8slKM2I1CXbFpAF8DA&oe=627D19B8"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("ArtilleryShell")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275783506_4818974298216003_7814587232735515488_n.jpg?_nc_cat=104&ccb=1-6&_nc_sid=730e14&_nc_ohc=ETETQ3T39fYAX8bwD_3&_nc_oc=AQl-dr0O384Q6eNgsKSV15Db-USdpJ904eIp7KIG0gc559GxH5gY1Z3s7dbXYoktIz0&_nc_ht=scontent.fiev22-2.fna&oh=00_AT913J36Yv1IXikcFCW8g-algR4_HsVK3tbdMBH8j7pq5w&oe=627C880F"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("Anti-tankMine")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275623395_4818974184882681_5578797307642555737_n.jpg?_nc_cat=104&ccb=1-6&_nc_sid=730e14&_nc_ohc=y_bzjYXvbPsAX-FA3qr&_nc_ht=scontent.fiev22-2.fna&oh=00_AT-h3hQlC-rAVHbpg4Sfh6Y2gLmEDI5gTtj8RTI4eULDrQ&oe=627C3833"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("Bomb")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275736489_4818974394882660_4553821503887768003_n.jpg?_nc_cat=111&ccb=1-6&_nc_sid=730e14&_nc_ohc=Ch_7YgnHspsAX_cY581&tn=3OWEUHxk7hv7dzlD&_nc_ht=scontent.fiev22-2.fna&oh=00_AT-ZYmYhjZjjpn9WBJHlCeXVtsx6R5u3sZksDZOM4DF_cA&oe=627D30DD"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("Anti-personnelMine")){
            sendPhoto.setPhoto(new InputFile("https://scontent.fiev22-2.fna.fbcdn.net/v/t39.30808-6/275736252_4818974491549317_1407139135651944330_n.jpg?_nc_cat=102&ccb=1-6&_nc_sid=730e14&_nc_ohc=rDIleyiEiI0AX8GlN9j&_nc_oc=AQmdU6pnx3VwTiZsO0bDVxGs6P4j8FEEy8-gkWWJRycYBHcuGttWBFuAYEsxl7itWkw&tn=3OWEUHxk7hv7dzlD&_nc_ht=scontent.fiev22-2.fna&oh=00_AT9QeSawGdQwA7J3gY2aBUhOGOlE_88auqvz9aSNuunh-g&oe=627C823D"));
            sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
            sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
            messageSender.sendPhoto(sendPhoto);
            messageSender.sendMessage(sendMessage);
        }else if(callbackQuery.getData().equals("CompleteReview")){
            sendMessage.setText("Натисніть щоб перейти в Меню");
            sendMessage.setReplyMarkup(start.getKeyboardStart());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("askVolunteering")){
            sendMessage.setText(volunteering.getVolunteeringQuestions());
            sendMessage.setReplyMarkup(inlineButton.getInlineQuestionsKeyboardMarkup());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("91")){
            sendMessage.setText(volunteering.getQuestionOne());
            sendMessage.setReplyMarkup(volunteering.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("92")){
            sendMessage.setText(volunteering.getQuestionTwo());
            sendMessage.setReplyMarkup(volunteering.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("93")){
            sendMessage.setText(volunteering.getQuestionThree());
            sendMessage.setReplyMarkup(volunteering.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("94")){
            sendMessage.setText(volunteering.getQuestionFour());
            sendMessage.setReplyMarkup(volunteering.getKeyboardVolunteering());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Мобільний пристрій")){
            sendMessage.setText("Надішліть вашу геолокацію для подальшої обробки\uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Персональний комп'ютер")){
            sendMessage.setText("Оберіть ваше місцезнаходження із запропонованого переліку областей України \uD83C\uDDFA\uD83C\uDDE6 \uD83D\uDC47");
            sendMessage.setReplyMarkup(inlineButton.getInlineLocationKeyboardMarkup());
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("АР Крим")){
            sendMessage.setText("Обрано місцезнаходження: АР Крим \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Вінницька")){
            sendMessage.setText("Обрано місцезнаходження: Вінницька область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Волинська")){
            sendMessage.setText("Обрано місцезнаходження: Волинська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Дніпропетровська")){
            sendMessage.setText("Обрано місцезнаходження: Дніпропетровська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Донецька")){
            sendMessage.setText("Обрано місцезнаходження: Донецька область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Житомирська")){
            sendMessage.setText("Обрано місцезнаходження: Житомирська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Закарпатська")){
            sendMessage.setText("Обрано місцезнаходження: Закарпатська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Запорізька")){
            sendMessage.setText("Обрано місцезнаходження: Запорізька область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Івано-Франківська")){
            sendMessage.setText("Обрано місцезнаходження: Івано-Франківська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Київська")){
            sendMessage.setText("Обрано місцезнаходження: Київська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Кіровоградська")){
            sendMessage.setText("Обрано місцезнаходження: Кіровоградська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Луганська")){
            sendMessage.setText("Обрано місцезнаходження: Луганська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Львівська")){
            sendMessage.setText("Обрано місцезнаходження: Львівська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Миколаїівська")){
            sendMessage.setText("Обрано місцезнаходження: Миколаїівська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Одеська")){
            sendMessage.setText("Обрано місцезнаходження: Одеська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Полтавська")){
            sendMessage.setText("Обрано місцезнаходження: Полтавська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Рівненська")){
            sendMessage.setText("Обрано місцезнаходження: Рівненська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Сумська")){
            sendMessage.setText("Обрано місцезнаходження: Сумська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Тернопільська")){
            sendMessage.setText("Обрано місцезнаходження: Тернопільська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Харківська")){
            sendMessage.setText("Обрано місцезнаходження: Харківська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Херсонська")){
            sendMessage.setText("Обрано місцезнаходження: Херсонська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Хмельницька")){
            sendMessage.setText("Обрано місцезнаходження: Хмельницька область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Черкаська")){
            sendMessage.setText("Обрано місцезнаходження: Черкаська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Чернівецька")){
            sendMessage.setText("Обрано місцезнаходження: Чернівецька область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }else if (callbackQuery.getData().equals("Чернігівська")){
            sendMessage.setText("Обрано місцезнаходження: Чернігівська область \uD83D\uDCCD");
            messageSender.sendMessage(sendMessage);
        }
    }
}
