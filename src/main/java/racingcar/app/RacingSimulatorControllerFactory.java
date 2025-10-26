package racingcar.app;

import racingcar.core.RacingSimulatorFactory;
import racingcar.io.ConsoleReader;
import racingcar.io.ConsoleWriter;
import racingcar.io.RacingConsoleReader;
import racingcar.io.RacingConsoleWriter;

public class RacingSimulatorControllerFactory {

    public RacingSimulatorController racingSimulatorController() {
        return new RacingSimulatorController(
                consoleWriter(),
                consoleReader(),
                racingSimulatorFactory()
        );
    }

    private ConsoleReader consoleReader() {
        return new RacingConsoleReader();
    }

    private ConsoleWriter consoleWriter() {
        return new RacingConsoleWriter();
    }

    private RacingSimulatorFactory racingSimulatorFactory() {
        return new RacingSimulatorFactory();
    }
}
