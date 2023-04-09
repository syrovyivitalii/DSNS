package LDUBGD.DSNS.services;

import LDUBGD.DSNS.model.InlineKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InlineButton {

    public InlineKeyboardMarkup createInlineKeyboard(List<InlineKeyboard> inlineKeyboards){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardList = new ArrayList<>();

        // sort inlineKeyboards by "sort" column
        Collections.sort(inlineKeyboards, Comparator.comparingInt(InlineKeyboard::getSort));

        // add buttons to keyboardList in the sorted order
        int index = 0;
        for (InlineKeyboard keyboard: inlineKeyboards){
            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(InlineKeyboardButton.builder()
                    .text(keyboard.getKeyboard())
                    .callbackData(keyboard.getCallback())
                    .build());
            keyboardList.add(row);
            index++;
        }

        inlineKeyboardMarkup.setKeyboard(keyboardList);
        return inlineKeyboardMarkup;
    }




    private InlineKeyboardMarkup inlineCPRKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("СЛР-Дорослий").callbackData("CPR-Old").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("СЛР-Дитина").callbackData("CPR-Young").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("СЛР-Немовля").callbackData("CPR-Baby").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineCPRKeyboardMarkup(){
        return inlineCPRKeyboardMarkup();
    }
    private InlineKeyboardMarkup inlineDirectoryKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тиць").callbackData("Directory").url("https://redcross.org.ua/wp-content/uploads/2016/10/%D0%A1%D0%BF%D1%80%D0%B0%D0%B2%D0%BE%D1%87%D0%BD%D0%B8%D0%BA-%D0%9F%D0%9F-%E2%80%94-%D0%90%D0%BC%D0%B5%D1%80%D0%B8%D0%BA%D0%B0%D0%BD%D1%81%D0%BA%D0%B8%D0%B9-%D0%9A%D0%9A_last.pdf").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineDirectoryKeyboardMarkup(){
        return inlineDirectoryKeyboardMarkup();
    }
    private InlineKeyboardMarkup inlineWeaponsKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Інформація як діяти").callbackData("InformationWhatToDo").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Лепесток").callbackData("Lepestok").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Касетна бомба").callbackData("ClusterBomb").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Міномет").callbackData("Mortar").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ракета").callbackData("Rocket").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Граната із реактивним двигуном").callbackData("GrenadeWithJetEngine").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Артилерійський снаряд").callbackData("ArtilleryShell").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Протитанкова міна").callbackData("Anti-tankMine").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Бомба").callbackData("Bomb").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Протипіхотна міна").callbackData("Anti-personnelMine").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Завершити перегляд").callbackData("CompleteReview").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineWeaponsKeyboardMarkup(){
        return inlineWeaponsKeyboardMarkup();
    }
    private InlineKeyboardMarkup inlineVolunteeringKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Питання та відповіді").callbackData("askVolunteering").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineVolunteeringKeyboardMarkup(){
        return inlineVolunteeringKeyboardMarkup();
    }

    private InlineKeyboardMarkup inlineQuestionsKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("91").callbackData("91").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("92").callbackData("92").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("93").callbackData("93").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("94").callbackData("94").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineQuestionsKeyboardMarkup(){
        return inlineQuestionsKeyboardMarkup();
    }

    private InlineKeyboardMarkup inlineTypeOfDeviceKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Мобільний пристрій").callbackData("Мобільний пристрій").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Персональний комп'ютер").callbackData("Персональний комп'ютер").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup getInlineTypeOfDeviceKeyboardMarkup(){
        return inlineTypeOfDeviceKeyboardMarkup();
    }

    // TODO: 14.02.23   "Перенесено в БД"
    @Deprecated(forRemoval = true, since = "Перенесено в БД")
    private InlineKeyboardMarkup inlineLocationKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("АР Крим").callbackData("АР Крим").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Вінницька").callbackData("Вінницька").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Волинська").callbackData("Волинська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Дніпропетровська").callbackData("Дніпропетровська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Донецька").callbackData("Донецька").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Житомирська").callbackData("Житомирська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Закарпатська").callbackData("Закарпатська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Запорізька").callbackData("Запорізька").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Івано-Франківська").callbackData("Івано-Франківська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Київська").callbackData("Київська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Кіровоградська").callbackData("Кіровоградська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Луганська").callbackData("Луганська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Львівська").callbackData("Львівська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Миколаїівська").callbackData("Миколаїівська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Одеська").callbackData("Одеська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Полтавська").callbackData("Полтавська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Рівненська").callbackData("Рівненська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Сумська").callbackData("Сумська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тернопільська").callbackData("Тернопільська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Харківська").callbackData("Харківська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Херсонська").callbackData("Херсонська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Хмельницька").callbackData("Хмельницька").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Черкаська").callbackData("Черкаська").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Чернівецька").callbackData("Чернівецька").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Чернігівська").callbackData("Чернігівська").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    @Deprecated(forRemoval = true, since = "Перенесено в БД")
    public InlineKeyboardMarkup getInlineLocationKeyboardMarkup(){
        return inlineLocationKeyboardMarkup();
    }

    private InlineKeyboardMarkup inlineFacebookKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тиць").callbackData("1EmergenciesInUkraine").url("https://www.facebook.com/MNS.GOV.UA").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getInlineFacebookKeyboardMarkup(){
        return inlineFacebookKeyboardMarkup();
    }

    private InlineKeyboardMarkup inlineWeatherKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тиць").callbackData("4WeatherInUkraine").url("https://pogoda.meta.ua/ua/").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getInlineWeatherKeyboardMarkup(){
        return inlineWeatherKeyboardMarkup();
    }
}
