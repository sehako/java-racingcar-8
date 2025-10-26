package racingcar;

public class AttemptParser {

    public static int parse(String attempt) {
        AttemptValidator.validate(attempt);
        int parsedAttempt = Integer.parseInt(attempt);

        return parsedAttempt;
    }
}
