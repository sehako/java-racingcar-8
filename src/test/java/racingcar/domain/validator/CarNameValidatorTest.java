package racingcar.domain.validator;

import static racingcar.io.ErrorMessage.CAR_NAME_LENGTH_OVER;
import static racingcar.io.ErrorMessage.EMPTY_CAR_LIST_INPUT;
import static racingcar.io.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.io.ErrorMessage.INVALID_CAR_NAME;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    @ParameterizedTest
    @DisplayName("사용자가 아무 입력도 하지 않으면 오류가 발생한다.")
    @ValueSource(strings = {"", " "})
    public void blankInputTest(String input) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> CarNameValidator.validateNotBlankInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_CAR_LIST_INPUT);
    }

    @Test
    @DisplayName("사용자가 자동차 이름을 길이 5 이하로 입력하면 오류가 발생하지 않는다.")
    public void validCarNameTest() {
        // given
        String carName = "sehak";
        // when
        // then
        Assertions.assertThatCode(() -> CarNameValidator.validate(carName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사용자가 자동차 이름을 입력하지 않으면 오류가 발생한다.")
    public void emptyCarNameTest() {
        // given
        String carName = "";

        // when
        // then
        testCarNameValidateExceptionThrown(carName, EMPTY_CAR_NAME);
    }

    @ParameterizedTest
    @DisplayName("사용자가 길이 5 이상의 자동차 이름을 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"sehako", "세학의자동차", "letsgo세학"})
    public void overLengthInputTest(String input) {
        // given
        // when
        // then
        testCarNameValidateExceptionThrown(input, CAR_NAME_LENGTH_OVER);
    }

    @ParameterizedTest
    @DisplayName("사용자가 영어와 완성형 한글을 제외한 다른 문자를 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"seha!", "hak0", "hakㅇㅗ", "ha.ko", "se ak"})
    public void inValidCarNameTest(String input) {
        // given
        // when
        // then
        testCarNameValidateExceptionThrown(input, INVALID_CAR_NAME);
    }

    private void testCarNameValidateExceptionThrown(String input, String message) {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}