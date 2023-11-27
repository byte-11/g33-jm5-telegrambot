package uz.pdp.bot.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.handler.message.command.CommandHandler;

import java.util.List;

public class CallbackQueryHandler {
    @SneakyThrows
    public static void handle(final CallbackQuery callbackQuery, final TelegramLongPollingBot bot) {
        String data = callbackQuery.getData();
        if (data.equals("btn-1")) {
            handleBtn1(callbackQuery, bot, data);
        } else if (data.equals("btn-2")) {
            InlineKeyboardMarkup keyboardMarkup = InlineKeyboardMarkup.builder()
                    .keyboardRow(List.of(
                            InlineKeyboardButton.builder().text("◀\uFE0F").callbackData("prev").build(),
                            InlineKeyboardButton.builder().text("Button-10").callbackData("btn-10").build()
                    )).build();
            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .replyMarkup(keyboardMarkup).build();

            bot.execute(editMessageReplyMarkup);
        } else if (data.equals("prev")) {
//            CommandHandler.handleCommandStart(callbackQuery.getMessage(), bot);
            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .messageId(callbackQuery.getMessage().getMessageId())
                    .chatId(callbackQuery.getMessage().getChatId())
                    .replyMarkup(ButtonUtils.START_MARKUP).build();
            bot.execute(editMessageReplyMarkup);
        } else {
            AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                    .callbackQueryId(callbackQuery.getId())
                    .text("Sorry , This is feature is not available")
                    .cacheTime(5)
                    .showAlert(true).build();
            bot.execute(answerCallbackQuery);
        }
    }

    private static void handleBtn1(CallbackQuery callbackQuery, TelegramLongPollingBot bot, String data) throws TelegramApiException {
        InlineKeyboardMarkup keyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Button-7").callbackData("btn-7").build(),
                        InlineKeyboardButton.builder().text("Button-8").callbackData("btn-8").build()
                )).build();
        SendMessage sendMessage = new SendMessage(callbackQuery.getMessage().getChatId().toString(),
                data + " is pressed");
        sendMessage.setReplyMarkup(keyboardMarkup);
        bot.execute(sendMessage);
    }
}
