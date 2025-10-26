package racingcar;

import static racingcar.AttemptValidator.validate;
import static racingcar.AttemptValidator.validateUnderMaximumRange;
import static racingcar.ErrorMessage.OVER_MAXIMUM_VALUE;

public class AttemptParser {

    public static int parse(String attempt) {
        validate(attempt);

        int attemptNumber = convertToNumber(attempt);

        validateUnderMaximumRange(attemptNumber);
        return attemptNumber;
    }

    private static int convertToNumber(String attempt) {
        int result;

        try {
            result = Integer.parseInt(attempt);
            validateUnderMaximumRange(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OVER_MAXIMUM_VALUE);
        }

        return result;
    }
}
