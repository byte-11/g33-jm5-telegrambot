package uz.pdp.bot.handler.message;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TextHandler {
    @SneakyThrows
    public static void handle(final Message message, final TelegramLongPollingBot bot) {

        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), message.getText());
        bot.execute(sendMessage);
    }
}
