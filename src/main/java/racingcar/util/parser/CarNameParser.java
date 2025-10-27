package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.util.validator.CarNameValidator;

public class CarNameParser {
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> parse(String carNames) {
        validateInput(carNames);

        String[] splitCarNames = carNames.split(CAR_NAME_DELIMITER);

        return Arrays.stream(splitCarNames)
                .map(carName -> {
                    String trimmedCarName = carName.trim();
                    CarNameValidator.validate(trimmedCarName);
                    return trimmedCarName;
                })
                .toList();
    }

    private static void validateInput(String carNames) {
        CarNameValidator.validateNotBlankInput(carNames);
    }

}
