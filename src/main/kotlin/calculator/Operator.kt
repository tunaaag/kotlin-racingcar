package calculator

import java.math.BigDecimal

enum class Operator(
    val symbol: String,
    private val operation: (BigDecimal, BigDecimal) -> BigDecimal,
) {
    PLUS("+", { left, right -> left.plus(right) }),
    MINUS("-", { left, right -> left.minus(right) }),
    MULTIPLY("*", { left, right -> left.multiply(right) }),
    DIVIDE("/", { left, right -> left.divide(right) }),
    ;

    fun operate(left: BigDecimal, right: BigDecimal): BigDecimal {
        return operation(left, right)
    }

    companion object {
        fun of(symbol: String): Operator = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("연산자가 아닙니다.")
    }
}
