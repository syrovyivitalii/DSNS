package LDUBGD.DSNS.services;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String menu(){
        String text = "ДСНС України\uD83C\uDDFA\uD83C\uDDE6 — меню \n\n";
        text += "Оберіть номер, який ви бачите поряд з інформацією, яка Вас цікавить.\n";
        text += "Наприклад, надішліть 2, щоб  вибрати пункт \"Що робити у надзвичайній ситуації. \n\n";
        text += "1 ⚠️ Надзвичайні ситуації в Україні\n";
        text += "2 ⛑️ Що робити у надзвичайній ситуації\n";
        text += "3 \uD83D\uDCCD Пункти допомоги населенню\n";
        text += "4 \uD83C\uDF28️ Погода\n";
        text += "5 \uD83D\uDCF0 Новини: найсвіжіша інформація\n";
        text += "6 ℹ️ Джерела: офіційні державні акаунти\n";
        text += "7 \uD83E\uDD15 Перша допомога\n";
        text += "8 \uD83D\uDE33 Психологічна допомога\n";
        text += "9 \uD83D\uDE4F Волонтерство\n";
        text += "10 ‼️ Зброя та боєприпаси: дії у разі знаходження\n";
        text += "11 \uD83D\uDD75️\u200D♂️ Інтерактивний інспектор\n\n";
        text += "\uD83D\uDCDE 112 - Телефони рятувальних та аварійних служб";
        return text;
    }

    public String getMenu(){
        return menu();
    }

    //клавіатура
    private ReplyKeyboardMarkup keyboardMenu(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("1");
        keyboardRow.add("2");
        keyboardRow.add("3");
        //створюємо другий рядок
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("4");
        keyboardSecondRow.add("5");
        keyboardSecondRow.add("6");
        //створюємо третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("7");
        keyboardThirdRow.add("8");
        keyboardThirdRow.add("9");
        //створюємо четвертий рядок
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add("10");
        keyboardFourthRow.add("11");
        //додаємо рядки в наш список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        keyboardRows.add(keyboardFourthRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup getKeyboardMenu(){
        return keyboardMenu();
    }

    private ReplyKeyboardMarkup keyboardButtonMenu(){
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
        //додаємо рядки в наш список
        keyboardRows.add(keyboardRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardButtonMenu(){
        return keyboardButtonMenu();
    }
}
