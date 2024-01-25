package linkedlist

fun buildList(vararg numbers: Int): ListNode? {
    if (numbers.isEmpty()) return null

    val head = ListNode(numbers[0])
    var prev = head
    for (i in 1..<numbers.size) {
        val node = ListNode(numbers[i])
        prev.next = node
        prev = node
    }

    return head
}
