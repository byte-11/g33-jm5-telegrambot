package uz.pdp.bot.handler.message;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.handler.message.command.CommandHandler;

public class MessageHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        if (message.isCommand()) {
            CommandHandler.handle(message, bot);
        } else if (message.hasText()) {
            TextHandler.handle(message, bot);
        } else if ( message.hasPhoto()){
            PhotoHandler.handle(message, bot);
        } else if (message.hasContact()) {

        } else if (message.hasLocation()) {

        }
    }
}
