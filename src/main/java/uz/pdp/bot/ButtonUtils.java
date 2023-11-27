package uz.pdp.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

import static uz.pdp.bot.ButtonProps.BACK_PREV;
import static uz.pdp.bot.ButtonProps.FAST_FOOD_RM_BURGERS;
import static uz.pdp.bot.ButtonProps.FAST_FOOD_RM_HOT_DOG;
import static uz.pdp.bot.ButtonProps.FAST_FOOD_RM_LAVASH;
import static uz.pdp.bot.ButtonProps.FAST_FOOD_RM_SANDWICHES;
import static uz.pdp.bot.ButtonProps.FAST_FOOD_RM_SHAWARMA;
import static uz.pdp.bot.ButtonProps.START_RM_DESSERT;
import static uz.pdp.bot.ButtonProps.START_RM_DRINKS;
import static uz.pdp.bot.ButtonProps.START_RM_FAST_FOOD;
import static uz.pdp.bot.ButtonProps.START_RM_NATIONAL_FOOD;
import static uz.pdp.bot.ButtonProps.START_RM_SALAD;

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

    public static final ReplyKeyboardMarkup START_REPLY_MARKUP = ReplyKeyboardMarkup.builder()
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(START_RM_FAST_FOOD).build(),
                    KeyboardButton.builder().text(START_RM_NATIONAL_FOOD).build()))
            )
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(START_RM_DRINKS).build(),
                    KeyboardButton.builder().text(START_RM_SALAD).build())
            ))
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(START_RM_DESSERT).build()
            )
            ))
            .resizeKeyboard(true)
            .build();

    public static final ReplyKeyboardMarkup FAST_FOOD_REPLY_MARKUP = ReplyKeyboardMarkup.builder()
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(FAST_FOOD_RM_SHAWARMA).build()
            )))
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(FAST_FOOD_RM_LAVASH).build()
            )))
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(FAST_FOOD_RM_SANDWICHES).build()
            )))
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(FAST_FOOD_RM_BURGERS).build()
            )))
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(FAST_FOOD_RM_HOT_DOG).build()
            )))
            .keyboardRow(new KeyboardRow(List.of(
                    KeyboardButton.builder().text(BACK_PREV).build()
            )))
            .resizeKeyboard(true)
            .build();
}
