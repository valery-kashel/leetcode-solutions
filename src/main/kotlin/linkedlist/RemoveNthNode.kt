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

    val newHead = removeNthFromEnd(node1, 6)
    println(newHead)
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null
        var skipTimes = n
        var size = 1

        var elementBeforeDelete = head
        var current = head
        while (current?.next != null) {
            if (skipTimes <= 0) {
                elementBeforeDelete = elementBeforeDelete?.next
            }
            current = current.next
            skipTimes--
            size++
        }
        return if (size == n) {
            head.next
        } else {
            elementBeforeDelete?.next = elementBeforeDelete?.next?.next
            head
        }
}