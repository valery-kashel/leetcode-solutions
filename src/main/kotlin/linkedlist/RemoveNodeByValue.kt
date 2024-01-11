package linkedlist

fun main() {
    val node1 = ListNode(5)
    val node2 = ListNode(5)
    val node3 = ListNode(5)
    val node4 = ListNode(2)
    val node5 = ListNode(5)
    val node6 = ListNode(5)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val newHead = remove(node1, 5)
    println(newHead)
}

fun remove(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        var newHead = head
        var prev: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            if (current == newHead && current.`val` == `val`) {
                newHead = current.next
                prev = current
            } else if (current.`val` == `val`) {
                prev?.next = current.next
            } else {
                prev = current
            }

            current = current.next
        }
        return newHead
}