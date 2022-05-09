package LDUBGD.DSNS.supportPlaces;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class PlacesOfSupport {
    //вступний текст
    private String placesOfSupport(){
        String text = "\uD83D\uDCCD Пункти допомоги населенню\n\n";
        text += "Надішліть відповідний номер\n\n";
        text += "301 \uD83C\uDFE0 Укриття\n";
        text += "302 ⛑️ Гуманітарна допомога\n";
        text += "303 \uD83D\uDD0D Служби розшуку\n";
        text += "304 \uD83E\uDE7A Лікарі";
        return text;
    }
    public String getPlacesOfSupport(){
        return placesOfSupport();
    }
    // клавіатура пунктів допомоги населенню
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
    //лікарі
    private String doctors(){
        return "Лікарі інституту терапії iм Любовi Малої готові надавати консультативну допомогу онлайн.\n" +
                "В будь який час Ви можете звернутися за телефоном до наших лікарів:\n" +
                "\n" +
                "Ісаєва Анна Сергіївна,\n" +
                "кардіолог, ревматолог +380504006550\n" +
                "\n" +
                "Петюніна Ольга Вячеславівна,\n" +
                "кардіолог +380509737905\n" +
                "\n" +
                "Рябуха Владислав Валерійович,\n" +
                "кардіолог +380672990488\n" +
                "\n" +
                "Коротченко Ольга Валеріївна, \n" +
                "пульмонолог +380664493885\n" +
                "\n" +
                "Якименко Юлія Сергіївна,\n" +
                "терапевт, +380509580580\n" +
                "\n" +
                "Оврах Тамара Геннадіївна,\n" +
                "терапевт, кардіолог, +380979913728\n" +
                "\n" +
                "Божко Вадим Вячеславович,\n" +
                "кардіолог +380677066851\n" +
                "\n" +
                "Фролова Еліна Юріївна,\n" +
                "врач гастроентеролог +380503011578\n" +
                "\n" +
                "Старченко Тетяна Григорiвна,\n" +
                "кардiолог +380504009641\n" +
                "\n" +
                "Чернова Валентина Михайлівна, \n" +
                "гастроентеролог +380509276287\n" +
                "\n" +
                "Токарєва Альона Юріївна,\n" +
                "пульмонолог, +380509276884\n" +
                "\n" +
                "Шкапо Володимир Леонідович,\n" +
                "кардioлог, +380509399724\n" +
                "\n" +
                "Савічева Катерина Олександрівна,\n" +
                "терапевт, +380963128036\n" +
                "\n" +
                "Черняк Аркадій Миколайович\n" +
                "гастроентеролог +380504017341\n" +
                "\n" +
                "Панченко Галина Юріївна,\n" +
                "терапевт, +380503030504\n" +
                "\n" +
                "Колеснікова Олена Миколаївна\n" +
                "пульмонолог +380501545728\n" +
                "\n" +
                "Чупріна Світлана Вікторівна,\n" +
                "ендокринолог +380504007417\n" +
                "\n" +
                "Дмитренко Руслан Іванович,\n" +
                "рентгенолог, +380683423299\n" +
                "\n" +
                "Соломенцева Тетяна Анатоліївна,\n" +
                "гастроентеролог +380506346496\n" +
                "\n" +
                "Сердобінська-Канівець Еміріта Миколаївна,\n" +
                "кардіолог, терапевт +380994448499\n" +
                "\n" +
                "test_one_more, [05.05.2022 12:09]\n" +
                "Рудик Юрiй Степанович,\n" +
                "кардіолог, +380503031915\n" +
                "\n" +
                "Овчаренко Людмила Іванівна,\n" +
                "кардіолог +380957222624\n" +
                "\n" +
                "Резник Лариса Аркадіївна,\n" +
                "кардіолог, терапевт +380677148765\n" +
                "\n" +
                "Коваль Сергій Миколайович,\n" +
                "кардіолог, +380971176414\n" +
                "\n" +
                "Кірієнко Олександр Миколайович\n" +
                "нефролог, терапевт  +380677596878\n" +
                "\n" +
                "Матяшова Лоліта Миколаївна,\n" +
                "терапевт +380507032765\n" +
                "\n" +
                "Просоленко Костянтин Олександрович,\n" +
                "терапевт, гастроентеролог +380679381727\n" +
                "\n" +
                "Курінна Олена Григоріївна,\n" +
                "гастроентеролог, терапевт,  +380509353573\n" +
                "\n" +
                "Гасанов Юрій Чингизович\n" +
                "ревматолог +380669889084\n" +
                "\n" +
                "Валентинова Інна Анатоліївна,\n" +
                "кардіолог +380505892981\n" +
                "\n" +
                "Вовченко Марина Миколаївна\n" +
                "кардіолог, терапевт +380505728467\n" +
                "\n" +
                "Семеновых Поліна Станіславівна,\n" +
                "терапевт, нефролог +380507502328\n" +
                "\n" +
                "Козирєва Тетяна Євгенівна,\n" +
                "гастроентеролог +380506360910\n" +
                "\n" +
                "Черелюк Наталія Ігорівна\n" +
                "гастроентеролог, терапевт +380988614252\n" +
                "\n" +
                "Титаренко Наталія Володимирівна,\n" +
                "кардіолог. +380677210311\n" +
                "\n" +
                "Денисенко Віктор Петрович,\n" +
                "терапевт +380505934946\n" +
                "\n" +
                "Меденцева Олена Олександрівна,\n" +
                "кардіолог +380951404669\n" +
                "\n" +
                "Несен Андрій Олексійович,\n" +
                "терапевт, нефролог +380506885508\n" +
                "\n" +
                "Милославський Дмитро Кирилович,\n" +
                "кардіолог +380509518252\n" +
                "\n" +
                "Запровальна  Ольга Євгеніївна,\n" +
                "кардіолог, +380509539588\n" +
                "\n" +
                "Снігурська Ірина Олександрівна,\n" +
                "кардіолог, +380679598204\n" +
                "\n" +
                "Бабичев Денис Петрович,\n" +
                "терапевт +380979753536\n" +
                "\n" +
                "Пивовар Сергій Миколайович,\n" +
                "кардіолог +380677188896\n" +
                "\n" +
                "Щербань Тетяна Дмитрівна\n" +
                "нефролог, терапевт +380677707732\n" +
                "\n" +
                "Комір Ірина Ростиславівна,\n" +
                "терапевт +380956525210\n" +
                "\n" +
                "Буряковська Олена Олександрівна\n" +
                "терапевт, ендокринолог +380952431333\n" +
                "\n" +
                "Шалімова Анна Сергіївна,\n" +
                "кардіолог, терапевт +380679346975\n" +
                "\n" +
                "Серик Сергій Андрійович,\n" +
                "кардіолог +380504002055\n" +
                "\n" +
                "Конькова Викторія Сергіївна\n" +
                "кардіолог, терапевт +380671239616\n" +
                "\n" +
                "Кушнір Інна Ернестівна\n" +
                "гастроентеролог +380505714000\n" +
                "\n" +
                "Вишневська Ірина Русланівна\n" +
                "кардіолог, терапевт +380959359759, +380971049256,\n" +
                "\n" +
                "Піун Тетяна Іллівна\n" +
                "рентгенолог +380957149063\n" +
                "\n" +
                "Нікіфорова Яна Василівна\n" +
                "гастроентеролог, терапевт +380686111122\n" +
                "\n" +
                "Стороженко Тетяна Євгенівна,\n" +
                "кардіолог +380979235161\n" +
                "\n" +
                "Лапшина Катерина Аркадіївна,\n" +
                "гастроентеролог, терапевт  +380662953214";
    }
    public String getDoctors(){
        return doctors();
    }
    private String humanitarianHelp(){
        String text = "\"Гарячі лінії\" та центри допомоги евакуйованим та біженцям:\n\n";
        text += "Вінницька\n" +
                "(067) 773-45-38\n" +
                "\n" +
                "Волинська\n" +
                "(0332) 77-82-11, (066) 657-09-15\n" +
                "\n" +
                "Дніпропетровська\n" +
                "(097) 881-78-66, (050) 322-34-00\n" +
                "\n" +
                "Донецька (ракуванням военно обстановки)\n" +
                "(050) 347-90-70, (095) 406-27-29\n" +
                "\n" +
                "Житомирська\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Запорізька\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Закарпатська\n" +
                "(096) 284-33-68, (0312) 42-80-29, (0312) 42-80-30 (м. Ужгород)\n" +
                "\n" +
                "Івано-Франківська\n" +
                "(0342) 55-18-68, (068) 376-77-62\n" +
                "\n" +
                "м. Київ\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Кіровоградська\n" +
                "(0522) 30-50-39, (0800) 50-02-38 (Облдеджадміністрація)\n" +
                "\n" +
                "Київська\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Луганська\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Львiвська\n" +
                "(032) 254-60-15, (032) 297-59-11 (м. Львiв), (032) 259-60-31 (Облдержадмiнiстрацiя)\n" +
                "\n" +
                "Миколаївська\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "test_one_more, [05.05.2022 12:02]\n" +
                "Одеська\n" +
                "(094) 945-45-02, (067) 992-66-21, (048) 793-46-03,\n" +
                "(093) 392-96-15, (098) 615-57-01\n" +
                "\n" +
                "Рівненська\n" +
                "(0800) 50-00-78 (Облдержадміністрація),(0362) 40-01-00 (м. Рівне), (098) 505-83-25\n" +
                "\n" +
                "Сумська\n" +
                "Не приймає евакуцоване населення\n" +
                "\n" +
                "Тернопільська\n" +
                "(096) 337-38-70, (067) 720-65-56\n" +
                "\n" +
                "Харківська\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Xepcонська\n" +
                "Не приймає евакуйоване населення\n" +
                "\n" +
                "Хмельницька\n" +
                "(067) 380-17-21, (067) 380-15-57, (067) 380-28-08, (0382) 76-45-79, (0382) 76-47-00 (облдержадмiнiстрацiя)\n" +
                "\n" +
                "Черкаська\n" +
                "(068) 621-80-29, (050) 420-13-56, (0800) 50-88-76 (Облдержадмiнiстрацiя)\n" +
                "\n" +
                "Чернівецька\n" +
                "(095) 153-62-98, (098) 508-84-84\n" +
                "\n" +
                "Чернігівська\n" +
                "Не приймає евакуйоване населення";
        return text;
    }
    public String getHumanitarianHelp(){
        return humanitarianHelp();
    }
    //служба розшуку
    private String searchService(){
        String text = "У разі втрати зв’язку зі своїми близькими Ви можете звернутись до Служби розшуку Червоного Хреста України за вказаними нижче номера:\n\n";
        text += "▫️Київ 096 304 4375, 066 250 9957\n";
        text += "▫️Львів 095 250 1274\n";
        text += "▫️Харків 099 206 5493\n";
        text += "▫️Дніпро 095 250 1181\n";
        text += "▫️Краматорськ 095 250 1239\n\n";
        text += "Будьте на зв’язку зі своїми рідними!";
        return text;
    }
    public String getSearchService(){
        return searchService();
    }
    private String shelters(){
        return "Як дізнатися, де найближче укриття?\n\nЩоб отримати інформацію про укриття оберіть назву міста або обласного центра:";
    }
    public String getShelters(){
        return shelters();
    }
    // клавіатура укриттів
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
    //Київ
    private String Kyiv(){
        return "Київ\n" +
                "\n" +
                "Укриття\n" +
                "До фонду захисних споруд цивільного захисту Києва входять понад 500 сховищ.\n" +
                "Також майже 4500 споруд подвійного використання, де можуть укритися мешканці міста.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1nv3QreO1QS5_AmRRNLHXu7u99sKJ6JRR&ll=50.43948441581479%2C30.502664219511257&z=10";
    }
    public String getKyiv(){
        return Kyiv();
    }
    //Київська область
    private String KyivRegion(){
        return "Київська область\n" +
                "Укриття\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1pjF8h5LfFVYAJhPcPY3HOZY9ffRHusDz&ll=50.40038042458478%2C30.773148000000013&z=7";
    }
    public String getKyivRegion(){
        return KyivRegion();
    }
    //Львів
    private String Lviv(){
        return "Львів\n" +
                "\n" +
                "Укриття\n" +
                "У Львівській області — 937 захисних споруд, з яких понад 600 – протирадіаційні укриття, та майже 170 тисяч найпростіших укриттів.\n" +
                "\n" +
                "Карта: https://map.city-adm.lviv.ua/map/main?fbclid=IwAR3lZpOr4RL3XgRdDSX8iXQxLqb4zfih7iaogRK2ffEyFLcwdeJ082SIBpo#map=16//49.815571675347655//24.035575389862064&&layer=9635585433681688-1,100//2765617480184367031-1,100";
    }
    public String getLviv(){
        return Lviv();
    }
    //Харків
    private String Kharkiv(){
        return "Харків\n" +
                "\n" +
                "Укриття\n" +
                "\n" +
                "У Харкові є 300 укриттів, 4000 підвалів у житлових будинках, станції метро, переходи, паркінги. \n" +
                "\n" +
                "Карта: https://smart.gis.digital/opendataportal/";
    }
    public String getKharkiv(){
        return Kharkiv();
    }
    //Одеса
    private String Odesa(){
        return "Одеса\n" +
                "\n" +
                "Укриття\n" +
                "Кількість бомбосховищ в Одесі сягає 353. Є близько 800 споруд подвійного призначення.\n" +
                "\n" +
                "Карти\n" +
                "https://www.google.com/maps/d/u/0/viewer?mid=1f7Nswyb-hXG0wkFDhyGYFbrANok&ll=46.58906677539809%2C30.783757898394832&z=7\n" +
                "\n" +
                "https://www.google.com/maps/d/u/0/viewer?mid=1a7sSuBwd-OItlDfema2gi5ojAUo&ll=46.52816428413388%2C30.805670039909884&z=10";
    }
    public String getOdesa(){
        return Odesa();
    }
    //Луцьк
    private String Lutsk(){
        return "Луцьк\n" +
                "    \n" +
                "Укриття\n" +
                "Фонд захисних споруд складається зі 101-ї захисної споруди: 61 сховище і 40 протирадіаційних укриттів.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1LI3929tnePZ2kiOQPd_Z-HnVm-4&ll=50.74804140931068%2C25.350397570153085&z=13";
    }
    public String getLutsk(){
        return Lutsk();
    }
    //Полтава
    private String Poltava(){
        return "Полтава\n" +
                "\n" +
                "Укриття\n" +
                "Фонд захисних споруд складається зі 101-ї захисної споруди: 61 сховище і 40 протирадіаційних укриттів.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1LI3929tnePZ2kiOQPd_Z-HnVm-4&ll=50.74804140931068%2C25.350397570153085&z=13";
    }
    public String getPoltava(){
        return Poltava();
    }
    //Івано-Франківськ
    private String IvanoFrankivsk(){
        return "Івано-Франківськ\n" +
                "\n" +
                "Укриття\n" +
                "В області — 790 захисних споруд. З них — 112 сховищ та 678 протирадіаційних укриттів. Є 937 найпростіших укриттів, серед яких підвали багатоповерхівок, підземні стоянки тощо.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1LI3929tnePZ2kiOQPd_Z-HnVm-4&ll=50.74804140931068%2C25.350397570153085&z=13";
    }
    public String getIvanoFrankivsk(){
        return IvanoFrankivsk();
    }
    //Тернопіль
    private String Ternopil(){
        return "Тернопіль\n" +
                "\n" +
                "Укриття\n" +
                "В Тернополі 92 захисні споруди, з них 55 сховищ та 37 протирадіаційних укриттів, а також 127 найпростіших укриттів.\n" +
                "\n" +
                "Карта: https://giscid.maps.arcgis.com/apps/View/index.html?appid=cf66288d0b34497ba8530415606f6a5e";
    }
    public String getTernopil(){
        return Ternopil();
    }
    //Чернігів
    private String Chernihiv(){
        return "Чернігів\n" +
                "\n" +
                "Укриття\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?hl=ru&mid=1VJ4yH6VbKhqRP6Z1W3DB7vKhpXM&ll=51.52010647927098%2C31.276094464404316&z=13";
    }
    public String getChernihiv(){
        return Chernihiv();
    }
    //Вінниця
    private String Vinnitsa(){
        return "Вінниця\n" +
                "Укриття\n" +
                "На інтерактивній мапі — 70 обʼєктів укриттів.\n" +
                "\n" +
                "карта: https://www.google.com/maps/d/u/0/viewer?mid=1ODeqZzyrD--SR_Kk2QikzzbaplYFIKsq&ll=49.4211455824518%2C28.766926959374977&z=8";
    }
    public String getVinnitsa(){
        return Vinnitsa();
    }
    //Рівне
    private String Rivne(){
        return "Рівне\n" +
                "Укриття\n" +
                "У Рівному є 197 захисних споруд: сховища і протирадіаційні укриття\n" +
                "\n" +
                "карта: https://www.google.com/maps/d/u/0/viewer?mid=1XdSa-HTqSaJpYG_JGejkT99tlu8&ll=50.65412537987266%2C26.237628950000023&z=12";
    }
    public String getRivne(){
        return Rivne();
    }
    //Дніпро
    private String Dnipro(){
        return "Дніпро\n" +
                "Укриття\n" +
                "Фонд захисних споруд області нараховує 916 сховищ та 664 протирадіаційних укриттів.\n" +
                "\n" +
                "карта: https://www.google.com/maps/d/u/0/viewer?mid=1VT7MBpAXCVfa3_ToOzlovSpW5RRO3lWZ&ll=48.03873735637055%2C35.49263049687501&z=8";
    }
    public String getDnipro(){
        return Dnipro();
    }
    //Житомир
    private String Zhytomyr(){
        return "Житомир\n" +
                "Укриття\n" +
                "В межах Житомирської міської обʼєднаної територіальної громади розташовано 90 сховищ, чотири протирадіаційних укриття та перебуває на обліку 521 найпростіше укриття.\n" +
                "\n" +
                "перелік: http://old.zt-rada.gov.ua/pages/p6470";
    }
    public String getZhytomyr(){
        return Zhytomyr();
    }
    //Чернівці
    private String Chernivtsi(){
        return "Чернівці\n" +
                "Укриття\n" +
                "У місті більш ніж 130 спеціалізованих захисних споруд, але частина з них не придатна для перебування людей.\n" +
                "\n" +
                "карта: https://www.google.com/maps/d/u/0/viewer?mid=1oYvZrZg3VwPbRWtabOPfaMyI6Bk&ll=48.28230097635302%2C26.273463249999978&z=9";
    }
    public String getChernivtsi(){
        return Chernivtsi();
    }
    //Запоріжжя
    private String Zaporizhzhia(){
        return "Запоріжжя\n" +
                "Укриття\n" +
                "\n" +
                "В місті — 2246 укриттів різного типу. З них 1950 найпростіших – підвальні приміщення.\n" +
                "\n" +
                "карта: https://ukryttya.zp.gov.ua";
    }
    public String getZaporizhzhia(){
        return Zaporizhzhia();
    }
    //Запоріжжя
    private String Cherkasy(){
        return "Черкаси\n" +
                "\n" +
                "Укриття\n" +
                "В місті Черкаси на обліку перебуває 92 захисні споруди цивільного захисту.\n" +
                "\n" +
                "Карта: http://dozor.cc.ua/shell.html\n" +
                "\n" +
                "Перелік: http://chmr.gov.ua/upload/567.pdf";
    }
    public String getCherkasy(){
        return Cherkasy();
    }
    //Миколаїів
    private String Mykolaiv(){
        return "Миколаїв\n" +
                "\n" +
                "Укриття\n" +
                "У Миколаєві розташовані 222 захисні споруди. З них 72 — у житлових будинках.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1DD_gnR2xEeidXqh0UF4tmPvVzlX1OdzQ&hl=ru&ll=46.94075430633404%2C31.990934449999997&z=11\n" +
                "\n" +
                "Перелік: https://mkrada.gov.ua/content/bomboshovishche.html";
    }
    public String getMykolaiv(){
        return Mykolaiv();
    }
    //Кропивницький
    private String Kropyvnytskyi(){
        return "Кропивницький\n" +
                "\n" +
                "Укриття\n" +
                "У Кропивницькому є 55 укриттів і 190 сховищ. У області їх понад 1,5 тисячі, сховищ – майже 900.\n" +
                "\n" +
                "Перелік захисних споруд: http://kr-rada.gov.ua/perelik-zahisnih-sporud-tsivilnogo-zahistu-m-kropivnitskiy\n" +
                "\n" +
                "Перелік укриттів: http://kr-rada.gov.ua/site/uploads/files/Vyconavchi%20organy/Upravlinnya_s_pitan_nadzv_situaciy/perelik-ukrittiv.pdf";
    }
    public String getKropyvnytskyi(){
        return Kropyvnytskyi();
    }
    //Суми
    private String Sumy(){
        return "Суми\n" +
                "\n" +
                "Укриття\n" +
                "У Сумській області є 1009 захисних споруд – 191 сховище та 818 протирадіаційних укриттів. На обласний центр припадає 120 із них.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1U6JH6sTiCW37oU3nITeUTx5C5-k&ll=50.87006826989022%2C34.86703078587549&z=12\n" +
                "\n" +
                "Перелік: https://smr.gov.ua/images/dovidka/pro_ce_varto_znaty/Perel%D1%96k_najprost%D1%96shih_ukritt%D1%96v_m.Sumi.pdf";
    }
    public String getSumy(){
        return Sumy();
    }
    //Ужгород
    private String Uzhhorod(){
        return "Ужгород\n" +
                "\n" +
                "Укриття\n" +
                "На території Закарпатської області облаштовані 584 захисні споруди – з них 105 сховищ та 479 протирадіаційних укриттів.\n" +
                "В Ужгороді – 42 захисні споруди та майже 600 найпростіших укриттів.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=14VU7WtHmDj3DF2nPVbMBuDM7meXg3Vo6&ll=48.63665942610562%2C22.336026954043202&z=12";
    }
    public String getUzhhorod(){
        return Uzhhorod();
    }
    //Херсон
    private String Kherson(){
        return "Херсон\n" +
                "\n" +
                "Укриття\n" +
                "На Херсонщині розташовані 416 укриттів. На території Херсонської громади – 138 сховищ, 1 протирадіаційне укриття та 238 найпростіших укриттів (підвальні приміщення багатоквартирних житлових будинків).\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=1UvMNOVrvfUsrbXMOocTsq__NToM&ll=46.66752918814053%2C32.61267686714603&z=14";
    }
    public String getKherson(){
        return Kherson();
    }
    //Хмельницький
    private String Khmelnytskyi(){
        return "Хмельницький\n" +
                "\n" +
                "Укриття\n" +
                "У Хмельницькій області облаштовано понад 800 укриттів, у яких можна перебувати під час надзвичайних подій техногенного та військового характеру. 672 з них – у Хмельницькому.\n" +
                "\n" +
                "Карта: https://www.google.com/maps/d/u/0/viewer?mid=15NSLcOIYzWeSf46DD_Sd8iJJcKM&ll=49.422773625988505%2C26.964993879327505&z=12";
    }
    public String getKhmelnytskyi(){
        return Khmelnytskyi();
    }
    //Донецьк
    private String Donetsk(){
        return "Донецьк\n" +
                "\n" +
                "Укриття\n" +
                "У Донецькій області на території, підконтрольній українській владі, розташовані 764 об’єкти цивільного захисту для укриття населення.\n" +
                "\n" +
                "Карта: https://map.city-adm.lviv.ua/map/main#map=12//49.83731816924412//24.034996032714847&&layer=9635585433681688-1,100//2765617480184367031-1,100";
    }
    public String getDonetsk(){
        return Donetsk();
    }
    //Луганськ
    private String Luhansk(){
        return "Луганськ\n" +
                "\n" +
                "Укриття\n" +
                "\n" +
                "Карта укриттів в Луганській області:\n" +
                "https://www.google.com/maps/d/u/0/viewer?mid=1j_f6ytqZ9kO67Y0cOjgDfqIPmag&ll=49.153711568042674%2C39.069461000000004&z=8";
    }
    public String getLuhansk(){
        return Luhansk();
    }
}
