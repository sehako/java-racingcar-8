package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingSimulator {
    private final ConsoleWriter consoleWriter;
    private final List<RacingCar> racingCars;
    private final int racingAttempt;
    private int currentAttempt;

    public RacingSimulator(
            List<RacingCar> racingCars,
            ConsoleWriter consoleWriter,
            int racingAttempt
    ) {
        this.racingCars = racingCars;
        this.consoleWriter = consoleWriter;
        this.racingAttempt = racingAttempt;
        currentAttempt = 0;
    }

    public List<String> simulate() {
        for (int i = currentAttempt; i < racingAttempt; i++) {
            processRacingAttempt();

        }

        return null;
    }

    private void processRacingAttempt() {
        for (RacingCar car : racingCars) {
            int roulette = Randoms.pickNumberInRange(0, 9);
            moveRacingCar(car, roulette);
        }
    }

    private void moveRacingCar(RacingCar car, int roulette) {
        if (roulette < 4) {
            return;
        }

        car.moveForward();
    }

}
