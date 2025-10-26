package racingcar;

import java.math.BigInteger;

public class RacingCar {
    private String name;
    private BigInteger position;

    public RacingCar(String name) {
        this.name = name;
        this.position = BigInteger.ZERO;
    }

    public String getName() {
        return name;
    }

    public BigInteger getPosition() {
        return position;
    }
}
