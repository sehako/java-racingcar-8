package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.validator.CarNameValidator;

public class RacingCarFactory {
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<RacingCar> racingCars(String carNames) {
        validateInput(carNames);
        return parseCarNames(carNames).stream()
                .map(RacingCarFactory::createCar)
                .collect(Collectors.toList());
    }

    private static void validateInput(String carNames) {
        CarNameValidator.validateNotBlankInput(carNames);
    }

    private static List<String> parseCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    private static RacingCar createCar(String carName) {
        String trimmedCarName = carName.trim();
        CarNameValidator.validate(trimmedCarName);
        return new RacingCar(trimmedCarName);
    }
}
