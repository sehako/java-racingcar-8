package racingcar;

public class RacingSimulator {

    private static final String CAR_NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_ATTEMPT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    public RacingSimulator(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public void simulate() {
        consoleWriter.printLine(CAR_NAMES_INPUT_GUIDE);
        String carNames = consoleReader.readLine();
        consoleWriter.printLine(RACING_ATTEMPT_INPUT_GUIDE);
        String racingAttempt = consoleReader.readLine();
    }
}
