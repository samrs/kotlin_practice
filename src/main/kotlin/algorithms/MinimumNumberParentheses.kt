package algorithms

/*
Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */

fun main() {
    println(minRemoveToMakeValid("lee(t(c)o)de)"))
}

fun minRemoveToMakeValid(s: String): String {
    val queue = ArrayList<Char>()
    var newString = ""

    s.forEachIndexed { index, value ->
        when(value) {
            '(' -> {
                queue.add(')')
                newString += value
            }
            ')' -> {
                if (queue.getOrNull(0) == value) {
                    queue.removeAt(0)
                    newString += value
                }
            }
            else -> {
                newString += value
            }
        }
    }

    var result = ""
    if (queue.isNotEmpty()) {
        queue.clear()
        for (i in newString.length-1 downTo 0) {
            val value = newString[i]
            when(value) {
                ')' -> {
                    queue.add('(')
                    result += value
                }
                '(' -> {
                    if (queue.getOrNull(0) == value) {
                        queue.removeAt(0)
                        result += value
                    }
                }
                else -> {
                    result += value
                }
            }
        }
    } else {
        result = newString
    }

    return result.reversed()
}