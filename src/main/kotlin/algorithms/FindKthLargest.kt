package algorithms

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

class Node(val value: Int) {
    var next: Node? = null
}

fun main() {
    //println(findKthLargest2(nums = intArrayOf(3,2,3,1,2,4,5,5,6), k = 4))
//    val test = PriorityQueue<Node> { n, n2 ->
//        n.value.compareTo(n2.value)
//    }
//    test.add(Node(5))
//    test.add(Node(20))
//    test.add(Node(4))
//    println(test.peek().value)
//    println(test.poll().value)
    println('0'.toInt())
}

fun myPow(x: Double, n: Int): Double {
    var res: Double = x

    for (i in 1 until abs(n)) {
        res = res * x
    }
    if (n < 0) {
        res = 1/res
    } else if (n == 0) {
        res = 1.0
    }
    return res
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val list = nums.toMutableList()
    for (i in 1 until k ) {
        val max = list.max()
        list.remove(max)
        println(list)
    }
    return list.max()
}

fun findKthLargest2(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()
    nums.forEach {
        minHeap.add(it)
        if (minHeap.size > k) minHeap.poll()
    }
    return minHeap.peek()
}

//fun insert(head: Node?, insertVal: Int): Node? {
//    if (head == null) {
//        val newList = Node(insertVal)
//        newList.next = newList
//        return newList
//    }
//    var current: Node = head
//    val previous = HashMap<Node, Node>()
//    previous[head.next!!] = head
//    var diff = 0
//    var closest = head.next
//    do {
//        if (current == closest) {
//            val newValue = Node(insertVal)
//            if (closest.`val` < insertVal){
//                newValue.next = closest.next
//                closest.next = newValue
//            } else {
//                val prev = previous[closest]
//                newValue.next = closest
//                prev?.next = newValue
//            }
//            return head
//        }
//        val newDiff = abs((current.`val`) - insertVal)
//        if (newDiff < diff) {
//            diff = newDiff
//            closest = current
//        }
//        previous[current.next!!] = current
//        current = current.next!!
//    } while(current.next !== null)
//    return head
//}


/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 * }
 */

//class Solution {
//    fun insert(head: Node?, insertVal: Int): Node? {
//        if (head == null) {
//            val newList = Node(insertVal)
//            newList.next = newList
//            return newList
//        }
//        var current: Node = head.next!!
//        val previous = HashMap<Node, Node>()
//        previous[head.next!!] = head
//        var diff = abs(head.`val` - insertVal)
//        var closest: Node = head
//        do {
//            val newDiff = abs(current.`val` - insertVal)
//            if (newDiff < diff || (newDiff == diff && current.`val` != head.`val`)) {
//                diff = newDiff
//                closest = current
//            }
//            previous[current.next!!] = current
//            current = current.next!!
//
//            if (current == head) {
//                val newValue = Node(insertVal)
//                if (closest.`val` < insertVal){
//                    newValue.next = closest.next
//                    closest.next = newValue
//                } else {
//                    val prev = previous[closest]
//                    newValue.next = closest
//                    prev?.next = newValue
//                }
//                return head
//            }
//        } while(current.next !== null)
//        return head
//    }
// }