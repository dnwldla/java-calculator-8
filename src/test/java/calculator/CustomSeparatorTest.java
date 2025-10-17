package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CustomSeparatorTest {

    Separator separator;

    @Test
    void inputWithDelimiters() {
        separator = new CustomSeparator("//!!\\n1!2");

        assertThatThrownBy(() -> separator.buildNumbers())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("단일 구분자이어야 합니다");

    }

    @Test
    void inputWithBasicDelimiter() {
        separator = new CustomSeparator("//:\\n132");

        assertThatThrownBy(() -> separator.buildNumbers())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구분자는 : 또는 , 일수 없습니다");
    }

    @Test
    void inputWithNumberDelimiter() {
        separator = new CustomSeparator("//3\\n132");

        assertThatThrownBy(() -> separator.buildNumbers())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("구분자는 숫자일 수 없습니다");
    }

    @Test
    void inputWithInvalidDelimiter() {
        separator = new CustomSeparator("//!\\n1!3&2");

        assertThatThrownBy(() -> separator.buildNumbers())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 형태가 올바르지 않습니다");
    }

}
