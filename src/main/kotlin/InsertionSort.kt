fun insertionsort(items: MutableList<Int>): List<Int>{
    for (i in 1 until items.size){
        val item = items[i]
        var j = i
        while (j > 0 && item < items[j - 1]){
            items[j] = items[j - 1]
            j -= 1
        }
        items[j] = item
        printElements(items)
    }
    return items
}

fun printElements(arr: List<Int>) {
    for (i in 0 until arr.size) {
        print(arr[i])
        print(" ")
    }
    println()
}

fun main(args: Array<String>) {
    val names = mutableListOf(1, 4, 3, 5, 6, 2)
    var ordered = insertionsort(names)
}