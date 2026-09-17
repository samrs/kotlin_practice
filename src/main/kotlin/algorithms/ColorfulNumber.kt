package algorithms

fun main() {
    println(isColorfulNumber(3245))
}

fun isColorfulNumber(number: Int): Boolean {
    val products = HashSet<Int>()
    val numberSize = number.toString().length
    for (i in 1 until numberSize) {
        for (j in 0..numberSize - i) {
            val subString = number.toString().substring(j, j+i)
            val product = getProduct(subString)
            if (products.contains(product)) {
                return false
            } else {
                products.add(product)
            }
        }
    }
    return true
}

fun getProduct(number: String): Int {
    var product = 1
    number.forEach {
        product *= it.digitToInt()
    }
    return product
}