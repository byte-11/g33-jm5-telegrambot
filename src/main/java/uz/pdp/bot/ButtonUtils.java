package uz.pdp.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ButtonUtils {
    public static final InlineKeyboardMarkup START_MARKUP = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(
            InlineKeyboardButton.builder().text("Button-1").callbackData("btn-1").build(),
                        InlineKeyboardButton.builder().text("Button-2").callbackData("btn-2").build(),
                        InlineKeyboardButton.builder().text("Button-3").callbackData("btn-3").build()
                ))
                        .keyboardRow(List.of(
            InlineKeyboardButton.builder().text("Button-4").callbackData("btn-4").build()
                ))
                        .keyboardRow(List.of(
            InlineKeyboardButton.builder().text("Button-5").callbackData("btn-5").build(),
                        InlineKeyboardButton.builder().text("Button-6").callbackData("btn-6").build()
                ))
                        .build();
}
