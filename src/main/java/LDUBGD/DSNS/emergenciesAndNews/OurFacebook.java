package LDUBGD.DSNS.emergenciesAndNews;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OurFacebook {
    private String ourFacebook(){
        return  "Офіційна сторінка ДСНС України в Facebook:";
    }

    public String getOurFacebook(){
        return ourFacebook();
    }
    private String clickToMenu(){
        return "Натисніть щоб перейти в Меню";
    }
    public String getClockToMenu(){
        return clickToMenu();
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

}
