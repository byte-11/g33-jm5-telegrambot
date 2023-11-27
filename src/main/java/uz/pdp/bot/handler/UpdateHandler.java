package uz.pdp.bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.bot.handler.message.MessageHandler;

public class UpdateHandler {

    public static void handle(final Update update, final TelegramLongPollingBot bot) {
        if (update.hasMessage()) {
            MessageHandler.handle(update.getMessage(), bot);
        } else if (update.hasCallbackQuery()) {
            CallbackQueryHandler.handle(update.getCallbackQuery(), bot);
        }
    }
}
