package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTypeTest {

    private static Stream<Arguments> provideMoveValueAndBridgeType() {
        return Stream.of(Arguments.of(-1, BridgeType.LEFT),
                Arguments.of(1, BridgeType.RIGHT),
                Arguments.of(0, BridgeType.NONE));
    }

    @DisplayName("없는 값으로 BridgeType을 찾으면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void findTypeThrowException(int moveValue) {
        assertThatThrownBy(() -> BridgeType.findByMoveValue(moveValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하였습니다. - " + moveValue);
    }

    @DisplayName("int 값으로 맞는 BridgeType을 가져온다.")
    @ParameterizedTest
    @MethodSource("provideMoveValueAndBridgeType")
    void findType(int moveValue, BridgeType bridgeType) {
        assertThat(BridgeType.findByMoveValue(moveValue)).isEqualTo(bridgeType);
    }
}