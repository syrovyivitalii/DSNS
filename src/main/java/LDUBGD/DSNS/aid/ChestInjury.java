package LDUBGD.DSNS.aid;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

public class ChestInjury {
    //клавіатура
    private ReplyKeyboardMarkup keyboardChest(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboard_Rows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboard_Row = new KeyboardRow();
        keyboard_Row.add("Проникаюча травма\uD83D\uDD2A");
        keyboard_Row.add("Закрита травма⛑");
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

    public ReplyKeyboardMarkup getKeyboardChest(){
        return keyboardChest();
    }
    private String chestInjury() {
        String text = "ДМД при травмі грудної клітки: \n\n";
        text += "\uD83D\uDD38 Крок 1. Переконатися, що немає зовнішньої загрози. \n";
        text += "\uD83D\uDD38 Крок 2. Провести огляд постраждалого, визначити наявність свідомості, дихання.\n";
        text += "\uD83D\uDD38 Крок 3. Викликати бригаду екстреної (швидкої) медичної допомоги.\n ";
        text += "Оберіть вид травми: ⬇️ \n";
        return text;
    }

    public String getChestInjury(){
        return chestInjury();
    }

    private String penetratingInjury(){
        String text = "❗️Проникаюча травма грудної клітки(Відкритий пневмоторекс) - пошкодження, при якому канал рани має сполучення з плевральною порожниною; \n\n";
        text += "Ознаки: \n";
        text += "\uD83D\uDD39 наявність рани. \n";
        text += "\uD83D\uDD39 кровотеча з рани (кров може бути яскраво-червоною, пінистою). \n";
        text += "\uD83D\uDD39 звук всмоктування повітря при кожному вдиху. \n";
        text += "\uD83D\uDD39 утруднене дихання.\n\n";
        text += "ДМД:  \n\n";
        text += "\uD83D\uDD38 Крок 4. Якщо у постраждалого відсутнє дихання, розпочати серцево-легеневу реанімацію;\n";
        text += "\uD83D\uDD38 Крок 5. Попросити постраждалого зробити глибокий видих. \n";
        text += "\uD83D\uDD38 Крок 6. Накласти на рану чисту, стерильну серветку та матеріал, який не пропускає повітря (наприклад, шматок поліетиленового пакета, пластикова обгортка тощо).\n";
        text += "\uD83D\uDD38 Крок 7. Зафіксувати пов’язку лейкопластиром, залишивши один її край вільним.\n ";
        text += "\uD83D\uDD38 Крок 8. При вогнепальному пораненні грудної клітки перевірити місце можливого виходу кулі. Якщо виявлено другий отвір, накласти пов’язку, як описано вище, та зафіксувати її з усіх боків.\n";
        text += "\uD83D\uDD38 Крок 9. Надати постраждалому напівсидяче положення. \n";
        text += "\uD83D\uDD38 Крок 10. Вкрити постраждалого термопокривалом/покривалом.\n";
        text += "\uD83D\uDD38 Крок 11. забезпечити постійний нагляд за постраждалим до прибуття бригади екстреної (швидкої) медичної допомоги. \n";
        return text;
    }

    public String getPenetratingInjury(){
        return penetratingInjury();
    }

    private String closedInjury(){
        String text = "❗️Закрита травма грудної клітки з підозрою на внутрішню кровотечу - пошкодження, при якому немає сполучення плевральної порожнини з навколишнім середовищем: \n\n";
        text += "Ознаки: \n";
        text += "\uD83D\uDD39 посиніння шкіри. \n";
        text += "\uD83D\uDD39 часте дихання (більше 20 вдихів за хвилину). \n";
        text += "\uD83D\uDD39 бліда, холодна або волога на дотик шкіра. \n";
        text += "\uD83D\uDD39 утруднене дихання.\n\n";
        text += "ДМД:  \n\n";
        text += "\uD83D\uDD38 Крок 4. Якщо у постраждалого відсутнє дихання, розпочати серцево-легеневу реанімацію;\n";
        text += "\uD83D\uDD38 Крок 5. Надати постраждалому напівсидяче положення. \n";
        text += "\uD83D\uDD38 Крок 6. Вкрити постраждалого термопокривалом/покривалом.\n";
        text += "\uD83D\uDD38 Крок 7. Забезпечити постійний нагляд за постраждалим до прибуття бригади екстреної (швидкої) медичної допомоги.\n ";
        text += "\uD83D\uDD38 Крок 8. При погіршенні стану постраждалого до приїзду бригади екстреної (швидкої) медичної допомоги повторно зателефонувати диспетчеру екстреної медичної допомоги.\n";
        return text;
    }

    public String getClosedInjury(){
        return closedInjury();
    }

}
