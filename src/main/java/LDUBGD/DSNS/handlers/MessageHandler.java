package LDUBGD.DSNS.handlers;

import LDUBGD.DSNS.inspector.Inspector;
import LDUBGD.DSNS.messagesender.MessageSender;
import LDUBGD.DSNS.model.Community;
import LDUBGD.DSNS.model.UserLogin;
import LDUBGD.DSNS.repository.*;
import LDUBGD.DSNS.services.InlineButton;
import LDUBGD.DSNS.services.ReplyKeyboard;
import LDUBGD.DSNS.services.ScheduledTasks;
import LDUBGD.DSNS.services.Start;
import lombok.Getter;
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

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MessageHandler implements Handler<Message> {
    @Getter
    private final MessageSender messageSender;

    @Autowired
    UserLoginRepository userLoginRepository;


    @Autowired
    FirstAidRepository firstAidRepository;
    CommunityRepository communityRepository;

    @Autowired
    ScheduledTasks scheduledTasks;

    @Autowired
    ActionInEmergenciesRepository replyKeyboardRepository;

    @Autowired
    PlacesOfSupportRepository placesOfSupportRepository;

    @Autowired
    PsychologicalHelpRepository psychologicalHelpRepository;

    @Autowired
    VolunteeringRepository volunteeringRepository;

    @Autowired
    ServiceRepository serviceRepository;

    public MessageHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    //екземпляри класів
    Start start = new Start();
    ReplyKeyboard replyKeyboard = new ReplyKeyboard();
    Inspector inspector = new Inspector();
    InlineButton inlineButton = new InlineButton();

    @Override
    public void choose(Message message) {
        Long userId = message.getFrom().getId();
        Optional<UserLogin> optionalUserLogin = userLoginRepository.findByTelegramId(userId);
        UserLogin userLogin;
        if (!optionalUserLogin.isPresent()) {
            userLogin = new UserLogin(userId, message.getChatId());
        } else {
            userLogin = optionalUserLogin.get();
            if(userLogin.getChatId() == null){
                userLogin.setChatId(message.getChatId());
            }
        }
        if(message.hasLocation()){
            Location location = message.getLocation();
            userLogin.setX(location.getLongitude());
            userLogin.setY(location.getLatitude());
            List<Community> community = communityRepository.community(userLogin.getX(), userLogin.getY());
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            if (!community.isEmpty()) {
                Community hromada = community.get(0);
                userLogin.setRegion(hromada);
                sendMessage.setText(String.format("%s%n%s", hromada.getDistrict(), hromada.getCommunity()));
            } else {
                sendMessage.setText(String.format("Громаду не знайдено (%s:%s)", userLogin.getX(), userLogin.getY()));
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

                case "Поділитись розташуванням":
                    log.info("isUserChat :{}",message.getChat().isUserChat());
                    sendMessage.setText("Оберіть ваше місцезнаходження із запропонованого переліку областей України \uD83C\uDDFA\uD83C\uDDE6 \uD83D\uDC47");
                    sendMessage.setReplyMarkup(inlineButton.getInlineLocationKeyboardMarkup());
                    messageSender.sendMessage(sendMessage);
                    break;
                case "Моя громада":
                    if (!optionalUserLogin.isPresent()) {
                        return;
                    } else {
                        userLogin = optionalUserLogin.get();
                    }
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    Community hromada = userLogin.getRegion();
                    sendMessage.setText(String.format("%s%n%s%n%s",
                            hromada.getDistrict(),
                            hromada.getCommunity(),
                            scheduledTasks.getAlert("351")));
                    // TODO: 03.02.23 Відображення контурів громади
//                    SendPhoto sendPhoto = SendPhoto.builder()
//                            .chatId(user.getChatId())
//                            .photo(new InputFile(getJpg(),"dd"))
////                                .caption(caption)
////                                .parseMode(ParseMode.HTML)
//                            .build();

                    InputStream jpg = scheduledTasks.getJpg(hromada.getId());
                    if (jpg != null) {
                        sendPhoto.setPhoto(new InputFile(jpg,"dd"));
                    }

                    messageSender.sendPhoto(sendPhoto);
                    break;
                //меню
                case "Меню":
                    String dBMenu = serviceRepository.getMenu();
                    sendMessage.setText(dBMenu);
                    ReplyKeyboardMarkup keyboardMenu = replyKeyboard.getKeyboardMenu();
                    sendMessage.setReplyMarkup(keyboardMenu);
                    break;
                // надзвичайні ситуації в Україні / новини
                case "1":
                case "5":
                    String dBOurFacebook = serviceRepository.getOurFacebook();
                    sendOtherMessage.setText(dBOurFacebook);
                    sendOtherMessage.setReplyMarkup(inlineButton.getInlineFacebookKeyboardMarkup());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText("Натисніть щоб перейти в Меню");
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardButtonMenu());
                    break;
                //що робити в надзвичайній ситуації
                case "2":
                    String dBActionEmergencies = replyKeyboardRepository.getActionEmergencies();
                    sendMessage.setText(dBActionEmergencies);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardActionInEmergencies());
                    break;
                //приготуватися в дома
                case "201":
                    String dBHome = replyKeyboardRepository.getHome();
                    sendMessage.setText(dBHome);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //мінімізація ризику загубитися членам сім'ї
                case "202":
                    String dBMinRisk = replyKeyboardRepository.getMinRisk();
                    sendMessage.setText(dBMinRisk);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //екстрена валіза
                case "203":
                    String dBEmergencySuitcasePartOne = replyKeyboardRepository.getEmergencySuitcasePartOne();
                    sendOtherMessage.setText(dBEmergencySuitcasePartOne);
                    messageSender.sendMessage(sendOtherMessage);
                    String dBEmergencySuitcasePartTwo = replyKeyboardRepository.getEmergencySuitcasePartTwo();
                    sendMessage.setText(dBEmergencySuitcasePartTwo);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //завантажити додаток повітряна тривога
                case "204":
                    String dBDownloadAirAlarm = replyKeyboardRepository.getDownloadAirAlarm();
                    sendMessage.setText(dBDownloadAirAlarm);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час сигналу"Увага всім"
                case "205":
                    String dBActionsDuringAirAlarm = replyKeyboardRepository.getActionsDuringAirAlarm();
                    sendMessage.setText(dBActionsDuringAirAlarm);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час війни
                case "206":
                    String dBActionsDuringWar = replyKeyboardRepository.getActionsDuringWar();
                    sendMessage.setText(dBActionsDuringWar);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час обстрілу стрілецькою зброєю
                case "207":
                    String dBActionsDuringShelling = replyKeyboardRepository.getActionsDuringShelling();
                    sendMessage.setText(dBActionsDuringShelling);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час артобстрілу
                case "208":
                    String dBActionsDuringArtilleryShelling = replyKeyboardRepository.getActionsDuringArtilleryShelling();
                    sendMessage.setText(dBActionsDuringArtilleryShelling);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //що має бути в аптечці
                case "209":
                    String dBFirstAidKit = replyKeyboardRepository.getFirstAidKit();
                    sendMessage.setText(dBFirstAidKit);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дитячий страх
                case "210":
                    String dBChildFear = replyKeyboardRepository.getChildFear();
                    sendMessage.setText(dBChildFear);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //обвал будинку
                case "211":
                    sendMessage.setText("Що робити, якщо стався  завал у будинку!");
                    sendPhoto.setPhoto(new InputFile("https://static.nv.ua/shared/system/MediaPhoto/images/000/222/373/medium/7b379024cfba0c0818e24fbff3feca31.png?q=85&stamp=20220304132827&f=jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //підозрілий предмет чи вибухівка
                case "212":
                    String dBExplosiveObject = replyKeyboardRepository.getExplosiveObject();
                    sendMessage.setText(dBExplosiveObject);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //небезпека вибуху
                case "213":
                    String dBThreadOfExplosion = replyKeyboardRepository.getThreadOfExplosion();
                    sendMessage.setText(dBThreadOfExplosion);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //центр допомоги біженцям
                case "214":
                    sendMessage.setText("❗️\"Гарячі лінії\" та центри допомоги евакуйованим та біженцям");
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    sendPhoto.setPhoto(new InputFile("https://pbs.twimg.com/media/FNEnNKKWQAEkHpM.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //правила поведінки під час комендантської години
                case "215":
                    sendMessage.setText("❗️Правила поведінки під час комендантської години");
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    sendPhoto.setPhoto(new InputFile("https://img.tsn.ua/cached/963/tsn-2e5933e84c8f120777c30b7610ecadcd/thumbs/608xX/37/bd/06a999c525133d5802ebabbccfc2bd37.jpeg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //дії під час обстрілу житлового будинку
                case "216":
                    String dBActionsDuringHomeShelling = replyKeyboardRepository.getActionsDuringHomeShelling();
                    sendMessage.setText(dBActionsDuringHomeShelling);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //карта радіаційного фону
                case "217":
                    String dBRadiationMap = replyKeyboardRepository.getRadiationMap();
                    sendMessage.setText(dBRadiationMap);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії у випадку радіаційної загрози
                case "218":
                    String dBActionsDuringRadiationEmergency = replyKeyboardRepository.getActionsDuringRadiationEmergency();
                    sendMessage.setText(dBActionsDuringRadiationEmergency);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час хімічної загрози
                case "219":
                    String dBChemicalEmergency = replyKeyboardRepository.getChemicalEmergency();
                    sendMessage.setText(dBChemicalEmergency);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //дії під час повернення додому після радіаційної небезпеки
                case "220":
                    String dBActionsDuringReturnHomeAfterRadiation = replyKeyboardRepository.getReturnHomeAfterRadiation();
                    sendMessage.setText(dBActionsDuringReturnHomeAfterRadiation);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //як не стати жертвою дезінформації
                case "221":
                    String dBDisinFormation = replyKeyboardRepository.getDisinFormation();
                    sendMessage.setText(dBDisinFormation);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //комунікація за відсутності мобільного зв'язку
                case "222":
                    String dBCommunication = replyKeyboardRepository.getCommunication();
                    sendMessage.setText(dBCommunication);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnActionInEmergencies());
                    break;
                //пункти допомоги населенню
                case "3":
                    String dBPlacesOfSupport = placesOfSupportRepository.getSupportPlaces();
                    sendMessage.setText(dBPlacesOfSupport);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardSupport());
                    break;
                //укриття
                case "301":
                    String dBShelters = placesOfSupportRepository.getShelters();
                    sendMessage.setText(dBShelters);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardShelters());
                    break;
                case "Київ":
                    String dBKyiv = placesOfSupportRepository.getKyiv();
                    sendMessage.setText(dBKyiv);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Київська область":
                    String dBKyiv_region = placesOfSupportRepository.getKyivRegion();
                    sendMessage.setText(dBKyiv_region);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Львів":
                    String dBLviv = placesOfSupportRepository.getLviv();
                    sendMessage.setText(dBLviv);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Харків":
                    String dBKharkiv = placesOfSupportRepository.getKharkiv();
                    sendMessage.setText(dBKharkiv);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Одеса":
                    String dBOdesa = placesOfSupportRepository.getOdesa();
                    sendMessage.setText(dBOdesa);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Луцьк":
                    String dBLutsk = placesOfSupportRepository.getLutsk();
                    sendMessage.setText(dBLutsk);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Полтава":
                    String dBPoltava = placesOfSupportRepository.getPoltava();
                    sendMessage.setText(dBPoltava);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Івано-Франківськ":
                    String dBIvanofrankivsk = placesOfSupportRepository.getIvanofrankivsk();
                    sendMessage.setText(dBIvanofrankivsk);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Тернопіль":
                    String dBTernopil = placesOfSupportRepository.getTernopil();
                    sendMessage.setText(dBTernopil);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Чернігів":
                    String dBChernihiv = placesOfSupportRepository.getChernihiv();
                    sendMessage.setText(dBChernihiv);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Вінниця":
                    String dBVinnitsa = placesOfSupportRepository.getVinnitsa();
                    sendMessage.setText(dBVinnitsa);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Рівне":
                    String dBRivne = placesOfSupportRepository.getRivne();
                    sendMessage.setText(dBRivne);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Дніпро":
                    String dBDnipro = placesOfSupportRepository.getDnipro();
                    sendMessage.setText(dBDnipro);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Житомир":
                    String dBZhytomyr = placesOfSupportRepository.getZhytomyr();
                    sendMessage.setText(dBZhytomyr);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Чернівці":
                    String dBChernivtsi = placesOfSupportRepository.getChernivtsi();
                    sendMessage.setText(dBChernivtsi);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Запоріжжя":
                    String dBZaporizhzhia = placesOfSupportRepository.getZaporizhzhia();
                    sendMessage.setText(dBZaporizhzhia);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Черкаси":
                    String dBCherkasy = placesOfSupportRepository.getCherkasy();
                    sendMessage.setText(dBCherkasy);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Миколаїв":
                    String dBMykolaiv =  placesOfSupportRepository.getMykolaiv();
                    sendMessage.setText(dBMykolaiv);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Кропивницький":
                    String dBKropyvnytskiy = placesOfSupportRepository.getKropyvnytskiy();
                    sendMessage.setText(dBKropyvnytskiy);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Суми":
                    String dBSumy = placesOfSupportRepository.getSumy();
                    sendMessage.setText(dBSumy);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Ужгород":
                    String dBUzhhorod = placesOfSupportRepository.getUzhgorod();
                    sendMessage.setText(dBUzhhorod);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Херсон":
                    String dBKherson = placesOfSupportRepository.getKherson();
                    sendMessage.setText(dBKherson);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Хмельницький":
                    String dBKhmelnytskyi = placesOfSupportRepository.getKhmelnytskyi();
                    sendMessage.setText(dBKhmelnytskyi);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Донецьк":
                    String dBDonetsk = placesOfSupportRepository.getDonetsk();
                    sendMessage.setText(dBDonetsk);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                case "Луганськ":
                    String dBLuhansk = placesOfSupportRepository.getLuhansk();
                    sendMessage.setText(dBLuhansk);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                //гуманітарна допомога
                case "302":
                    String dBHumanitarianHelp = placesOfSupportRepository.getHumanitarianHelp();
                    sendMessage.setText(dBHumanitarianHelp);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                //служби розшуку
                case "303":
                    String dBSearchService = placesOfSupportRepository.getSearchService();
                    sendMessage.setText(dBSearchService);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                //лікарі
                case "304":
                    String dBDoctors = placesOfSupportRepository.getDoctors();
                    sendMessage.setText(dBDoctors);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPlacesOfSupport());
                    break;
                // погода
                case "4":
                    sendOtherMessage.setText("Погода в Україні:");
                    sendOtherMessage.setReplyMarkup(inlineButton.getInlineWeatherKeyboardMarkup());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText("Натисніть щоб перейти в Меню");
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardButtonMenu());
                    break;
                //джерела інформації
                case "6":
                    String dBSource = serviceRepository.getSource();
                    sendMessage.setText(dBSource);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardButtonMenu());
                    break;
                // перша допомога
                case "7":
                    sendMessage.setText("\uD83E\uDD15 Перша допомога");
                    ReplyKeyboardMarkup keyboardFirstAidMenu = replyKeyboard.getKeyboardAidMenu();
                    sendMessage.setReplyMarkup(keyboardFirstAidMenu);
                    break;
                case "Серцево-легенева реанімація\uD83E\uDEC0\uD83E\uDEC1️":
                    String dBCPR = firstAidRepository.getCPR();
                    sendMessage.setText(dBCPR);
                    ReplyKeyboardMarkup replyCPRKeyboardMarkup = replyKeyboard.getKeyboardCPR();
                    sendMessage.setReplyMarkup(replyCPRKeyboardMarkup);
                    break;
                case "Дорослий\uD83D\uDC68\uD83C\uDFFC":
                    String dBCPR_Old = firstAidRepository.getCPR_Old();
                    sendMessage.setText(dBCPR_Old);
                    sendPhoto.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/serdechno-legochnaja-reanimacija-2.png"));
                    sengPhotoTwo.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/neprjamoj-massazh-serdca-1.png"));
                    sendPhotoThree.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/iskusstvennoe-dyhanie-3.png"));
                    messageSender.sendPhoto(sendPhoto);
                    messageSender.sendPhoto(sengPhotoTwo);
                    messageSender.sendPhoto(sendPhotoThree);
                    break;
                case "Дитина\uD83D\uDC66\uD83C\uDFFC":
                    String dBCPR_Young = firstAidRepository.getCPR_Young();
                    sendMessage.setText(dBCPR_Young);
                    break;
                case "Немовля\uD83D\uDC76\uD83C\uDFFC":
                    String dBCPR_Baby = firstAidRepository.getCPR_Baby();
                    sendMessage.setText(dBCPR_Baby);
                    sendPhoto.setPhoto(new InputFile("https://i0.wp.com/tv5.zp.ua/wp-content/uploads/2019/04/SLR-ditini.jpg?fit=500%2C334&ssl=1"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //кровотеча
                case "Кровотеча\uD83E\uDE78":
                    String dBBleeding = firstAidRepository.getBleeding();
                    sendMessage.setText(dBBleeding);
                    ReplyKeyboardMarkup keyboardBleeding = replyKeyboard.getKeyboardBleeding();
                    sendMessage.setReplyMarkup(keyboardBleeding);
                    break;
                case "Зовнішня кровотеча\uD83C\uDFE5":
                    String dBExternalBleeding = firstAidRepository.getExternalBleeding();
                    sendMessage.setText(dBExternalBleeding);
                    ReplyKeyboardMarkup keyboardExternalBleeding = replyKeyboard.getKeyboardExternalBleeding();
                    sendMessage.setReplyMarkup(keyboardExternalBleeding);
                    break;
                case "Внутрішня кровотеча\uD83C\uDFE5":
                    String dBInternalBleeding = firstAidRepository.getInternalBleeding();
                    sendMessage.setText(dBInternalBleeding);
                    break;
                case "Ампутація кінцівки\uD83C\uDFE5":
                    String dBLimbAmputation = firstAidRepository.getLimbAmputation();
                    sendMessage.setText(dBLimbAmputation);
                    break;
                case "Кінцівки\uD83E\uDDB5":
                    String dBLimbBleeding = firstAidRepository.getLimbBleeding();
                    sendMessage.setText(dBLimbBleeding);
                    break;
                case "Голова/Шия\uD83D\uDC64":
                    String dBHeadNeckBleeding = firstAidRepository.getHeadNeckBleeding();
                    sendMessage.setText(dBHeadNeckBleeding);
                    sendPhoto.setPhoto(new InputFile("https://green-way.com.ua/storage/app/media/Yulya/pomosh-pri-dtp/glava4/nalozhenie-davjashhej-povjazki-na-sheju.png"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                case "Живіт\uD83E\uDDCD\uD83C\uDFFC\u200D♂️":
                    String dBBodyBleeding = firstAidRepository.getBodyBleeding();
                    sendMessage.setText(dBBodyBleeding);
                    break;
                //опіки/обмороження
                case "Опіки/Обмороження⛑":
                    String dBBurns = firstAidRepository.getBurns();
                    sendMessage.setText(dBBurns);
                    ReplyKeyboardMarkup keyboardBurns = replyKeyboard.getKeyboardBurns();
                    sendMessage.setReplyMarkup(keyboardBurns);
                    break;
                case "Термічний опік\uD83C\uDF21":
                    String dBThermalBurns = firstAidRepository.getThermalBurns();
                    sendMessage.setText(dBThermalBurns);
                    break;
                case "Хімічний опік⚠️":
                    String dBChemicalBurns = firstAidRepository.getChemicalBurns();
                    sendMessage.setText(dBChemicalBurns);
                    break;
                case "Електричний опік⚡️":
                    String dBElectricBurns = firstAidRepository.getElectricBurns();
                    sendMessage.setText(dBElectricBurns);
                    break;
                case "Обмороження\uD83E\uDD76":
                    String burns = firstAidRepository.getBurns();
                    sendMessage.setText(burns);
                    break;
                //вогневе поранення
                case "Вогнепальне поранення\uD83D\uDD2B":
                    String dBGunshotWound = firstAidRepository.getGunshotWound();
                    sendMessage.setText(dBGunshotWound);
                    //inline повідомлення
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    break;
                //ЧМТ
                case "Черепно-мозкова травма\uD83E\uDDE0":
                    String dBTraumaticBrainInjury = firstAidRepository.getTraumaticBrainInjury();
                    sendMessage.setText(dBTraumaticBrainInjury);
                    //inline повідомлення
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    break;
                //травми кісток
                case "Травми кісток\uD83E\uDDB4":
                    String dBBoneInjures = firstAidRepository.getBoneInjuries();
                    sendMessage.setText(dBBoneInjures);
                    ReplyKeyboardMarkup keyboardBone = replyKeyboard.getKeyboardBoneInjuries();
                    sendMessage.setReplyMarkup(keyboardBone);
                    break;
                case "\uD83D\uDD39Відкритий перелом":
                    String dBOpenFracture = firstAidRepository.getOpenFracture();
                    sendMessage.setText(dBOpenFracture);
                    break;
                case "\uD83D\uDD39Закритий перелом":
                    String dBClosedFracture = firstAidRepository.getClosedFracture();
                    sendMessage.setText(dBClosedFracture);
                    break;
                case "\uD83D\uDD39Вивих":
                    String dBDislocation = firstAidRepository.getDislocation();
                    sendMessage.setText(dBDislocation);
                    break;
                //травми грудної клітки
                case "Травми грудної клітки\uD83D\uDC55": {
                    String dBChestInjury = firstAidRepository.getChestInjury();
                    sendMessage.setText(dBChestInjury);
                    ReplyKeyboardMarkup keyboardChest = replyKeyboard.getKeyboardChest();
                    sendMessage.setReplyMarkup(keyboardChest);
                    break;
                }
                //проникаюча травма
                case "Проникаюча травма\uD83D\uDD2A":
                    String dBPenetratingInjury = firstAidRepository.getPenetratingInjury();
                    sendMessage.setText(dBPenetratingInjury);
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    sendPhoto.setPhoto(new InputFile("https://olgrad.kiev.ua/wp-content/uploads/zachem-nuzhna-okkluzivnaya-povyazka.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //закрита травма
                case "Закрита травма⛑":
                    String dBClosedInjury = firstAidRepository.getClosedInjury();
                    sendMessage.setText(dBClosedInjury);
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    break;
                //травма хребта
                case "Травми хребта⚠️":
                    String dBSpineInjury = firstAidRepository.getSpineInjury();
                    sendMessage.setText(dBSpineInjury);
                    ReplyKeyboardMarkup keyboardSpine = replyKeyboard.getKeyboardSpine();
                    sendMessage.setReplyMarkup(keyboardSpine);
                    break;
                //безпечне місце
                case "Безпечне місце⛑":
                    String dBSafelyPlace = firstAidRepository.getSafelyPlace();
                    sendMessage.setText(dBSafelyPlace);
                    sendMessage.setReplyMarkup(inlineButton.getInlineCPRKeyboardMarkup());
                    sendPhoto.setPhoto(new InputFile("https://adst.mp.pl/s/empendium/img_zoom/B27/23.8-4.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    break;
                //небезпечне місце
                case "Небезпечне місце⚠️":
                    String dBDangerPlace = firstAidRepository.getDangerPlace();
                    sendMessage.setText(dBDangerPlace);
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
                    String dbDoctors = placesOfSupportRepository.getDoctors();
                    sendMessage.setText(dbDoctors);
                    break;
                //повернутися
                case "Повернутися⬅":
                    sendMessage.setText("Що трапилось?");
                    ReplyKeyboardMarkup keyboardReturn = replyKeyboard.getKeyboardAidMenu();
                    sendMessage.setReplyMarkup(keyboardReturn);
                    break;
                //психологічна допомога
                case "8":
                    String dBPsychologicalHelp = psychologicalHelpRepository.getPsychologicalHelp();
                    sendMessage.setText(dBPsychologicalHelp);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardPsychologicalHelp());
                    break;
                //алгоритм надання психологічної допомоги
                case "80":
                    String dBAlgorithmPsychologicalHelp = psychologicalHelpRepository.getAlgorithmPsychologicalHelp();
                    sendPhoto.setPhoto(new InputFile("https://ldn.org.ua/wp-content/uploads/2022/04/111-724x1024.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    sendMessage.setText(dBAlgorithmPsychologicalHelp);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPsychologicalHelp());
                    break;
                //страх
                case "81":
                    String dBFear = psychologicalHelpRepository.getFear();
                    sendMessage.setText(dBFear);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPsychologicalHelp());
                    break;
                //плач
                case "82":
                    String dBWeep = psychologicalHelpRepository.getWeep();
                    sendMessage.setText(dBWeep);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPsychologicalHelp());
                    break;
                //агресія
                case "83":
                    String dBAggression = psychologicalHelpRepository.getAggression();
                    sendMessage.setText(dBAggression);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPsychologicalHelp());
                    break;
                //паніка
                case "84":
                    String dBPanic = psychologicalHelpRepository.getPanic();
                    sendMessage.setText(dBPanic);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPsychologicalHelp());
                    break;
                //ступор
                case "85":
                    String dBStupor = psychologicalHelpRepository.getStupor();
                    sendMessage.setText(dBStupor);
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardReturnPsychologicalHelp());
                    break;
                //волонтерство
                case "9":
                    String dBVolunteering = volunteeringRepository.getVolunteering();
                    sendPhoto.setPhoto(new InputFile("http://www.visti.rovno.ua/img/650/zapishis-v-dobrovoltsi-z-tsivilnoho-zakhistu-dopom20220425_5166.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    sendOtherMessage.setText("\uD83D\uDC69\u200D\uD83D\uDE92Запишись в добровольці з цивільного захисту - допоможи країні❗️");
                    sendOtherMessage.setReplyMarkup(replyKeyboard.getKeyboardButtonMenu());
                    messageSender.sendMessage(sendOtherMessage);
                    sendMessage.setText(dBVolunteering);
                    sendMessage.setReplyMarkup(inlineButton.getInlineVolunteeringKeyboardMarkup());
                    break;
                case "Інші питання":
                    String dBVolunteeringQuestions = volunteeringRepository.getVolunteeringQuestions();
                    sendMessage.setText(dBVolunteeringQuestions);
                    sendMessage.setReplyMarkup(inlineButton.getInlineQuestionsKeyboardMarkup());
                    break;
                //зброя та боєприпаси: дії після знаходження
                case "10":
                    String dBActionsAfterFindWeapons = serviceRepository.getActionsAfterFindWeapons();
                    sendPhoto.setPhoto(new InputFile("https://mkrada.gov.ua/files/GROMADIANI/1.jpg"));
                    messageSender.sendPhoto(sendPhoto);
                    sendMessage.setText(dBActionsAfterFindWeapons);
                    sendMessage.setReplyMarkup(inlineButton.getInlineWeaponsKeyboardMarkup());
                    break;
                //інтерактивний інспектор
                case "11":
                    sendMessage.setText(inspector.getInspector());
                    sendMessage.setReplyMarkup(replyKeyboard.getKeyboardButtonMenu());
                    break;
                default:
                    sendMessage.setText("Введено не коректні дані: '" + message.getText() + "' Спробуйте ще раз!");
            }
            //відправлення повідомлення
            messageSender.sendMessage(sendMessage);
        }

    }
}
