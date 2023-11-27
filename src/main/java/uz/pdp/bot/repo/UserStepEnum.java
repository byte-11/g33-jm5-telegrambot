package uz.pdp.bot.repo;

import lombok.Getter;

@Getter
public enum UserStepEnum {
    MAIN(1),
    FAST_FOOD(2),
    NATIONAL_FOOD(2),
    DRINKS(2),
    SALAD(2),
    DESSERT(2);

    private final int value;

    UserStepEnum(int value) {
        this.value = value;
    }

}
