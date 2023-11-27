package uz.pdp.bot.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.repo.UserStepEnum;
import uz.pdp.bot.repo.UserStepRepository;

public class MenuDisplayManager {
    @SneakyThrows
    public static void backToMain(final Message message, final TelegramLongPollingBot bot) {
        bot.execute(SendMessage.builder()
                .text("Main Menu")
                .chatId(message.getChatId())
                .replyMarkup(ButtonUtils.START_REPLY_MARKUP)
                .build());
        UserStepRepository.setStep(message.getChatId(), UserStepEnum.MAIN);
    }
}
