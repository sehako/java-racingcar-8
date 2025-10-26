package racingcar;

import racingcar.app.RacingSimulatorController;
import racingcar.app.RacingSimulatorControllerFactory;

public class Application {

    public static void main(String[] args) {
        RacingSimulatorControllerFactory racingSimulatorControllerFactory = new RacingSimulatorControllerFactory();

        RacingSimulatorController racingSimulatorController
                = racingSimulatorControllerFactory.racingSimulatorController();

        try {
            racingSimulatorController.run();
        } finally {
            racingSimulatorController.stop();
        }
    }
}
