package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptParserTest {
    @Test
    @DisplayName("사용자가 올바른 시도 횟수를 입력하면 숫자로 변환한다.")
    public void attemptParserTest() {
        // given
        String attempt = "100";

        // when
        int result = AttemptParser.parse(attempt);

        // then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(attempt));
    }

    @ParameterizedTest
    @DisplayName("사용자가 1000 이상 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"2200000000", "101"})
    public void overIntegerTest(String number) {
        // given

        // when
        // then
        Assertions.assertThatThrownBy(() -> AttemptParser.parse(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}