package racingcar.util.validator;

import static racingcar.util.io.ErrorMessage.DECIMAL_NUMBER;
import static racingcar.util.io.ErrorMessage.EMPTY_ATTEMPT_INPUT;
import static racingcar.util.io.ErrorMessage.NON_NUMERIC_VALUE;
import static racingcar.util.io.ErrorMessage.OVER_MAXIMUM_VALUE;
import static racingcar.util.io.ErrorMessage.ZERO_OR_NEGATIVE_VALUE;
import static racingcar.util.io.ErrorMessage.ZERO_START_VALUE;

import java.util.regex.Pattern;

public class AttemptValidator {

    private static final Pattern ATTEMPT_PATTERN = Pattern.compile("^[0-9]+$");
    private static final int MAXIMUM_ATTEMPT = 100;

    private AttemptValidator() {
        throw new IllegalStateException("Attempt validator cannot be instantiated");
    }

    public static void validate(String attempt) {
        validateNotBlankAttempt(attempt);
        validateNumericValue(attempt);
        validateNonZeroStart(attempt);
    }

    private static void validateNotBlankAttempt(String attempt) {
        if (attempt == null || attempt.isBlank()) {
            throw new IllegalArgumentException(EMPTY_ATTEMPT_INPUT);
        }
    }

    private static void validateNumericValue(String attempt) {
        if (ATTEMPT_PATTERN.matcher(attempt).matches()) {
            return;
        }

        validateNotZeroOrNegative(attempt);
        validateNotDecimal(attempt);
        throw new IllegalArgumentException(NON_NUMERIC_VALUE);
    }

    private static void validateNotZeroOrNegative(String attempt) {
        if (attempt.contains("-") || "0".equals(attempt)) {
            throw new IllegalArgumentException(ZERO_OR_NEGATIVE_VALUE);
        }
    }

    private static void validateNotDecimal(String attempt) {
        if (attempt.contains(".")) {
            throw new IllegalArgumentException(DECIMAL_NUMBER);
        }
    }

    private static void validateNonZeroStart(String target) {
        if (target.startsWith("0")) {
            throw new IllegalArgumentException(ZERO_START_VALUE);
        }
    }

    public static void validateUnderMaximumRange(int attempt) {
        if (attempt > MAXIMUM_ATTEMPT) {
            throw new IllegalArgumentException(OVER_MAXIMUM_VALUE);
        }
    }
}