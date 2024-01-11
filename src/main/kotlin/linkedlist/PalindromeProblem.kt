package linkedlist

fun isPalindrome(head: ListNode?): Boolean {
        var current = head
        var count = 0

        while (current != null) {
            current = current.next
            count++
        }

        current = head
        var prev: ListNode? = null
        var currentElemNumber = 1
        while (current != null) {
            if (currentElemNumber <= count / 2) {
                val next = current.next
                current.next = prev
                prev = current
                current = next
            } else if (count % 2 == 1 && currentElemNumber == count / 2 + 1) {
                current = current.next
            } else {
                if (current.`val` != prev?.`val`) return false
                current = current.next
                prev = prev.next
            }
            currentElemNumber++
        }
        return true
}