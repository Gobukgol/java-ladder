package laddergame.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("실행 결과가 Null 또는 공백이면 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    void validateResult(String resultName) {
        assertThatThrownBy(() -> new Result(resultName, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 Null 또는 공백일 수 없습니다.");
    }
}