package racingcar;

public class Application {

    public static void main(String[] args) {
        ConsoleWriter consoleWriter = new RacingConsoleWriter();
        try (RacingConsoleReader consoleReader = new RacingConsoleReader()) {
            RacingSimulator racingSimulator = new RacingSimulator(consoleReader, consoleWriter);
            racingSimulator.simulate();
        }
    }
}
