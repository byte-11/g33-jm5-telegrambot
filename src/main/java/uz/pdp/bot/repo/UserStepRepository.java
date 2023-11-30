package uz.pdp.bot.repo;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class UserStepRepository {
    private static final Map<Long, UserStepEnum> STEPS = new HashMap<>();


    public static void setStep(final Long id, final UserStepEnum step) {
        STEPS.put(id, step);
    }

    public static UserStepEnum getCurrentUserStep(final Long id) {
        return STEPS.get(id);
    }
}
