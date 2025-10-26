package racingcar;

public class ErrorMessage {
    public static final String EMPTY_CAR_LIST_INPUT = "경기에 참가할 자동차들을 입력해주세요.";
    public static final String EMPTY_CAR_NAME = "자동차 이름을 입력해주세요.";
    public static final String CAR_NAME_LENGTH_OVER = "자동차 이름은 5글자를 초과할 수 없습니다.";
    public static final String INVALID_CAR_NAME
            = "자동차 이름은 알파벳과 완성형 한글(자음 또는 모음 단독 사용 금지)만 입력할 수 있습니다.";

    public static final String EMPTY_ATTEMPT_INPUT = "시도 횟수를 입력해주세요.";
    public static final String NON_NUMERIC_VALUE = "숫자 이외의 문자또는 특수문자는 입력할 수 없습니다.";
    public static final String DECIMAL_NUMBER = "소수점은 입력할 수 없습니다.";
    public static final String ZERO_OR_NEGATIVE_VALUE = "0 또는 음수는 입력할 수 없습니다.";
    public static final String ZERO_START_VALUE = "시도 횟수는 0으로 시작할 수 없습니다.";

    private ErrorMessage() {
        throw new IllegalStateException("Error message cannot be instantiated");
    }
}