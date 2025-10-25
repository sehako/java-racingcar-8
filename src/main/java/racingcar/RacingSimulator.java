package racingcar;

public class RacingSimulator {

    private static final String CAR_NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    public RacingSimulator(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public void simulate() {
        consoleWriter.printLine(CAR_NAMES_INPUT_GUIDE);
        String carNames = consoleReader.readLine();
    }
}
