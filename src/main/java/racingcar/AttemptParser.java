package racingcar;

import java.math.BigInteger;

public class AttemptParser {
    public static BigInteger parse(String attempt) {
        AttemptValidator.validate(attempt);
        return new BigInteger(attempt);
    }
}
