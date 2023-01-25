package LDUBGD.DSNS.handlers;

import LDUBGD.DSNS.model.Hromady;
import LDUBGD.DSNS.model.UserLogin;
import LDUBGD.DSNS.repository.HromadyRepository;
import LDUBGD.DSNS.repository.UserLoginRepository;
import LDUBGD.DSNS.services.ActionInEmergencies;
import LDUBGD.DSNS.aid.*;
import LDUBGD.DSNS.services.OurFacebook;
import LDUBGD.DSNS.inspector.Inspector;
import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.services.PsychologicalHelp;
import LDUBGD.DSNS.services.InlineButton;
import LDUBGD.DSNS.services.Menu;
import LDUBGD.DSNS.services.Start;
import LDUBGD.DSNS.services.Source;
import LDUBGD.DSNS.services.PlacesOfSupport;
import LDUBGD.DSNS.services.Volunteering;
import LDUBGD.DSNS.services.WeaponsAndAmmunition;
import LDUBGD.DSNS.services.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MessageHandler implements Handler<Message> {
    private final MessageSender messageSender;

    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    HromadyRepository hromadyRepository;

    public MessageHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    //екземпляри класів
    Start start = new Start();
    Menu menu = new Menu();
    FirstAidMenu firstAidMenu = new FirstAidMenu();
    Bleeding bleeding = new Bleeding();
    BoneInjuries boneInjuries = new BoneInjuries();
    Burns burns = new Burns();
    CardiopulmonaryResuscitation CPR = new CardiopulmonaryResuscitation();
    ChestInjury chestInjury = new ChestInjury();
    GunshotWound gunshotWound = new GunshotWound();
    SpineInjury spineInjury = new SpineInjury();
    TraumaticBrainInjury traumaticBrainInjury = new TraumaticBrainInjury();
    OurFacebook ourFacebook = new OurFacebook();
    Weather weather = new Weather();
    Source source = new Source();
    Inspector inspector = new Inspector();
    PlacesOfSupport placesOfSupport = new PlacesOfSupport();
    PsychologicalHelp psychologicalHelp = new PsychologicalHelp();
    ActionInEmergencies actionInEmergencies = new ActionInEmergencies();
    WeaponsAndAmmunition weaponsAndAmmunition = new WeaponsAndAmmunition();
    InlineButton inlineButton = new InlineButton();
    Volunteering volunteering = new Volunteering();

    @Override
    public void choose(Message message) {
        Long userId = message.getFrom().getId();
        Optional<UserLogin> optionalUserLogin = userLoginRepository.findByTelegramId(userId);
        UserLogin userLogin;
        if(!optionalUserLogin.isPresent()){
            userLogin = new UserLogin(userId);
        }else {
            userLogin = optionalUserLogin.get();
        }
        if(message.hasLocation()){
            Location location = message.getLocation();
            userLogin.setX(location.getLongitude());
            userLogin.setY(location.getLatitude());
            List<Hromady> hromady = hromadyRepository.hromada(userLogin.getX(), userLogin.getY());
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            if(!hromady.isEmpty()){
                Hromady hromada = hromady.get(0);
                userLogin.setHromada(hromada);
                sendMessage.setText(String.format("%s%n%s",hromada.getRayon(), hromada.getHromada()));
            }else {
                sendMessage.setText(String.format("Громаду не знайдено (%s:%s)",userLogin.getX(), userLogin.getY()));
            }
            messageSender.sendMessage(sendMessage);
            log.info(message.getLocation().toString());
            userLoginRepository.save(userLogin);
        }
        if(message.hasContact()){
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
            SendMessage sendOtherMessage = new SendMessage();
            sendOtherMessage.setChatId(String.valueOf(message.getChatId()));
            //надсилання фото в конкретний чат
            SendPhoto sendPhoto = new SendPhoto();
            SendPhoto sengPhotoTwo = new SendPhoto();
            SendPhoto sendPhotoThree = new SendPhoto();
            sendPhoto.setChatId(String.valueOf(message.getChatId()));
            sengPhotoTwo.setChatId(String.valueOf(message.getChatId()));
            sendPhotoThree.setChatId(String.valueOf(message.getChatId()));

            switch (message.getText()) {

                //старт програми
                case "/start":
                    sendMessage.setText(start.getStart());
                    ReplyKeyboardMarkup keyboardStart;
                    if (optionalUserLogin.isPresent()){
                        keyboardStart = start.getKeyboardStart();
                    }else {
                        keyboardStart = start.keyboardNewStart();
                    }
                    sendMessage.setReplyMarkup(keyboardStart);
                    break;
                //встановити місцезнаходження
                case "/set_location":
                    sendMessage.setText("Оберіть тип вашого пристрою \uD83D\uDC47");
                    sendMessage.setReplyMarkup(inlineButton.getInlineTypeOfDeviceKeyboardMarkup());
                    break;
                case "Поділитись розташуванням":
                    sendMessage.setText("Оберіть ваше місцезнаходження із запропонованого переліку областей України \uD83C\uDDFA\uD83C\uDDE6 \uD83D\uDC47");
                    sendMessage.setReplyMarkup(inlineButton.getInlineLocationKeyboardMarkup());
                    messageSender.sendMessage(sendMessage);
                    break;
                //меню
                case "Меню":
                    sendMessage.setText(menu.getMenu());
                    ReplyKeyboardMarkup keyboardMenu = menu.getKeyboardMenu();
                    sendMessage.setReplyMarkup(keyboardMenu);
                    break;
                // надзвичайні ситуації в Україні / новини
                case "1":
                case "5":
                    sendOtherMessage.setText(ourFacebook.getOurFacebook());
                    sendOtherMessage.setReplyMarkup(ourFacebook.getInlineFacebookKeyboardMarkup());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText(ourFacebook.getClockToMenu());
                    sendMessage.setReplyMarkup(menu.getKeyboardButtonMenu());
                    break;
                //що робити в надзвичайній ситуації
                case "2":
                    sendMessage.setText(actionInEmergencies.getActionImEmergencies());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardActionInEmergencies());
                    break;
                //приготуватися в дома
                case "201":
                    sendMessage.setText(actionInEmergencies.getHome());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //мінімізація ризику загубитися членам сім'ї
                case "202":
                    sendMessage.setText(actionInEmergencies.getMinRisk());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //екстрена валіза
                case "203":
                    sendOtherMessage.setText(actionInEmergencies.getEmergencySuitcasePartOne());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText(actionInEmergencies.getEmergencySuitcasePartTwo());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //завантажити додаток повітряна тривога
                case "204":
                    sendMessage.setText(actionInEmergencies.getDownloadAirAlarm());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час сигналу"Увага всім"
                case "205":
                    sendMessage.setText(actionInEmergencies.getActionsDuringAirAlarm());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час війни
                case "206":
                    sendMessage.setText((actionInEmergencies.getActionsDuringWar()));
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час обстрілу стрілецькою зброєю
                case "207":
                    sendMessage.setText(actionInEmergencies.getActionsDuringShelling());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час артобстрілу
                case "208":
                    sendMessage.setText(actionInEmergencies.getActionsDuringArtilleryShelling());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //що має бути в аптечці
                case "209":
                    sendMessage.setText(actionInEmergencies.getFirstAidKit());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дитячий страх
                case "210":
                    sendMessage.setText(actionInEmergencies.getChildFear());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //обвал будинку
                case "211":
                    sendMessage.setText("Що робити, якщо стався  завал у будинку!");
                    sendPhoto.setPhoto(new InputFile("https://static.nv.ua/shared/system/MediaPhoto/images/000/222/373/medium/7b379024cfba0c0818e24fbff3feca31.png?q=85&stamp=20220304132827&f=jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //підозрілий предмет чи вибухівка
                case "212":
                    sendMessage.setText(actionInEmergencies.getExplosiveObject());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //небезпека вибуху
                case "213":
                    sendMessage.setText(actionInEmergencies.getThreadOfExplosion());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //центр допомоги біженцям
                case "214":
                    sendMessage.setText("❗️\"Гарячі лінії\" та центри допомоги евакуйованим та біженцям");
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    sendPhoto.setPhoto(new InputFile("https://pbs.twimg.com/media/FNEnNKKWQAEkHpM.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //правила поведінки під час комендантської години
                case "215":
                    sendMessage.setText("❗️Правила поведінки під час комендантської години");
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    sendPhoto.setPhoto(new InputFile("https://img.tsn.ua/cached/963/tsn-2e5933e84c8f120777c30b7610ecadcd/thumbs/608xX/37/bd/06a999c525133d5802ebabbccfc2bd37.jpeg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //дії під час обстрілу житлового будинку
                case "216":
                    sendMessage.setText(actionInEmergencies.getActionsDuringHomeShelling());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //карта радіаційного фону
                case "217":
                    sendMessage.setText(actionInEmergencies.getRadiationMap());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії у випадку радіаційної загрози
                case "218":
                    sendMessage.setText(actionInEmergencies.getActionsDuringRadiationEmergency());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час хімічної загрози
                case "219":
                    sendMessage.setText(actionInEmergencies.getChemicalEmergency());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час повернення додому після радіаційної небезпеки
                case "220":
                    sendMessage.setText(actionInEmergencies.getActionsDuringReturnHomeAfterRadiation());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //як не стати жертвою дезінформації
                case "221":
                    sendMessage.setText(actionInEmergencies.getDisinformation());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //комунікація за відсутності мобільного зв'язку
                case "222":
                    sendOtherMessage.setText(actionInEmergencies.getCommunicationPartOne());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText(actionInEmergencies.getCommunicationPartTwo());
                    sendMessage.setReplyMarkup(actionInEmergencies.getKeyboardReturnActionInEmergencies());
                    break;
                //пункти допомоги населенню
                case "3":
                    sendMessage.setText(placesOfSupport.getPlacesOfSupport());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardSupport());
                    break;
                //укриття
                case "301":
                    sendMessage.setText(placesOfSupport.getShelters());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardShelters());
                    break;
                case "Київ":
                    sendMessage.setText(placesOfSupport.getKyiv());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Київська область":
                    sendMessage.setText(placesOfSupport.getKyivRegion());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Львів":
                    sendMessage.setText(placesOfSupport.getLviv());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Харків":
                    sendMessage.setText(placesOfSupport.getKharkiv());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Одеса":
                    sendMessage.setText(placesOfSupport.getOdesa());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Луцьк":
                    sendMessage.setText(placesOfSupport.getLutsk());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Полтава":
                    sendMessage.setText(placesOfSupport.getPoltava());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Івано-Франківськ":
                    sendMessage.setText(placesOfSupport.getIvanoFrankivsk());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Тернопіль":
                    sendMessage.setText(placesOfSupport.getTernopil());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Чернігів":
                    sendMessage.setText(placesOfSupport.getChernihiv());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Вінниця":
                    sendMessage.setText(placesOfSupport.getVinnitsa());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Рівне":
                    sendMessage.setText(placesOfSupport.getRivne());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Дніпро":
                    sendMessage.setText(placesOfSupport.getDnipro());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Житомир":
                    sendMessage.setText(placesOfSupport.getZhytomyr());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Чернівці":
                    sendMessage.setText(placesOfSupport.getChernivtsi());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Запоріжжя":
                    sendMessage.setText(placesOfSupport.getZaporizhzhia());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Черкаси":
                    sendMessage.setText(placesOfSupport.getCherkasy());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Миколаїв":
                    sendMessage.setText(placesOfSupport.getMykolaiv());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Кропивницький":
                    sendMessage.setText(placesOfSupport.getKropyvnytskyi());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Суми":
                    sendMessage.setText(placesOfSupport.getSumy());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Ужгород":
                    sendMessage.setText(placesOfSupport.getUzhhorod());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Херсон":
                    sendMessage.setText(placesOfSupport.getKherson());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Хмельницький":
                    sendMessage.setText(placesOfSupport.getKhmelnytskyi());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Донецьк":
                    sendMessage.setText(placesOfSupport.getDonetsk());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Луганськ":
                    sendMessage.setText(placesOfSupport.getLuhansk());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                //гуманітарна допомога
                case "302":
                    sendMessage.setText(placesOfSupport.getHumanitarianHelp());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                //служби розшуку
                case "303":
                    sendMessage.setText(placesOfSupport.getSearchService());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                //лікарі
                case "304":
                    sendMessage.setText(placesOfSupport.getDoctors());
                    sendMessage.setReplyMarkup(placesOfSupport.getKeyboardReturnPlacesOfSupport());
                    break;
                // погода
                case "4":
                    sendOtherMessage.setText(weather.getWeatherInUkraine());
                    sendOtherMessage.setReplyMarkup(weather.getInlineWeatherKeyboardMarkup());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText(ourFacebook.getClockToMenu());
                    sendMessage.setReplyMarkup(menu.getKeyboardButtonMenu());
                    break;
                //джерела інформації
                case "6":
                    sendMessage.setText(source.getSource());
                    sendMessage.setReplyMarkup(menu.getKeyboardButtonMenu());
                    break;
                // перша допомога
                case "7":
                    sendMessage.setText("\uD83E\uDD15 Перша допомога");
                    ReplyKeyboardMarkup keyboardFirstAidMenu = firstAidMenu.getKeyboardAidMenu();
                    sendMessage.setReplyMarkup(keyboardFirstAidMenu);
                    break;
                case "Серцево-легенева реанімація\uD83E\uDEC0\uD83E\uDEC1️":
                    sendMessage.setText(CPR.get_CPR());
                    ReplyKeyboardMarkup replyCPRKeyboardMarkup = CPR.getKeyboardCPR();
                    sendMessage.setReplyMarkup(replyCPRKeyboardMarkup);
                    break;
                case "Дорослий\uD83D\uDC68\uD83C\uDFFC":
                    sendMessage.setText(CPR.get_CPR_Old());
                    sendPhoto.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/serdechno-legochnaja-reanimacija-2.png"));
                    sengPhotoTwo.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/neprjamoj-massazh-serdca-1.png"));
                    sendPhotoThree.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/iskusstvennoe-dyhanie-3.png"));
                    messageSender.sendPhoto(sendPhoto);
                    messageSender.sendPhoto(sengPhotoTwo);
                    messageSender.sendPhoto(sendPhotoThree);
                    break;
                case "Дитина\uD83D\uDC66\uD83C\uDFFC":
                    sendMessage.setText(CPR.get_CPR_Young());
                    break;
                case "Немовля\uD83D\uDC76\uD83C\uDFFC":
                    sendMessage.setText(CPR.get_CPR_Baby());
                    sendPhoto.setPhoto(new InputFile("https://i0.wp.com/tv5.zp.ua/wp-content/uploads/2019/04/SLR-ditini.jpg?fit=500%2C334&ssl=1"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //кровотеча
                case "Кровотеча\uD83E\uDE78":
                    sendMessage.setText(bleeding.getBleeding());
                    ReplyKeyboardMarkup keyboardBleeding = bleeding.getKeyboardBleeding();
                    sendMessage.setReplyMarkup(keyboardBleeding);
                    break;
                case "Зовнішня кровотеча\uD83C\uDFE5":
                    sendMessage.setText(bleeding.getExternalBleeding());
                    ReplyKeyboardMarkup keyboardExternalBleeding = bleeding.getKeyboardExternalBleeding();
                    sendMessage.setReplyMarkup(keyboardExternalBleeding);
                    break;
                case "Внутрішня кровотеча\uD83C\uDFE5":
                    sendMessage.setText(bleeding.getInternalBleeding());
                    break;
                case "Ампутація кінцівки\uD83C\uDFE5":
                    sendMessage.setText(bleeding.getLimbAmputation());
                    break;
                case "Кінцівки\uD83E\uDDB5":
                    sendMessage.setText(bleeding.getLimbBleeding());
                    break;
                case "Голова/Шия\uD83D\uDC64":
                    sendMessage.setText(bleeding.getHeadNeckBleeding());
                    sendPhoto.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/nalozhenie-davjashhej-povjazki-na-sheju.png"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                case "Живіт\uD83E\uDDCD\uD83C\uDFFC\u200D♂️":
                    sendMessage.setText(bleeding.getBodeBleeding());
                    break;
                //опіки/обмороження
                case "Опіки/Обмороження⛑":
                    sendMessage.setText(burns.getBurns());
                    ReplyKeyboardMarkup keyboardBurns = burns.getKeyboardBurns();
                    sendMessage.setReplyMarkup(keyboardBurns);
                    break;
                case "Термічний опік\uD83C\uDF21":
                    sendMessage.setText(burns.getThermalBurns());
                    break;
                case "Хімічний опік⚠️":
                    sendMessage.setText(burns.getChemicalBurns());
                    break;
                case "Електричний опік⚡️":
                    sendMessage.setText(burns.getElectricBurns());
                    break;
                case "Обмороження\uD83E\uDD76":
                    sendMessage.setText(burns.getFrostbite());
                    break;
                //вогневе поранення
                case "Вогнепальне поранення\uD83D\uDD2B":
                    sendMessage.setText(gunshotWound.getGunshotWound());
                    //inline повідомлення
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    break;
                //ЧМТ
                case "Черепно-мозкова травма\uD83E\uDDE0":
                    sendMessage.setText(traumaticBrainInjury.getTraumaticBrainInjury());
                    //inline повідомлення
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    break;
                //травми кісток
                case "Травми кісток\uD83E\uDDB4":
                    sendMessage.setText(boneInjuries.getBoneInjuries());
                    ReplyKeyboardMarkup keyboardBone = boneInjuries.getKeyboardBoneInjuries();
                    sendMessage.setReplyMarkup(keyboardBone);
                    break;
                case "\uD83D\uDD39Відкритий перелом":
                    sendMessage.setText(boneInjuries.getOpenFracture());
                    break;
                case "\uD83D\uDD39Закритий перелом":
                    sendMessage.setText(boneInjuries.getClosedFracture());
                    break;
                case "\uD83D\uDD39Вивих":
                    sendMessage.setText(boneInjuries.getDislocation());
                    break;
                //травми грудної клітки
                case "Травми грудної клітки\uD83D\uDC55": {
                    sendMessage.setText(chestInjury.getChestInjury());
                    ReplyKeyboardMarkup keyboardChest = chestInjury.getKeyboardChest();
                    sendMessage.setReplyMarkup(keyboardChest);
                    break;
                }
                //проникаюча травма
                case "Проникаюча травма\uD83D\uDD2A":
                    sendMessage.setText(chestInjury.getPenetratingInjury());
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    sendPhoto.setPhoto(new InputFile("https://olgrad.kiev.ua/wp-content/uploads/zachem-nuzhna-okkluzivnaya-povyazka.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //закрита травма
                case "Закрита травма⛑":
                    sendMessage.setText(chestInjury.getClosedInjury());
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    break;
                //травма хребта
                case "Травми хребта⚠️":
                    sendMessage.setText(spineInjury.getSpineInjury());
                    ReplyKeyboardMarkup keyboardSpine = spineInjury.getKeyboardSpine();
                    sendMessage.setReplyMarkup(keyboardSpine);
                    break;
                //безпечне місце
                case "Безпечне місце⛑":
                    sendMessage.setText(spineInjury.getSafelyPlace());
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    sendPhoto.setPhoto(new InputFile("https://adst.mp.pl/s/empendium/img_zoom/B27/23.8-4.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //небезпечне місце
                case "Небезпечне місце⚠️":
                    sendMessage.setText(spineInjury.getDangerPlace());
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    sendPhoto.setPhoto(new InputFile("https://adst.mp.pl/s/empendium/img_zoom/B27/23.8-4.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //довідник
                case "Довідник":
                    sendMessage.setText("Довідник для населення з надання Першої Допомоги");
                    sendMessage.setReplyMarkup(inlineButton.getInlineDirectoryKeyboardMarkup());
                    break;
                //лікар
                case "Лікар":
                    sendMessage.setText(placesOfSupport.getDoctors());
                    break;
                //повернутися
                case "Повернутися⬅":
                    sendMessage.setText("Що трапилось?");
                    ReplyKeyboardMarkup keyboardReturn = firstAidMenu.getKeyboardAidMenu();
                    sendMessage.setReplyMarkup(keyboardReturn);
                    break;
                //психологічна допомога
                case "8":
                    sendMessage.setText(psychologicalHelp.getPsychologicalHelp());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardPsychologicalHelp());
                    break;
                //алгоритм надання психологічної допомоги
                case "80":
                    sendPhoto.setPhoto(new InputFile("https://ldn.org.ua/wp-content/uploads/2022/04/111-724x1024.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    sendMessage.setText(psychologicalHelp.getAlgorithmPsychologicalHelp());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardReturnPsychologicalHelp());
                    break;
                //страх
                case "81":
                    sendMessage.setText(psychologicalHelp.getFear());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardReturnPsychologicalHelp());
                    break;
                //плач
                case "82":
                    sendMessage.setText(psychologicalHelp.getWeep());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardReturnPsychologicalHelp());
                    break;
                //агресія
                case "83":
                    sendMessage.setText(psychologicalHelp.getAggression());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardReturnPsychologicalHelp());
                    break;
                //паніка
                case "84":
                    sendMessage.setText(psychologicalHelp.getPanic());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardReturnPsychologicalHelp());
                    break;
                //ступор
                case "85":
                    sendMessage.setText(psychologicalHelp.getStupor());
                    sendMessage.setReplyMarkup(psychologicalHelp.getKeyboardReturnPsychologicalHelp());
                    break;
                //волонтерство
                case "9":
                    sendPhoto.setPhoto(new InputFile("http://www.visti.rovno.ua/img/650/zapishis-v-dobrovoltsi-z-tsivilnoho-zakhistu-dopom20220425_5166.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    sendOtherMessage.setText("\uD83D\uDC69\u200D\uD83D\uDE92Запишись в добровольці з цивільного захисту - допоможи країні❗️");
                    sendOtherMessage.setReplyMarkup(menu.getKeyboardButtonMenu());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText(volunteering.getVolunteering());
                    sendMessage.setReplyMarkup(inlineButton.getInlineVolunteeringKeyboardMarkup());
                    break;
                case "Інші питання":
                    sendMessage.setText(volunteering.getVolunteeringQuestions());
                    sendMessage.setReplyMarkup(inlineButton.getInlineQuestionsKeyboardMarkup());
                    break;
                //зброя та боєприпаси: дії після знаходження
                case "10":
                    sendPhoto.setPhoto(new InputFile("https://mkrada.gov.ua/files/GROMADIANI/1.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    sendMessage.setText(weaponsAndAmmunition.getActionsFindWeapons());
                    sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
                    break;
                //інтерактивний інспектор
                case "11":
                    sendMessage.setText(inspector.getInspector());
                    sendMessage.setReplyMarkup(menu.getKeyboardButtonMenu());
                    break;
                default:
                    sendMessage.setText("Введено не коректні дані: '" + message.getText() + "' Спробуйте ще раз!");
            }
            //відправлення повідомлення
            messageSender.sendMessage(sendMessage);
        }

    }
}
