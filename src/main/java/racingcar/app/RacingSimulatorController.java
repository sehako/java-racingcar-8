package racingcar.app;

import java.util.List;
import racingcar.core.RacingSimulator;
import racingcar.core.RacingSimulatorFactory;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarFactory;
import racingcar.domain.validator.AttemptParser;
import racingcar.io.ConsoleReader;
import racingcar.io.ConsoleWriter;

public class RacingSimulatorController {
    private static final String CAR_NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_ATTEMPT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";
    private static final String RACING_RESULT_FORMAT = "최종 우승자 : %s";

    private final ConsoleWriter consoleWriter;
    private final ConsoleReader consoleReader;
    private final RacingSimulatorFactory racingSimulatorFactory;

    public RacingSimulatorController(
            ConsoleWriter consoleWriter,
            ConsoleReader consoleReader,
            RacingSimulatorFactory racingSimulatorFactory) {
        this.consoleWriter = consoleWriter;
        this.consoleReader = consoleReader;
        this.racingSimulatorFactory = racingSimulatorFactory;
    }

    public void run() {
        consoleWriter.printLine(CAR_NAMES_INPUT_GUIDE);
        String carNames = consoleReader.readLine();
        consoleWriter.printLine(RACING_ATTEMPT_INPUT_GUIDE);
        String racingAttempt = consoleReader.readLine();

        List<RacingCar> racingCars = RacingCarFactory.racingCars(carNames);
        int racingAttemptNumber = AttemptParser.parse(racingAttempt);

        List<String> winners = startRacing(racingCars, racingAttemptNumber);
        printWinners(winners);
    }

    private List<String> startRacing(List<RacingCar> racingCars, int racingAttemptNumber) {
        RacingSimulator racingSimulator = racingSimulatorFactory
                .racingSimulator(consoleWriter, racingCars, racingAttemptNumber);

        return racingSimulator.simulate();
    }

    private void printWinners(List<String> winners) {
        String winnerString = String.join(", ", winners);
        consoleWriter.printLine(String.format(RACING_RESULT_FORMAT, winnerString));
    }

    public void stop() {
        consoleReader.close();
    }
}
