package study

import calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "1 + 2 + 3 = 6",
            "1 + 3 + 5 + 7 = 16",
        ],
        delimiter = '=',
    )
    fun `덧셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "10 - 5 - 3 = 2",
            "3 - 2 - 1 - 1 - 0 = -1",
        ],
        delimiter = '=',
    )
    fun `뺄셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "10 * 10 * 10 = 1000",
            "10 * 1 * 0 = 0",
            "10 * 1 * -1 = -10",
        ],
        delimiter = '=',
    )
    fun `곱셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "4 / 2 / 1 = 2",
            "1 / 10 = 0.1",
        ],
        delimiter = '=',
    )
    fun `나눗셈`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} = {1}")
    @NullAndEmptySource
    fun `입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?) {
        assertThrows<IllegalArgumentException>() {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "1 ! 1 = 연산자가 아닙니다.",
            "1 @ 1 = 연산자가 아닙니다.",
        ],
        delimiter = '=',
    )
    fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`(input: String, expected: String) {
        assertThrows<IllegalArgumentException>(message = expected) {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(
        value = [
            "5 + 4 - 3 * 2 / 1 = 12",
            "5 / 4 * 3 - 2 + 1 = 2.75",
        ],
        delimiter = '=',
    )
    fun `사칙연산을 모두 포함하는 기능 구현`(input: String, expected: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(expected)
    }
}
