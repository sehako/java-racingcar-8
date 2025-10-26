package racingcar.domain.validator;

import static racingcar.io.ErrorMessage.CAR_NAME_LENGTH_OVER;
import static racingcar.io.ErrorMessage.EMPTY_CAR_LIST_INPUT;
import static racingcar.io.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.io.ErrorMessage.INVALID_CAR_NAME;

import java.util.regex.Pattern;

public class CarNameValidator {

    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("^[가-힣a-zA-Z]+$");

    private CarNameValidator() {
        throw new IllegalStateException("CarNameValidator cannot be instantiated");
    }

    public static void validateNotBlankInput(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException(EMPTY_CAR_LIST_INPUT);
        }
    }

    public static void validate(String target) {
        validateNotBlankCarName(target);
        validateNameLengthLimit(target);
        validateNameFormat(target);
    }

    private static void validateNotBlankCarName(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
    }

    private static void validateNameLengthLimit(String target) {
        if (target.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }
    }

    private static void validateNameFormat(String target) {
        if (!VALID_NAME_PATTERN.matcher(target).matches()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }
}