package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptParserTest {
    @Test
    @DisplayName("사용자가 올바른 시도 횟수를 입력하면 숫자로 변환한다.")
    public void attemptParserTest() {
        // given
        String attempt = "1000";

        // when
        int result = AttemptParser.parse(attempt);

        // then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(attempt));
    }

}