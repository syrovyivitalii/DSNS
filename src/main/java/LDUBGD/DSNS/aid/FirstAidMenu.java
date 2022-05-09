package LDUBGD.DSNS.aid;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class FirstAidMenu {
    //головне меню
    private ReplyKeyboardMarkup keyboardAidMenu(){
        //Створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        //створюємо список рядків
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Серцево-легенева реанімація\uD83E\uDEC0\uD83E\uDEC1️");
        keyboardRow.add("Кровотеча\uD83E\uDE78");
        //створюємо другий рядок кнопок
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("Опіки/Обмороження⛑");
        keyboardSecondRow.add("Вогнепальне поранення\uD83D\uDD2B");
        //створюємо третій рядок кнопок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Черепно-мозкова травма\uD83E\uDDE0");
        keyboardThirdRow.add("Травми кісток\uD83E\uDDB4");
        //створюємо четвертий рядок
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add("Травми грудної клітки\uD83D\uDC55");
        keyboardFourthRow.add("Травми хребта⚠️");
        //створюємо пятий рядок
        KeyboardRow keyboardFivethRow = new KeyboardRow();
        keyboardFivethRow.add("Довідник");
        keyboardFivethRow.add("Лікар");
        //створюємо шостий рядок
        KeyboardRow keyboardSixthRow = new KeyboardRow();
        keyboardSixthRow.add("Меню");
        //додаємо всі рядки в список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        keyboardRows.add(keyboardFourthRow);
        keyboardRows.add(keyboardFivethRow);
        keyboardRows.add(keyboardSixthRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardAidMenu(){
        return keyboardAidMenu();
    }

}
