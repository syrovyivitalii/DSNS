package LDUBGD.DSNS.weather;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Weather {
    private String weatherInUkraine(){
        return  "Погода в Україні:";
    }

    public String getWeatherInUkraine(){
        return weatherInUkraine();
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

