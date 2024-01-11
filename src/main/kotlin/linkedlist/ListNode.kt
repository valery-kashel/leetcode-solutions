package linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        var current: ListNode? = this
        val result = StringBuilder()
        while (current != null) {
            result.append("${current.`val`}")
            if (current.next != null) {
                result.append(" -> ")
            }
            current = current.next
        }
        return result.toString()
    }
}