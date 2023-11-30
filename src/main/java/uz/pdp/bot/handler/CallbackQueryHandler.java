package uz.pdp.bot.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.model.Product;
import uz.pdp.bot.repo.ProductRepo;

public class CallbackQueryHandler {
    @SneakyThrows
    public static void handle(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        String data = callbackQuery.getData();
        if (data.startsWith("+")) {
            incrementQuantity(callbackQuery, bot);
        } else if (data.startsWith("-")) {
            decrementQuantity(callbackQuery, bot);
        }
    }

    private static void decrementQuantity(CallbackQuery callbackQuery, TelegramLongPollingBot bot) throws TelegramApiException {
        String[] params = callbackQuery.getData().split(";");
        if (!params[1].equals("1")) {
            InlineKeyboardMarkup markup = ButtonUtils.buildProductMarkup(
                    Integer.parseInt(params[1]) - 1,
                    Integer.parseInt(params[2])
            );
            long id = Long.parseLong(params[2]);
            Product product = ProductRepo.getById(id);

            EditMessageReplyMarkup build = EditMessageReplyMarkup.builder()
                    .replyMarkup(markup)
                    .inlineMessageId(callbackQuery.getInlineMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .build();

            bot.execute(build);
        }
    }

    @SneakyThrows
    public static void incrementQuantity(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        String[] params = callbackQuery.getData().split(";");
        InlineKeyboardMarkup markup = ButtonUtils.buildProductMarkup(
                Integer.parseInt(params[1]) + 1,
                Integer.parseInt(params[2])
        );

        EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                .replyMarkup(markup)
                .chatId(callbackQuery.getMessage().getChatId())
                .messageId(callbackQuery.getMessage().getMessageId())
                .build();

        bot.execute(editMessageReplyMarkup);
    }

}
