package racingcar;

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
