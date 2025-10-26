package racingcar.domain.validator;

import static racingcar.io.ErrorMessage.DECIMAL_NUMBER;
import static racingcar.io.ErrorMessage.EMPTY_ATTEMPT_INPUT;
import static racingcar.io.ErrorMessage.NON_NUMERIC_VALUE;
import static racingcar.io.ErrorMessage.ZERO_OR_NEGATIVE_VALUE;
import static racingcar.io.ErrorMessage.ZERO_START_VALUE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptValidatorTest {
    @Test
    @DisplayName("사용자가 1 이상의 값을 입력하면 아무런 오류가 발생하지 않는다.")
    public void idealAttemptInputTest() {
        // given
        String attempt = "1";

        // when
        // then
        Assertions.assertThatCode(() -> AttemptValidator.validate(attempt))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("사용자가 아무런 입력이 없거나 공백을 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"", " "})
    public void blankInputTest(String input) {
        // given
        // when
        // then
        testAttemptValidateExceptionThrown(input, EMPTY_ATTEMPT_INPUT);
    }

    @Test
    @DisplayName("사용자가 숫자가 아닌 값을 입력하면 오류가 발생한다.")
    public void nonNumericInputTest() {
        // given
        String attempt = "a";

        // when
        // then
        testAttemptValidateExceptionThrown(attempt, NON_NUMERIC_VALUE);
    }

    @Test
    @DisplayName("사용자가 소수점을 입력하면 오류가 발생한다.")
    public void decimalInputTest() {
        // given
        String attempt = "1.1";

        // when
        // then
        testAttemptValidateExceptionThrown(attempt, DECIMAL_NUMBER);
    }

    @Test
    @DisplayName("사용자가 음수를 입력하면 오류가 발생한다.")
    public void negativeValueTest() {
        // given
        String attempt = "-1";

        // when
        // then
        testAttemptValidateExceptionThrown(attempt, ZERO_OR_NEGATIVE_VALUE);
    }

    @Test
    @DisplayName("0으로 시작하는 시도 횟수 입력에 대해서 오류가 밠갱한다.")
    public void zeroStartValueTest() {
        // given
        String attempt = "01";

        // when
        // then
        testAttemptValidateExceptionThrown(attempt, ZERO_START_VALUE);
    }

    private void testAttemptValidateExceptionThrown(String input, String message) {
        Assertions.assertThatThrownBy(() -> AttemptValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}