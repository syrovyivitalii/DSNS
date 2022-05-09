package LDUBGD.DSNS.aid;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Bleeding {
    //меню кровотеча
    private ReplyKeyboardMarkup keyboardBleeding(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardBleedingRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardBleedingRow = new KeyboardRow();
        keyboardBleedingRow.add("Зовнішня кровотеча\uD83C\uDFE5");
        keyboardBleedingRow.add("Внутрішня кровотеча\uD83C\uDFE5");
        //створюємо другий рядок
        KeyboardRow keyboardBleedingSecondRow = new KeyboardRow();
        keyboardBleedingSecondRow.add("Ампутація кінцівки\uD83C\uDFE5");
        keyboardBleedingSecondRow.add("Повернутися⬅");
        //створюємо третій рядок
        KeyboardRow keyboardBleedingThirdRow = new KeyboardRow();
        keyboardBleedingThirdRow.add("Меню");
        //додаємо всі рядки в наш список
        keyboardBleedingRows.add(keyboardBleedingRow);
        keyboardBleedingRows.add(keyboardBleedingSecondRow);
        keyboardBleedingRows.add(keyboardBleedingThirdRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardBleedingRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardBleeding(){
        return keyboardBleeding();
    }

    //меню зовнішня кровотеча
    private ReplyKeyboardMarkup keyboardExternalBleeding(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardExternalBleedingRows = new ArrayList<>();
        //створюємо перший рядок клавіатури
        KeyboardRow keyboardExternalBleedingRow = new KeyboardRow();
        keyboardExternalBleedingRow.add("Кінцівки\uD83E\uDDB5");
        keyboardExternalBleedingRow.add("Голова/Шия\uD83D\uDC64");
        //створюємо другий рядок клавіатури
        KeyboardRow keyboardExternalBleedingSecondRow = new KeyboardRow();
        keyboardExternalBleedingSecondRow.add("Живіт\uD83E\uDDCD\uD83C\uDFFC\u200D♂️");
        keyboardExternalBleedingSecondRow.add("Повернутися⬅");
        //створюємо третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Меню");
        //додаємо всі рядки в наш список
        keyboardExternalBleedingRows.add(keyboardExternalBleedingRow);
        keyboardExternalBleedingRows.add(keyboardExternalBleedingSecondRow);
        keyboardExternalBleedingRows.add(keyboardThirdRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardExternalBleedingRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardExternalBleeding(){
        return keyboardExternalBleeding();
    }

    //кровотеча
    private String bleeding(){
        String text = "Кровотеча повинна бути зупинена якнайшвидше через реальну загрозу життю постраждалого\uD83E\uDE78 \n\n";
        text+= "Для зупинки кровотечі використовуйте чистий матеріал. За наявності - одягніть рукавички\uD83E\uDDE4 \n\n";
        return text;
    }
    public String getBleeding(){
        return bleeding();
    }

    //зовнішня кровотеча
    private String externalBleeding(){
        return "Оберіть місце кровотечі⬇️ ";
    }
    public String getExternalBleeding(){
        return externalBleeding();
    }

    //внутрішня кровотеча
    private String internalBleeding(){
        String text = "Допомога при внутрішній кровотечі\n\n";
        text += ("Ознаки: \n");
        text += ("\uD83D\uDD39 Посиніння шкіри, і згодом, освіта синця \n");
        text += ("\uD83D\uDD39 Блідість шкірних покривів, шкіра прохолодна або волога на дотик. \n");
        text += ("\uD83D\uDD39 Нудота і блювання. \n");
        text += ("\uD83D\uDD39 Почуття невгамовної спраги. \n");
        text += ("\uD83D\uDD39 Зниження рівня свідомості. \n\n");
        text += ("Перша допомога:  \n");
        text += ("\uD83D\uDD38 Крок 1. Створіть спокій постраждалому. \n");
        text += ("\uD83D\uDD38 Крок 2. Викличте швидку допомогу \n");
        text += ("\uD83D\uDD38 Крок 3. При кровотечах в черевній порожнині необіхдно обмежити прийом їжі і пиття. \n");
        text += ("\uD83D\uDD38 Крок 4. Прикладіть холодний компрес на місце внутрішньої кровотечі, використовуючи холодну воду, заморожені продукти, міхур з льодом або снігом, які прикладаються через тканину. \n");
        text += ("\uD83D\uDD38 Крок 5. Прикладайте холодні компреси з інтервалом 15 хвилин через кожну наступну годину. \n");
        return text;
    }
    public String getInternalBleeding(){
        return internalBleeding();
    }

    //ампутація кінцівки
    private String limbAmputation(){
        String text = "Допомога при ампутації\uD83C\uDD98 \n\n";
        text += "\uD83D\uDD38 Крок 1. Затиснути культтю рукою. \n\n";
        text += "\uD83D\uDD38 Крок 2. Накласти джгут або турнікет. \n\n";
        text += "\uD83D\uDD38 Крок 3. Накласти пов'язку на рану. \n\n";
        text += "\uD83D\uDD38 Крок 4. Знайти відірвану кінцівку, обгорнути марлею,покласти в пакет який покласти в інший пакет з холодом(лід,сніг). \n\n";
        text += "\uD83D\uDD38 Крок 5. Негайно відправити постраждалого в лікарню разом з кінцівкою. \n\n";
        return text;
    }
    public String getLimbAmputation(){
        return limbAmputation();
    }

    //кровотеча кінцівки
    private String limbBleeding(){
       String text = "Допомога при кровотечі кінцівок\uD83E\uDDB5 \n\n";
       text += "\uD83D\uDD38 Крок 1. Переконатися у відсутності небезпеки. \n\n";
       text += "\uD83D\uDD38 Крок 2. Провести огляд постраждалого, визначити наявність свідомості та дихання. \n\n";
       text += "\uD83D\uDD38 Крок 3. Викликати бригаду екстреної медичної допомоги(якщо необхідно). \n\n";
       text += "\uD83D\uDD38 Крок 4. Якщо кровотечі немає: \n\n";
       text += "- одягнути рукавички(по можливості); \n";
       text += "- підняти кінцівку; \n";
       text += "- накласти на рану чисту, стерильну серветку та бинтову пов'язку; \n\n";
       text += "\uD83D\uDD38 Крок 5. Якщо кровотеча артеріальна(кров яскраво-червоного кольору «б’є фонтаном», пульсує, призводить до значної  і швидкої крововтрати.): \n";
       text += "- накласти на рану чисту, стерильну серветку та натиснути безпосередньо на рану; \n";
       text += "- підняти кінцівку \n";
       text += "- якщо кровотеча не зупинена, накласти на рану пов’язку, що тисне, та при можливості одночасно притиснути артерію на відстані; \n";
       text += "- якщо кровотеча не зупинена, накласти джгут. \n\n";
       text += "\uD83D\uDD38 Крок 6. Якщо кровотеча венозна( кров безперервно витікає з рани, темно-червоного кольору; залежно від діаметру пошкодженої вени кровотеча може бути від незначної до інтенсивної.): \n";
       text += "- накласти на рану чисту, стерильну серветку та здійснити тиск безпосередньо на рану; \n";
       text += "- підняти кінцівку; \n";
       text += "- якщо кровотеча не зупинена, накласти на рану пов’язку. \n";
       return text;
    }
    public String getLimbBleeding(){
        return limbBleeding();
    }

    //кровотеча голови/шиї
    private String headNeckBleeding(){
        String text = "\uD83D\uDD39 Допомога при кровотечі голови\uD83D\uDC64 \n\n";
        text += "\uD83D\uDD38 Крок 1. Очистіть поверхню навколо рани, за потреби - вистрижіть волосся. \n\n";
        text += "\uD83D\uDD38 Крок 2. Обробіть краї рани діамантовим зеленим або спиртовим розчином йоду. \n\n";
        text += "\uD83D\uDD38 Крок 3. Накладіть стерильну пов'язку. \n\n";
        text += "\uD83D\uDD39 Поранення в шию\uD83D\uDC64 \n\n";
        text += "\uD83D\uDD38 Крок 1. Притиснути пальцем рану на шиї через комір одягу або безпосередньо рану.  \n\n";
        text += "\uD83D\uDD38 Крок 2. Підкласти під палець бинт, звільнений від упаковки. \n\n";
        text += "\uD83D\uDD38 Крок 3. Покласти руку пораненого на своє плече. \n\n";
        text += "\uD83D\uDD38 Крок 4. Накласти джгут через пахвову западину. \n\n";
        text += "\uD83D\uDD38 Крок 5. Не потрібно відзначати час накладання джгута. \n\n";
        return text;
    }
    public String getHeadNeckBleeding(){
        return headNeckBleeding();
    }

    //кровотеча живота
    private String bodyBleeding(){
        String text = "Допомога при кровотечі живота\uD83E\uDDCD\uD83C\uDFFC\u200D♂ \n\n";
        text += "\uD83D\uDD39 Ознаки проникаючої травми живота: \n";
        text += "- наявність рани; \n";
        text += "- біль в рані та в черевній порожнині; \n";
        text += "- нудота; \n";
        text += "- блювота; \n";
        text += "- слабкість; \n";
        text += "- відчуття тиску, 'розпирання' в животі \n";
        text += "- наявність в рані кишківника чи сальника; \n\n";
        text += "Домедична допомога⛑ : \n";
        text += "\uD83D\uDD38 Крок 1. Надати постраждалому зручне положення;\n";
        text += "\uD83D\uDD38 Крок 2. За наявності ознак шоку надати постраждалому протишокове положення;\n";
        text += "\uD83D\uDD38 Крок 3. Накласти чисту, стерильну пов’язку на рану та зафіксувати її за допомогою лейкопластиру; \n";
        text += "\uD83D\uDD38 Крок 4. Не вправляти внутрішні органи в черевну порожнину;\n";
        text += "\uD83D\uDD38 Крок 5. Не виймати з рани сторонні предмети;\n";
        text += "\uD83D\uDD38 Крок 6. Вкрити постраждалого термопокривалом/ковдрою;\n";
        text += "\uD83D\uDD38 Крок 7. Забезпечити постійний нагляд за постраждалим до приїзду швидкої.\n";
        return text;
    }
    public String getBodeBleeding(){
        return bodyBleeding();
    }
}
