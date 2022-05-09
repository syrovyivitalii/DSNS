package LDUBGD.DSNS.psychologicalHelp;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class PsychologicalHelp {
    //психологічна допомога
    private String psychologicalHelp(){
        return "Психологічна допомога - Поради психолога\n" +
                "\n" +
                "Оберіть відповідний номер\n" +
                "\n" +
                "80 Алгоритм дій щодо надання першої психологічної допомоги в умовах війни!\n" +
                "\n" +
                "81 \uD83D\uDE28 Страх\n" +
                "\n" +
                "82 \uD83D\uDE2D Плач\n" +
                "\n" +
                "83 \uD83D\uDE21 Агресія\n" +
                "\n" +
                "84 \uD83D\uDE16 Панічна атака\n" +
                "\n" +
                "85 \uD83D\uDE33 Ступор";
    }
    public String getPsychologicalHelp(){
        return psychologicalHelp();
    }
    //клавіатура психологічна допомога
    private ReplyKeyboardMarkup keyboardPsychologicalHelp() {
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("80");
        keyboardRow.add("81");
        keyboardRow.add("82");
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("83");
        keyboardSecondRow.add("84");
        keyboardSecondRow.add("85");
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Меню");
        //встановлюємо всі рядки в наш список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardPsychologicalHelp(){
        return keyboardPsychologicalHelp();
    }
    //клавіатура повернення до пунктів допомоги населенню
    private ReplyKeyboardMarkup keyboardReturnPsychologicalHelp(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("8");
        keyboardRow.add("Меню");
        //встановлюємо всі рядки в наш список
        keyboardRows.add(keyboardRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardReturnPsychologicalHelp(){
        return keyboardReturnPsychologicalHelp();
    }
    //алгоритм психологічної допомоги
    private String algorithmPsychologicalHelp(){
        return "Психологічна служба Головне управління ДСНС у Рівненській області підготувала для громадян алгоритм дій щодо надання першої психологічної допомоги в умовах війни!\n" +
                "Дотримуємось порад і спокійно віримо в перемогу! ✊\uD83C\uDDFA\uD83C\uDDE6 ";
    }
    public String getAlgorithmPsychologicalHelp(){
        return algorithmPsychologicalHelp();
    }
    //агресія
    private String aggression(){
        return "\uD83D\uDE21 АГРЕСІЯ: як допомогти?\n" +
                "1. Зведіть до мінімуму кількість людей навколо (за можливості).\n" +
                "\n" +
                "2. Дайте людині можливість випустити емоції.\n" +
                "\n" +
                "3. Дайте роботу, пов'язану з високим фізичним навантаженням.\n" +
                "\n" +
                "4. Демонструйте доброзичливість.\n" +
                "\n" +
                "5. Намагайтеся розрядити ситуацію смішними коментарями або діями.";
    }
    public String getAggression(){
        return aggression();
    }
    //страх
    private String fear(){
        return "\uD83D\uDE28 Страх\n" +
                "\n" +
                "Що робити, якщо Вас охопила паніка та страх в укритті:\n" +
                "\uD83D\uDCF7 Перегляньте це відео, щоб отримати поради від психологів ДСНС\n" +
                "\n" +
                "ВІДЕО\n" +
                "\n" +
                "Не лякайтесь своїх емоцій. Це нормальна реакція на ненормальну ситуацію!\n" +
                "\n" +
                "Як допомогти іншій людині:\n" +
                "\n" +
                "1. Покладіть руку постраждалого на зап'ястя, щоб він відчув ваш спокій. Це буде для нього сигналом, що ви поруч.\n" +
                "\n" +
                "2. Дихайте глибоко та рiвно. Заохочуйте постраждалого дихати в одному з вами ритмі.\n" +
                "\n" +
                "3. Якщо потерпілий говорить, то слухайте його, ВИЯВЛЯЙТЕ зацікавленість, розуміння, співчуття.\n" +
                "\n" +
                "4. Зробіть потерпілому легкий масаж найбільш напружених м'язiв тiла.";
    }
    public String getFear(){
        return fear();
    }
    //паніка
    private String panic(){
        return "\uD83D\uDE16 ПАНІЧНА АТАКА: як допомогти?\n" +
                "1. Попросіть людину сісти, опустити голову та впертися ногами в підлогу.\n" +
                "\n" +
                "2. Попросіть зосередитися на диханнi i дихати повільно.\n" +
                "\n" +
                "3. Переведіть увагу. Попросіть людину розповісти про те, що вона бачить і чує.";
    }
    public String getPanic(){
        return panic();
    }
    //ступор
    private String stupor(){
        return "\uD83D\uDE33 CTYПOP. Ознаки:\n" +
                "• різке зниження або відсутність довiльних рухів та мови\n" +
                "\n" +
                "• відсутність реакцій на зовнiшнi подразники (шум, світло)\n" +
                "\n" +
                "• застигання у певній позі, стан повноï нерухомості\n" +
                "\n" +
                "як допомогти?\n" +
                "\n" +
                "1. Підійдіть до людини, повільно візьміть за руку і запросіть йти разом з вами. Використовуйте фрази: \"Тобі не можна залишатися тут\", \"Тобі потрібна допомога\" тощо.\n" +
                "\n" +
                "2. Зігніть постраждалому пальці на обох руках і прітисніть їх до основи долоні.\n" +
                "\n" +
                "3. Людина, перебуваючи у ступорі, може чути та бачити. Тому говоріть їй на вухо тихо, повільно та чітко те, що може викликати сильні емоції.";
    }
    public String getStupor(){
        return stupor();
    }
    //плач
    private String weep(){
        return "\uD83D\uDE2D  ПЛАЧ: як допомогти?\n" +
                "1. Не залишайте постраждалого одного.\n" +
                "\n" +
                "2. Встановіть фізичний контакт з ним (візьміть за руку, погладьте по голові). Дайте відчути, що ви поряд.\n" +
                "\n" +
                "3. Застосуйте прийоми активного слухання: періодично вимовляйте \"так\", кивайте головою, говоріть про своï почуття та почуття постраждалого.\n" +
                "\n" +
                "4. Не намагайтеся заспокоїти постраждалого. Дайте йому можливість виплакатися і виговоритися.";
    }
    public String getWeep(){
        return weep();
    }
}

