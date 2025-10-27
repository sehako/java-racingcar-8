package racingcar.util.parser;

import static racingcar.util.io.ErrorMessage.OVER_MAXIMUM_VALUE;
import static racingcar.util.validator.AttemptValidator.validate;
import static racingcar.util.validator.AttemptValidator.validateUnderMaximumRange;

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
