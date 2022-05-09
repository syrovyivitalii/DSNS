package LDUBGD.DSNS;

import LDUBGD.DSNS.processors.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class DSNSBot extends TelegramLongPollingBot {
    private Processor processor;


    @Override
    public String getBotUsername() {
        return "UA_DSNS_bot";
    }

    @Override
    public String getBotToken() {
        return "5060428209:AAG_mGRO57BgUnWjJFI6a5oCHVNIpkRnhnQ";
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
