package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    @DisplayName("자동차는 앞으로 전진할 수 있다.")
    public void racingCarMovingForwardTest() {
        // given
        RacingCar racingCar = new RacingCar("sehak");

        // when
        racingCar.moveForward();

        // then
        Assertions.assertThat(racingCar.getProgress()).isEqualTo("-");
    }

}