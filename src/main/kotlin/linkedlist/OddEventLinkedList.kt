package linkedlist

fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null

        var lastOdd: ListNode? = head
        var current: ListNode? = head.next
        val firstEven = current
        var counter = 1

        while (current?.next != null) {
            if (counter % 2 == 1) {
                val next = current.next
                val nextNext = next?.next
                lastOdd?.next = next
                next?.next = firstEven
                current.next = nextNext
                lastOdd = next
            } else {
                current = current.next
            }
            counter++
        }

        return head
}