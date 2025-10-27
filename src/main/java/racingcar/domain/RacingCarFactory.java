package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.parser.CarNameParser;

public class RacingCarFactory {

    public static List<RacingCar> racingCars(String carNames) {
        List<String> parsedCarNames = CarNameParser.parse(carNames);

        return parsedCarNames.stream()
                .map(RacingCarFactory::createCar)
                .collect(Collectors.toList());
    }

    private static RacingCar createCar(String carName) {
        return new RacingCar(carName);
    }
}
