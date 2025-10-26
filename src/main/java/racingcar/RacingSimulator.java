package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingSimulator {

    private static final String RACING_RESULT = "실행 결과";
    private static final String RACING_PROGRESS_FORMAT = "%s : %s";

    private final ConsoleWriter consoleWriter;
    private final List<RacingCar> racingCars;
    private final int racingAttempt;

    public RacingSimulator(
            List<RacingCar> racingCars,
            ConsoleWriter consoleWriter,
            int racingAttempt
    ) {
        this.racingCars = racingCars;
        this.consoleWriter = consoleWriter;
        this.racingAttempt = racingAttempt;
    }

    public List<String> simulate() {
        consoleWriter.printLine(RACING_RESULT);

        for (int i = 0; i < racingAttempt; i++) {
            processRacingAttempt();
            printRacingProgress();
        }

        return findWinner();
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

    private void printRacingProgress() {
        for (RacingCar car : racingCars) {
            String progress = String.format(RACING_PROGRESS_FORMAT, car.getName(), car.getProgress());
            consoleWriter.printLine(progress);
        }
        consoleWriter.printLine("");
    }

    private List<String> findWinner() {
        int maxProgress = getMaximumProgress();

        return racingCars.stream()
                .filter(racingCar -> {
                    String progress = racingCar.getProgress();
                    return progress.length() == maxProgress;
                })
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getMaximumProgress() {
        return racingCars.stream()
                .mapToInt(racingCar -> {
                    String progress = racingCar.getProgress();
                    return progress.length();
                }).max().orElse(0);
    }
}
