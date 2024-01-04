package linkedlist

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val newHead = reverse(node1)
    println(newHead)
}

fun reverse(head: ListNode?): ListNode? {
    var fast = head
    var slow: ListNode? = null
    while (fast != null) {
        val next = fast.next
        fast.next = slow
        slow = fast
        fast = next
    }

    return slow
}