package LDUBGD.DSNS.processors;

import LDUBGD.DSNS.processors.handlers.CallbackQueryHandler;
import LDUBGD.DSNS.processors.handlers.MessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
@Component
public class DefaultProcessor implements Processor {

    private final MessageHandler messageHandler;
    private final CallbackQueryHandler callbackQueryHandler;

    public DefaultProcessor(MessageHandler messageHandler, CallbackQueryHandler callbackQueryHandler) {
        this.messageHandler = messageHandler;
        this.callbackQueryHandler = callbackQueryHandler;
    }


    @Override
    public void executeMessage(Message message) {
        messageHandler.choose(message);
    }

    @Override
    public void executeCallBackQuery(CallbackQuery callbackQuery) {
        callbackQueryHandler.choose(callbackQuery);
    }
}
