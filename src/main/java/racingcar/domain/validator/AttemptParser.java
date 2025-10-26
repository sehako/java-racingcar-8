package racingcar.domain.validator;

import static racingcar.domain.validator.AttemptValidator.validate;
import static racingcar.domain.validator.AttemptValidator.validateUnderMaximumRange;
import static racingcar.io.ErrorMessage.OVER_MAXIMUM_VALUE;

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
