package racingcar.core;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.io.ConsoleWriter;

public class RacingSimulatorFactory {
    public RacingSimulator racingSimulator(
            ConsoleWriter consoleWriter,
            List<RacingCar> racingCars,
            int racingAttempt
    ) {
        return new RacingSimulator(racingCars, consoleWriter, racingAttempt);
    }
}
