package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarFactoryTest {
    @Test
    @DisplayName("사용자가 정확한 자동차 이름들을 입력하면 경주용 자동차가 배치된다.")
    public void racingCarMakingTest() {
        // given
        String carNames = "sehak,let";

        // when
        List<RacingCar> racingCars = RacingCarFactory.racingCars(carNames);

        // then
        Assertions.assertThat(racingCars).hasSize(2)
                .extracting("name", "progress")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("sehak", ""),
                        Tuple.tuple("let", "")
                );
    }

}