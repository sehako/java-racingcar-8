package racingcar;

public class Application {

    public static void main(String[] args) {
        ConsoleWriter consoleWriter = new RacingConsoleWriter();
        RacingConsoleReader consoleReader = new RacingConsoleReader();
        RacingSimulatorController racingSimulatorController =
                new RacingSimulatorController(consoleWriter, consoleReader);

        racingSimulatorController.run();
    }
}
