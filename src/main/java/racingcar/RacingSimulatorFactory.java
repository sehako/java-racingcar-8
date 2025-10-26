package racingcar;

import java.util.List;

public class RacingSimulatorFactory {
    public RacingSimulator racingSimulator(
            ConsoleWriter consoleWriter,
            List<RacingCar> racingCars,
            int racingAttempt
    ) {
        return new RacingSimulator(racingCars, consoleWriter, racingAttempt);
    }
}
