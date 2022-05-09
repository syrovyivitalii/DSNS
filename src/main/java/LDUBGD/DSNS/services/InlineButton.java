package LDUBGD.DSNS.services;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InlineButton {
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
}
