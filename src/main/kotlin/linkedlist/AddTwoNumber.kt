package linkedlist

import java.math.BigInteger

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var number1 = ""
    var number2 = ""
    var current1 = l1
    var current2 = l2

    while (current1 != null) {
        number1 += current1.`val`.toString()
        current1 = current1.next
    }
    while (current2 != null) {
        number2 += current2.`val`.toString()
        current2 = current2.next
    }
    val resultNumber = (BigInteger(number1.reversed()) + BigInteger(number2.reversed())).toString().reversed()
    val newHead = ListNode(resultNumber.elementAt(0).digitToInt())
    var prevElement = newHead

    for (i in 1..<resultNumber.length) {
        val currentDigit = resultNumber.elementAt(i).digitToInt()
        val node = ListNode(currentDigit)
        prevElement.next = node
        prevElement = node
    }
    return newHead
}

fun main() {
    val head1 = buildList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
    val head2 = buildList(5, 6, 4)

    println(addTwoNumbers(head1, head2))
}