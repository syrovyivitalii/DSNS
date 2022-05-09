package LDUBGD.DSNS.aid;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SpineInjury {
    private ReplyKeyboardMarkup keyboardSpine(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboard_Rows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboard_Row = new KeyboardRow();
        keyboard_Row.add("Безпечне місце⛑");
        keyboard_Row.add("Небезпечне місце⚠️");
        //створюємо другий рядок
        KeyboardRow keyboardSecond_Row = new KeyboardRow();
        keyboardSecond_Row.add("Повернутися⬅");
        keyboardSecond_Row.add("Меню");
        //додаємо рядок в список
        keyboard_Rows.add(keyboard_Row);
        keyboard_Rows.add(keyboardSecond_Row);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboard_Rows);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup getKeyboardSpine(){
        return keyboardSpine();
    }

    private String spineInjury(){
        String text = "Травму хребта слід підозрювати за таких обставин: падіння з висоти; стрибки у воду; сильний удар по тулубу; дорожньо-транспортні пригоди; ураження блискавкою; ураження електричним струмом; вибух. \n\n";
        text += "Ознаки:  \n";
        text += "\uD83D\uDD39 сильний біль або відчуття тиску в голові,шиї або спині.\n";
        text += "\uD83D\uDD39 поколювання або втрата чутливості в пальцях рук та ніг.\n ";
        text += "\uD83D\uDD39 втрата рухових функцій кінцівок.\n";
        text += "\uD83D\uDD39 деформація в області хребта.\n";
        text += "ДМД: \n\n";
        text += "\uD83D\uDD38 Крок 1. Переконатися у відсутності небезпеки. \n";
        text += "\uD83D\uDD38 Крок 2. Провести огляд постраждалого, визначити наявність свідомості та дихання. \n";
        text += "\uD83D\uDD38 Крок 3. Викликати бригаду екстреної (швидкої) медичної допомоги;. \n";
        text += "Оберіть ваше місцезнаходження: ⬇️ \n";
        return text;
    }

    public String getSpineInjury(){
        return spineInjury();
    }

    private String safelyPlace(){
        String text = "\uD83D\uDD38 Крок 4. Якщо у постраждалого відсутнє дихання - відновити прохідність дихальних шляхів, розпочати проведення серцево-легеневої реанімації. \n";
        text += "\uD83D\uDD38 Крок 5. Зафіксувати шийний відділ хребта за допомогою шийного комірця або іншим методом (м’яка шина, ручна фіксація). \n ";
        text += "\uD83D\uDD38 Крок 6. Залишити у початковому положенні. \n";
        text += "\uD83D\uDD38 Крок 7. Забезпечити постійний нагляд за постраждалим до приїзду бригади екстреної (швидкої) медичної допомоги. \n";
        text += "\uD83D\uDD38 Крок 8. Вкрити постраждалого термопокривалом/ковдрою. \n";
        text += "\uD83D\uDD38 Крок 9. Забезпечити психологічну підтримку. \n";
        return text;
    }
    public String getSafelyPlace(){
        return safelyPlace();
    }

    private String dangerPlace(){
        String text = "\uD83D\uDD38 Крок 4. Якщо у постраждалого відсутнє дихання - відновити прохідність дихальних шляхів, розпочати проведення серцево-легеневої реанімації. \n";
        text += "\uD83D\uDD38 Крок 5. Зафіксувати шийний відділ хребта за допомогою шийного комірця або іншим методом (м’яка шина, ручна фіксація). \n ";
        text += "\uD83D\uDD38 Крок 6. Перемістити постраждалого на довгу транспортувальну дошку або тверду рівну поверхню (щит, двері тощо). \n";
        text += "\uD83D\uDD38 Крок 7. Зафіксувати постраждалого на довгій транспортувальній дошці перед транспортуванням. \n";
        text += "\uD83D\uDD38 Крок 8. Вкрити постраждалого термопокривалом/ковдрою. \n";
        text += "\uD83D\uDD38 Крок 9. Перемістити постраждалого в безпечне місце. \n";
        text += "\uD83D\uDD38 Крок 10. Провести повторний огляд. \n";
        text += "\uD83D\uDD38 Крок 11. Надати домедичну допомогу постраждалому залежно від наявних пошкоджень (пов’язки, фіксація переломів тощо). \n";
        text += "\uD83D\uDD38 Крок 12. Надати психологічну підтримку. \n";
        text += "\uD83D\uDD38 Крок 13. Забезпечити постійний нагляд за постраждалим до приїзду бригади екстреної (швидкої) медичної допомоги. \n";
        return text;
    }

    public String getDangerPlace(){
        return dangerPlace();
    }

}
