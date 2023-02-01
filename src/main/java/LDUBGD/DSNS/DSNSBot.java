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
        return "dsns_ua_test_bot";
    }

    @Override
    public String getBotToken() {
        return "5847217095:AAHIz8SbaDLrxgWgrk2MjFZvJFdJ2O-V63k";
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
