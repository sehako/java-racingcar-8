package racingcar;

import java.math.BigInteger;
import java.util.List;

public class RacingSimulatorController {
    private static final String CAR_NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_ATTEMPT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

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
        BigInteger racingAttemptNumber = AttemptParser.parse(racingAttempt);
    }

    public void stop() {
        consoleReader.close();
    }
}
