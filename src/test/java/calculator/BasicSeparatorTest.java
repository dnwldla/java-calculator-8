package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BasicSeparatorTest {

    private Separator separator;

    @Test
    void inputWithInvalidDelimiter() {
        separator = new BasicSeparator("1!2");

        assertThatThrownBy(() -> separator.buildNumbers())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 형태가 올바르지 않습니다");
    }

    @Test
    void inputWithZero() {
        separator = new BasicSeparator("1,0");

        assertThatThrownBy(() -> separator.buildNumbers())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 이상의 숫자를 입력해야 합니다");

    }

}
