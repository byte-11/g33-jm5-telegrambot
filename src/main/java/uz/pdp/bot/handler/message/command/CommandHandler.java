package uz.pdp.bot.handler.message.command;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.bot.ButtonUtils;

import java.io.File;
import java.util.List;

public class CommandHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) {

        switch (CommandEnum.of(message.getText())) {
            case START -> handleCommandStart(message, bot);
            case HELP -> handleCommandHelp(message, bot);
            case SHARE -> handleCommandShare(message, bot);
        }
    }

    @SneakyThrows
    private static void handleCommandShare(Message message, TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Reply Button 1").build(),
                        KeyboardButton.builder().text("Reply Button 2").build()
                )))
                .keyboardRow(new KeyboardRow(
                        List.of(
                                KeyboardButton.builder().text("Share you contact").requestContact(true).build(),
                                KeyboardButton.builder().text("Share you location").requestLocation(true).build()
                        )
                ))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Welcome");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    public static void handleCommandStart(final Message message, final TelegramLongPollingBot bot) {

        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Hello");
        sendMessage.setReplyMarkup(ButtonUtils.START_MARKUP);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    private static void handleCommandHelp(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/resources/photo_2023-10-23_01-01-05.jpg")));
        sendPhoto.setCaption("Spaceman photo");
        bot.execute(sendPhoto);
    }
}
