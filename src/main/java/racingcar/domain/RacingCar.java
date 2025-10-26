package racingcar.domain;

public class RacingCar {
    private String name;
    private String progress;

    public RacingCar(String name) {
        this.name = name;
        this.progress = "";
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }

    public void moveForward() {
        this.progress += "-";
    }
}
