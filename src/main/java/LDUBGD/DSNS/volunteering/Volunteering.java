package LDUBGD.DSNS.volunteering;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Volunteering {
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
    private String volunteering(){
        return "➡️ Заповнити анкету: https://bit.ly/3jb91VO\n" +
                "\n" +
                "Громадяни, які бажають брати участь в ліквідації наслідків надзвичайних ситуацій, спричинених збройною агресією російської федерації проти України: розборі завалів, рятуванні людей, наданні допомоги потерпілим, розвантаженні гуманітарних вантажів та інших заходів, можуть долучитися до добровільних формувань цивільного захисту.\n" +
                "\n" +
                "Зазначені формування утворюються на тимчасовій основі місцевими органами виконавчої влади, органами місцевого самоврядування тощо.\n" +
                "\n" +
                "➡️ Заповнити анкету: https://bit.ly/3jb91VO";
    }
    public String getVolunteering(){
        return volunteering();
    }

    private String volunteeringQuestions(){
        return "Надішліть номер, який ви бачите поряд з інформацією, яка Вас цікавить.\n" +
                "\n" +
                "91 - Я записався до добровольці-рятувальників, коли мене буде залучено?\n" +
                "\n" +
                "92 - Якщо я знаходжусь у резерві цивільного захисту і якщо потрібні добровольці цивільного захисту, чому мене не викликають як резервіста?\n" +
                "\n" +
                "93 -В анкеті «Я прагну стати добровольцем-рятувальником з питань цивільного захисту» варто зазначити місце проживання, чи місце де я бажаю допомогти?\n" +
                "\n" +
                "94 -Чому мене не залучають до робіт з розборів завалів, натомість долучають до розвантаження фур на блок постах, підмітання вулиць і тому подібне?";
    }
    public String getVolunteeringQuestions(){
        return volunteeringQuestions();
    }

    private String questionOne(){
        return "Питання. Я записався до добровольці-рятувальників, коли мене буде залучено?\n" +
                "\n" +
                "Відповідь. Після того, як Ви висловили бажання стати добровольцем-рятувальником з питань цивільного захисту та заповнили відповідну анкету на веб-порталі «Добровільна та місцева пожежна охорона», ДСНС опрацьовує інформацію та передає її до місцевих органів виконавчої влади, органів місцевого самоврядування, які за потреби залучають Вас до ліквідації наслідків НС (розбір завалів, рятування людей, надання допомоги потерпілим, розвантаження гуманітарних вантажів тощо).";
    }
    public String getQuestionOne(){
        return questionOne();
    }

    private String questionTwo(){
        return "Питання. Якщо я знаходжусь у резерві цивільного захисту і якщо потрібні добровольці цивільного захисту, чому мене не викликають як резервіста?\n" +
                "\n" +
                "Відповідь. На цей час в Україні відсутня потреба в залученні резервістів цивільного захисту до ліквідації наслідків надзвичайних ситуацій (розбір завалів, рятування людей, надання допомоги потерпілим, розвантаження гуманітарних вантажів тощо), оскільки оперативно-рятувальні підрозділи ДСНС виконують відповідні завдання в повному обсязі.\n" +
                "До того ж, в Україні є велика кількість громадян, які на безоплатній основі виявили бажання долучитися до діяльності добровільних формувань цивільного захисту з метою ліквідації наслідків НС.";
    }
    public String getQuestionTwo(){
        return questionTwo();
    }
    private String questionThree(){
        return "Питання. В анкеті «Я прагну стати добровольцем-рятувальником з питань цивільного захисту» варто зазначити місце проживання, чи місце де я бажаю допомогти?\n" +
                "\n" +
                "Відповідь. У відповідній анкеті зазначається місце проживання особи, яка виявила бажання долучитися до діяльності ДФЦЗ (як правило це і є місце де особа готова допомогти).\n" +
                "У разі, коли особа проживає в одному регіоні, а долучитися до ліквідації наслідків надзвичайних ситуацій (розбір завалів, рятування людей, надання допомоги потерпілим, розвантаження гуманітарних вантажів тощо)хоче в іншому, ДСНС просить безпосередньо звертатися до відповідних місцевих органів влади, органів самоврядування для прийняття відповідних рішень";
    }
    public String getQuestionThree(){
        return questionThree();
    }
    private String questionFour(){
        return "Питання. Чому мене не залучають до робіт з розборів завалів, натомість долучають до розвантаження фур на блок постах, підмітання вулиць і тому подібне?\n" +
                "\n" +
                "Відповідь. Добровольці-рятувальники залучаються не тільки до ліквідації наслідків надзвичайних ситуацій (розбір завалів, рятування людей, надання допомоги потерпілим), а і за потреби до інших допоміжних робіт, спрямованих на забезпечення належного рівня життєдіяльності населених пунктів, які постраждали від збройної агресії РФ, у тому числі це і розвантаження гуманітарних вантажів, прибирання вулиць тощо. Ваша допомога дуже важлива!";
    }
    public String getQuestionFour(){
        return questionFour();
    }

}
