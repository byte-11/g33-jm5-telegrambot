package uz.pdp.bot.handler.message;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.handler.MenuDisplayManager;
import uz.pdp.bot.repo.UserStepEnum;
import uz.pdp.bot.repo.UserStepRepository;

import static uz.pdp.bot.ButtonProps.BACK_PREV;
import static uz.pdp.bot.ButtonProps.START_RM_FAST_FOOD;

public class TextHandler {
    @SneakyThrows
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        handleReplyMarkup(message, bot);
    }

    private static void handleReplyMarkup(final Message message, final TelegramLongPollingBot bot) {
        switch (message.getText()) {
            case START_RM_FAST_FOOD -> handleFastFood(message, bot);
            case BACK_PREV -> handleBack(message, bot);
        }
    }

    private static void handleBack(final Message message, final TelegramLongPollingBot bot) {
        switch (UserStepRepository.getCurrentUserStep(message.getChatId()).getValue()) {
            case 2 -> MenuDisplayManager.backToMain(message, bot);
        }
    }

    @SneakyThrows
    private static void handleFastFood(final Message message, final TelegramLongPollingBot bot) {
        bot.execute(SendMessage.builder()
                .chatId(message.getChatId())
                .text("Fast Food")
                .replyMarkup(ButtonUtils.FAST_FOOD_REPLY_MARKUP)
                .build());
        UserStepRepository.setStep(message.getChatId(), UserStepEnum.FAST_FOOD);
    }

    /**
     * Do not try at home. It is too dangerous.
     */
    @SneakyThrows
    private static void deleteReplyMarkupText(final Message message, final TelegramLongPollingBot bot) {
        bot.execute(DeleteMessage.builder()
                .chatId(message.getChatId())
                .messageId(message.getMessageId())
                .build());
    }

}
