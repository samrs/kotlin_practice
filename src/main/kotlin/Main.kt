import kotlin.math.abs

fun main() {
    for (i in 0 .. 10) {
        println(i)
    }
}

fun getWays(n: Int, cs: Array<Int>): Long {
    // Write your code here
    val t = LongArray(n + 1)
    t[0] = 1
    for (c in cs) {
        for (i in c.toInt()..n) {
            t[i] += t[i - c.toInt()]
        }
    }
    return t[n]
}

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    // Write your code here
    val sockPairs = HashMap<Int, Int>()
    var result = 0
    ar.forEach {
        if (sockPairs.contains(it)) {
            sockPairs[it] = sockPairs[it]!! + 1
        } else {
            sockPairs[it] = 1
        }
    }

    sockPairs.forEach {
        if (it.value >= 2) {
            result += ((it.value - it.value % 2) / 2)
        }
    }

    return result
}