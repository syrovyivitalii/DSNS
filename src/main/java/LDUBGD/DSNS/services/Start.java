package LDUBGD.DSNS.services;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Start {
    // /start програми
    private String start(){
        String text = "ЗБЕРІГАЙТЕ СПОКІЙ МИ ПОРУЧ\uD83C\uDDFA\uD83C\uDDE6 \n\n Це офіційний Телеграм-бот від ДСНС України. \n\n Щоб розпочати роботу натисніть кнопку нище. ";
        return text;
    }

    public String getStart(){
        return start();
    }

    //клавіатура
    private ReplyKeyboardMarkup keyboardStart(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Меню");
        //додаємо рядок в наш список
        keyboardRows.add(keyboardRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup getKeyboardStart(){
        return keyboardStart();
    }
}
