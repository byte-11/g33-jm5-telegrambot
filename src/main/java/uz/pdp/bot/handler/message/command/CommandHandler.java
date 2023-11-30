package uz.pdp.bot.handler.message.command;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.model.Product;
import uz.pdp.bot.repo.ProductRepo;
import uz.pdp.bot.repo.UserStepEnum;
import uz.pdp.bot.repo.UserStepRepository;

import java.io.File;

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
        Product product = ProductRepo.getById(1);
        SendPhoto sendPhoto = SendPhoto.builder()
                .photo(new InputFile(new File("src/main/resources/photo_2023-10-23_01-01-05.jpg")))
                .chatId(message.getChatId())
                .caption(product.getName() + "\n"
                        + product.getDescription()
                        + "\n" + product.getPrice())
                .replyMarkup(ButtonUtils.buildProductMarkup(1, 1)).build();
//                .build();
//        sendPhoto.setReplyMarkup(ButtonUtils.buildProductMarkup(1,1));
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void handleCommandStart(final Message message, final TelegramLongPollingBot bot) {
    }

    @SneakyThrows
    private static void handleCommandHelp(final Message message, final TelegramLongPollingBot bot) {
    }
}
