package LDUBGD.DSNS.aid;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class CardiopulmonaryResuscitation {

    //меню СЛР
    private ReplyKeyboardMarkup keyboardCPR(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardCPR_Rows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardCPR_Row = new KeyboardRow();
        keyboardCPR_Row.add("Дорослий\uD83D\uDC68\uD83C\uDFFC");
        keyboardCPR_Row.add("Дитина\uD83D\uDC66\uD83C\uDFFC");
        //створюємо другий рядок
        KeyboardRow keyboardCPR_SecondRow = new KeyboardRow();
        keyboardCPR_SecondRow.add("Немовля\uD83D\uDC76\uD83C\uDFFC");
        keyboardCPR_SecondRow.add("Повернутися⬅");
        //створюємо третій рядок
        KeyboardRow keyboardCPR_ThirdRow = new KeyboardRow();
        keyboardCPR_ThirdRow.add("Меню");
        //додаємо всі рядки в наш список
        keyboardCPR_Rows.add(keyboardCPR_Row);
        keyboardCPR_Rows.add(keyboardCPR_SecondRow);
        keyboardCPR_Rows.add(keyboardCPR_ThirdRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardCPR_Rows);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup getKeyboardCPR(){
        return keyboardCPR();
    }

    //СЛР
    private String CPR(){
        String text = "Якщо постраждалий непритомний та не дихає,необіхдно перейти до проведення серцево-легенової реанімації(СЛР) попередньо викликавши швидку \uD83D\uDE91.\n\n";
        text+= "СЛР - це поєднання непрямого масажу серця і штучної вентиляції легень.\n\n";
        text+= "УВАГА❗ Перед початком СЛР переконайтеся, що постраждалий знаходиться на жорсткій поверхні!\n";
        return text;
    }
    public String get_CPR(){
        return CPR();
    }
    //CЛР дорослому
    private String CPR_Old(){
        String text = "Перша допомога дорослому⛑\n\n";
        text += "\uD83D\uDD38 Крок 1. Переконайтеся що в постраждалого немає свідомості та пульсу. \n\n";
        text += "\uD83D\uDD38 Крок 2. Закиньте голову назад та трохи підніміть підборіддя. Переконайтеся, що в ротовій порожнині немає згустків та дихальні шляхи вільні. \n\n";
        text += "\uD83D\uDD38 Крок 3. Покладіть основу долоні однієї руки посередині грудної клітки, долоню другої руки покладіть поверх першої.\n\n ";
        text += "\uD83D\uDD38 Крок 4. Зробіть 30 поштовхів на грудну клітку обома руками на глибину 5-6 см. Проводьте поштовхи плавно та ритмічно, по вертикальній прямій, постійно утримуючи руку на грудній клітці та дозволяючи їй повертатися у вихідне положення. Під час виконання поштовхів руки мають залишатися прямими(не згибати у ліктях). \n\n";
        text += "\uD83D\uDD38 Крок 5. Затисніть носові ходи великим і вказівним пальцями та зробіть 2 повних вдування 'із рота в рот' тривалістю 1 секунда кожне, або використовуйте ручний респіратор чи плівку-клапан. Після кожного вдування відпускайте пальці з носових ходів та слідкуйте за підняттям та опусканням грудної клітки, щоб переконатися, що повітря надходить і виходить з легенів. Якщо грудна клітка не піднімається - повторно очистити носові ходи.\n\n";
        text += "❗ Реанімацію з алгоритмом 30 поштовхів та 2 вдування продовжуйте поки: \n";
        text += "- не приїде швидка допомога; \n";
        text += "- постраждалий не почне дихати самостійно; \n";
        text += "- не настане фізичне виснаження рятівника; \n";
        return text;
    }
    public String get_CPR_Old(){
        return CPR_Old();
    }
    //СЛР дитині
    private String CPR_Young(){
        String text = "Перша допомога дитині(до 10 років)⛑\n\n";
        text += "\uD83D\uDD38 Крок 1. Переконайтеся, що в постраждалого немає свідомості та пульсу. \n\n";
        text += "\uD83D\uDD38 Крок 2. Закиньте голову назад та трохи підніміть підборіддя. Переконайтеся, що в ротовій порожнині немає згустків та дихальні шляхи вільні. \n\n";
        text += "\uD83D\uDD38 Крок 3. Крок 5. Затисніть носові ходи великим і вказівним пальцями та зробіть 2 повних вдування 'із рота в рот' тривалістю 1 секунда кожне, або використовуйте ручний респіратор чи плівку-клапан.\n\n ";
        text += "\uD83D\uDD38 Крок 4. Покладіть Основу долоні однієї руки посередині грудної клітки.\n\n ";
        text += "\uD83D\uDD38 Крок 5. Зробіть 30 поштовхів на грудну клітку рукою на глибину 1/3 висоти грудної клітки. Проводьте поштовхи плавно та ритмічно, по вертикальній прямій, постійно утримуючи руку на грудній клітці та дозволяючи їй повертатися у вихідне положення. Під час виконання поштовхів руки мають залишатися прямими(не згибати у ліктях). \n\n";
        text += "❗ Реанімацію з алгоритмом 30 поштовхів та 2 вдування продовжуйте поки: \n";
        text += "- не приїде швидка допомога; \n";
        text += "- постраждалий не почне дихати самостійно; \n";
        text += "- не настане фізичне виснаження рятівника; \n";
        return text;
    }
    public String get_CPR_Young(){
        return CPR_Young();
    }
    //СЛР немовляті
    private String CPR_Baby(){
        String text = "Перша допомога немовляті(до 1 року)⛑\n\n";
        text += "\uD83D\uDD38 Покласти немовля на спину та під плечі підложити валик. \n\n";
        text += "\uD83D\uDD38 Переконайтеся, що дихальні шляхи вільні. Якщо у ротовій порожнині є згустки - обережно очистіть. \n\n";
        text += "\uD83D\uDD38 Проведіть 5 слабких вдувань, при цьому необхідно обхватити одночасно рот та ніс немовляти своїми губами, спостерігаючи чи піднімається грудна клітка. Якщо немає серцебиття - проводьте СЛР\n\n";
        text += "\uD83D\uDD38 Покладіть два пальці на грудну клітину та зробіть 30 натискань на глибину 1/3 висоти грудної клітки.\n\n ";
        text += "❗ Реанімацію з алгоритмом 30 поштовхів та 2 вдумання продовжуйте поки: \n";
        text += "- не приїде швидка допомога; \n";
        text += "- постраждалий не почне дихати самостійно; \n";
        text += "- не настане фізичне виснаження рятівника; \n";
        return text;
    }
    public String get_CPR_Baby(){
        return CPR_Baby();
    }


}
