package uz.pdp.bot.handler.message.command;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.pdp.bot.ButtonUtils;
import uz.pdp.bot.repo.UserStepEnum;
import uz.pdp.bot.repo.UserStepRepository;

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

    }

    @SneakyThrows
    public static void handleCommandStart(final Message message, final TelegramLongPollingBot bot) {
        bot.execute(
                SendMessage.builder().chatId(message.getChatId())
                        .text("Welcome")
                        .replyMarkup(ButtonUtils.START_REPLY_MARKUP)
                        .build()
        );
        UserStepRepository.setStep(message.getChatId(), UserStepEnum.MAIN);
    }

    @SneakyThrows
    private static void handleCommandHelp(final Message message, final TelegramLongPollingBot bot) {

    }
}
