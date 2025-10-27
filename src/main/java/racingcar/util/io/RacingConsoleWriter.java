package racingcar.util.io;

public class RacingConsoleWriter implements ConsoleWriter {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
