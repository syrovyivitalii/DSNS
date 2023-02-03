package LDUBGD.DSNS;

import LDUBGD.DSNS.processors.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class DSNSBot extends TelegramLongPollingBot {

    @Value("${bot.BOT_TOKEN}")
    private String botToken;

    @Value("${bot.BOT_USERNAME}")
    private String botUsername;
    private Processor processor;


    @Override
    public String getBotUsername() {
//        return "UA_DSNS_bot";
        return botUsername;
    }

    @Override
    public String getBotToken() {
//         BOT_TOKEN = "5060428209:AAG_mGRO57BgUnWjJFI6a5oCHVNIpkRnhnQ";
        return botToken;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        processor.process(update);
    }

    @Autowired
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
