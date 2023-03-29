package offer

fun main() {
    val s = "-1.05E-16"
    println(isNumber(s))
}
// 思路：有限状态机 根据遍历完字符串后状态机所处状态是否合法以判断该字符串是否表示数字。
fun isNumber(s: String): Boolean = Context(input = s.trim()).run()

// 状态机中每一状态及其转移策略，对当前每个字符，都对应于一个状态
enum class State {
    INITIALIZED, // 初始状态
    DECIMAL_SIGN, // 符号位
    INTEGER, // 整数部分
    INT_DOT, // 小数点且左边有数字
    NO_INT_DOT, // 小数点且小数点左边无数字
    FRACTION, // 小数部分
    EXP, // 指数标识符 E e
    EXP_SIGN, // 指数部分符号位
    EXP_NUMBER, // 指数部分数字（根据规定，只能是整数
    ERROR;

    // 根据前一状态this和当前字符char，转移至下一状态（作为返回值返回）。
    fun handle(char: Char): State = getNextState(this, char)

    companion object {
        private val nextReachable = mapOf(
            INITIALIZED to mapOf(
                '0' to INTEGER,
                '.' to NO_INT_DOT,
                's' to DECIMAL_SIGN,
            ),
            DECIMAL_SIGN to mapOf(
                '0' to INTEGER,
                '.' to NO_INT_DOT
            ),
            INTEGER to mapOf(
                '0' to INTEGER,
                '.' to INT_DOT,
                'e' to EXP
            ),
            INT_DOT to mapOf(
                '0' to FRACTION,
                'e' to EXP
            ),
            NO_INT_DOT to mapOf(
                '0' to FRACTION
            ),
            FRACTION to mapOf(
                '0' to FRACTION,
                'e' to EXP
            ),
            EXP to mapOf(
                's' to EXP_SIGN,
                '0' to EXP_NUMBER
            ),
            EXP_SIGN to mapOf(
                '0' to EXP_NUMBER
            ),
            EXP_NUMBER to mapOf(
                '0' to EXP_NUMBER
            )
        )

        private fun getCharType(char: Char): Char {
            val exp = arrayOf('e', 'E')
            val sign = arrayOf('+', '-')
            return when {
                char.isDigit() -> '0'
                char in exp -> 'e'
                char in sign -> 's'
                char == '.' -> '.'
                else -> '?'
            }
        }

        fun getNextState(state: State, char: Char) = nextReachable[state]?.get(getCharType(char))?:ERROR
    }
}

class Context(
    var state: State = State.INITIALIZED,
    val input: String
) {
    fun run(): Boolean {
        for (c in input) {
            state = state.handle(c)
            if (state == State.ERROR) return false // 不合法，提前结束
        }
        // 结束时的合法状态只有INTEGER(e.g.-123), INT_DOT(e.g.100.), FRACTION(e.g. .2), EXP_NUMBER(e.g. 5e2)可以转到结束状态
        return state in arrayOf(State.INTEGER, State.INT_DOT, State.FRACTION, State.EXP_NUMBER)
    }
}