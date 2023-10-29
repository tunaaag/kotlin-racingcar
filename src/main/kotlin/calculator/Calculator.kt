package calculator

class Calculator(
    private val splitter: Splitter = Splitter()
) {
    fun calculate(input: String?): String {
        val values = splitter.split(input)
        validate(values)
        val initial = values.first()
        var result = initial.toBigDecimalOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
        var operator: Operator? = null
        for (i in 1 until values.size) {
            val operand = values[i].toBigDecimalOrNull()
            operand?.let {
                result = operator?.operate(result, it) ?: throw IllegalArgumentException("연산자가 없습니다.")
            } ?: run {
                operator = Operator.of(values[i])
            }
        }
        return result.toString()
    }

    private fun validate(values: List<String>) {
        require(values.size > 2) { "인자가 3개 이상이어야 합니다." }
        require(values.all { it.isNotBlank() }) { "인자에 빈 공백 문자가 포함되어 있습니다." }
    }
}
