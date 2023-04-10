package LDUBGD.DSNS.services;

import LDUBGD.DSNS.model.Keyboard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
@Component
public class ReplyKeyboard {

    private ReplyKeyboardMarkup createKeyboard (List<Keyboard> keyboards) {
        // Створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        for (Keyboard keyboard : keyboards) {
            KeyboardButton keyboardButton = new KeyboardButton(keyboard.getKeyboard());
            if (keyboard.getKeyboard().equals("\uD83D\uDCCD Поділитись розташуванням") || keyboard.getKeyboard().equals("\uD83D\uDCCD Змінити розташування")){
                keyboardButton.setRequestLocation(true);
            }
            row.add(keyboardButton);

            if (row.size() == keyboard.getButtons_per_row()) {
                rows.add(row);
                row = new KeyboardRow();
            }
        }

        if (!row.isEmpty()) {
            rows.add(row);
        }

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup getCreateKeyboard (List<Keyboard> keyboards){
        return createKeyboard(keyboards);
    }


}
