package racingcar.util.parser;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameParserTest {

    @Test
    @DisplayName("사용자가 자동차 이름 목록을 입력하면 쉽표 구분자를 기준으로 분리한다.")
    public void parseTest() {
        // given
        String carNames = "sehak,let,go";

        // when
        List<String> parsedName = CarNameParser.parse(carNames);

        // then
        Assertions.assertThat(parsedName)
                .containsExactly("sehak", "let", "go");
    }
}