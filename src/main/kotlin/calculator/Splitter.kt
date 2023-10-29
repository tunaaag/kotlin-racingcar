package calculator

class Splitter {
    fun split(input: String?, separator: String = " "): List<String> {
        return input?.split(separator) ?: throw IllegalArgumentException("입력값이 null 입니다.")
    }
}
