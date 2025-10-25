package racingcar;

public class RacingConsoleWriter implements ConsoleWriter {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }
}
