package LDUBGD.DSNS.services;

import LDUBGD.DSNS.model.Keyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ReplyKeyboard {

    public ReplyKeyboardMarkup createKeyboard (List<Keyboard> keyboards) {
        // Створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        for (Keyboard keyboard : keyboards) {
            KeyboardButton keyboardButton = new KeyboardButton(keyboard.getKeyboard());
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

    private ReplyKeyboardMarkup keyboardBoneInjuries(){
        //Створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("\uD83D\uDD39Відкритий перелом");
        keyboardRow.add("\uD83D\uDD39Закритий перелом");
        //створюємо другий рядок
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("\uD83D\uDD39Вивих");
        keyboardSecondRow.add("Повернутися⬅");
        //створюємо третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Меню");
        //додаємо рядки в список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardBoneInjuries(){
        return keyboardBoneInjuries();
    }


    private ReplyKeyboardMarkup keyboardBurns(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyBoardBurnsRows = new ArrayList<>();
        //створюємо перший рядок клавіатури
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Термічний опік\uD83C\uDF21");
        keyboardRow.add("Хімічний опік⚠️");
        //створюємо другий рядок клавіатури
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("Електричний опік⚡️");
        keyboardSecondRow.add("Обмороження\uD83E\uDD76");
        //створюємо третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Повернутися⬅");
        keyboardThirdRow.add("Меню");
        //додаємо всі рядки в наш список
        keyBoardBurnsRows.add(keyboardRow);
        keyBoardBurnsRows.add(keyboardSecondRow);
        keyBoardBurnsRows.add(keyboardThirdRow);
        //додаємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyBoardBurnsRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardBurns(){
        return keyboardBurns();
    }

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

    private ReplyKeyboardMarkup keyboardActionInEmergencies() {
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("201");
        keyboardRow.add("202");
        keyboardRow.add("203");
        //створюємо другий рядок
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("204");
        keyboardSecondRow.add("205");
        keyboardSecondRow.add("206");
        //створюємо третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("207");
        keyboardThirdRow.add("208");
        keyboardThirdRow.add("209");
        //створюємо четвертий рядок
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add("210");
        keyboardFourthRow.add("211");
        keyboardFourthRow.add("212");
        //створюємо п'ятий рядок
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add("213");
        keyboardFifthRow.add("214");
        keyboardFifthRow.add("215");
        //створюємо шостий рядок
        KeyboardRow keyboardSixthRow = new KeyboardRow();
        keyboardSixthRow.add("216");
        keyboardSixthRow.add("217");
        keyboardSixthRow.add("218");
        //створюємо сьомий рядок
        KeyboardRow keyboardSeventhRow = new KeyboardRow();
        keyboardSeventhRow.add("219");
        keyboardSeventhRow.add("220");
        keyboardSeventhRow.add("221");
        //створюємо восьмий рядок
        KeyboardRow keyboardEighthRow = new KeyboardRow();
        keyboardEighthRow.add("222");
        //створюємо восьмий рядок
        KeyboardRow keyboardNinthRow = new KeyboardRow();
        keyboardNinthRow.add("Меню");
        //встановлюємо всі рядки в наш список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        keyboardRows.add(keyboardFourthRow);
        keyboardRows.add(keyboardFifthRow);
        keyboardRows.add(keyboardSixthRow);
        keyboardRows.add(keyboardSeventhRow);
        keyboardRows.add(keyboardEighthRow);
        keyboardRows.add(keyboardNinthRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardActionInEmergencies(){
        return keyboardActionInEmergencies();
    }
    //клавіатура повернення до дій під час надзвичайних ситуацій
    private ReplyKeyboardMarkup keyboardReturnActionInEmergencies(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("2");
        keyboardRow.add("Меню");
        //встановлюємо всі рядки в наш список
        keyboardRows.add(keyboardRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardReturnActionInEmergencies(){
        return keyboardReturnActionInEmergencies();
    }

    private ReplyKeyboardMarkup keyboardSupport(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("301");
        keyboardRow.add("302");
        keyboardRow.add("303");
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("304");
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

    public ReplyKeyboardMarkup getKeyboardSupport(){
        return keyboardSupport();
    }
    //клавіатура повернення до пунктів допомоги населенню
    private ReplyKeyboardMarkup keyboardReturnPlacesOfSupport(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("3");
        keyboardRow.add("Меню");
        //встановлюємо всі рядки в наш список
        keyboardRows.add(keyboardRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardReturnPlacesOfSupport(){
        return keyboardReturnPlacesOfSupport();
    }

    private ReplyKeyboardMarkup keyboardShelters(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Київ");
        keyboardRow.add("Київська область");
        keyboardRow.add("Львів");
        //другий рядок
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("Харків");
        keyboardSecondRow.add("Одеса");
        keyboardSecondRow.add("Луцьк");
        //третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("Полтава");
        keyboardThirdRow.add("Івано-Франківськ");
        keyboardThirdRow.add("Тернопіль");
        //четвертий рядок
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add("Чернігів");
        keyboardFourthRow.add("Вінниця");
        keyboardFourthRow.add("Рівне");
        //п'ятий рядок
        KeyboardRow keyboardFivethRow = new KeyboardRow();
        keyboardFivethRow.add("Дніпро");
        keyboardFivethRow.add("Житомир");
        keyboardFivethRow.add("Чернівці");
        //шостий рядок
        KeyboardRow keyboardSixthRow = new KeyboardRow();
        keyboardSixthRow.add("Запоріжжя");
        keyboardSixthRow.add("Черкаси");
        keyboardSixthRow.add("Миколаїв");
        //сьомий рядок
        KeyboardRow keyboardSeventhRow = new KeyboardRow();
        keyboardSeventhRow.add("Кропивницький");
        keyboardSeventhRow.add("Суми");
        keyboardSeventhRow.add("Ужгород");
        //восьмий рядок
        KeyboardRow keyboardEighthRow = new KeyboardRow();
        keyboardEighthRow.add("Херсон");
        keyboardEighthRow.add("Хмельницький");
        keyboardEighthRow.add("Донецьк");
        //дев'ятий рядок
        KeyboardRow keyboardNinthRow = new KeyboardRow();
        keyboardNinthRow.add("Луганськ");
        //десятий рядок
        KeyboardRow keyboardTenthRow = new KeyboardRow();
        keyboardTenthRow.add("3");
        keyboardTenthRow.add("Меню");
        //встановлюємо всі рядки в наш список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        keyboardRows.add(keyboardFourthRow);
        keyboardRows.add(keyboardFivethRow);
        keyboardRows.add(keyboardSixthRow);
        keyboardRows.add(keyboardSeventhRow);
        keyboardRows.add(keyboardEighthRow);
        keyboardRows.add(keyboardNinthRow);
        keyboardRows.add(keyboardTenthRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardShelters(){
        return keyboardShelters();
    }

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

    private ReplyKeyboardMarkup keyboardVolunteering(){
        //створюємо клавіатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //створюємо список рядків клавіатури
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        //створюємо перший рядок
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Інші питання");
        keyboardRow.add("Меню");
        //додаємо рядки в наш список
        keyboardRows.add(keyboardRow);
        //встановлюємо цей список нашій клавіатурі
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup getKeyboardVolunteering(){
        return keyboardVolunteering();
    }

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
        KeyboardButton keyboardButton1 = new KeyboardButton("Змінити розташування");
        keyboardButton1.setRequestLocation(true);
        keyboardRow.add(keyboardButton1);
        //створюємо другий рядок
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("1");
        keyboardSecondRow.add("2");
        keyboardSecondRow.add("3");
        //створюємо третій рядок
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardThirdRow.add("4");
        keyboardThirdRow.add("5");
        keyboardThirdRow.add("6");
        //створюємо четвертий рядок
        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add("7");
        keyboardFourthRow.add("8");
        keyboardFourthRow.add("9");
        //створюємо п'ятий рядок
        KeyboardRow keyboardFifthRow = new KeyboardRow();
        keyboardFifthRow.add("10");
        keyboardFifthRow.add("11");
        //додаємо рядки в наш список
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);
        keyboardRows.add(keyboardThirdRow);
        keyboardRows.add(keyboardFourthRow);
        keyboardRows.add(keyboardFifthRow);
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
