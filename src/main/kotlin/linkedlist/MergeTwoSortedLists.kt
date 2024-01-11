package linkedlist

fun mergeTwoSortedLists(list1: ListNode?, list2: ListNode?): ListNode? {
    list1 ?: return list2
    list2 ?: return list1

    var currentElem1: ListNode? = list1
    var currentElem2: ListNode? = list2

    var result: ListNode? = null
    var currentResultElem: ListNode? = null

    while (currentElem1 != null && currentElem2 != null) {
        val smallerVal = if (currentElem1.`val` < currentElem2.`val`) {
            currentElem1.`val`.also {
                currentElem1 = currentElem1?.next
            }
        } else {
            currentElem2.`val`.also {
                currentElem2 = currentElem2?.next
            }
        }

        val newNode = ListNode(smallerVal)
        if (result == null) {
            result = newNode
            currentResultElem = result
        } else {
            currentResultElem?.next = newNode
            currentResultElem = newNode
        }
    }

    currentResultElem?.next = currentElem1 ?: currentElem2

    return result
}

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(4)
    val node3 = ListNode(5)

    val node4 = ListNode(2)
    val node5 = ListNode(3)
    val node6 = ListNode(6)
    val node7 = ListNode(7)

    node1.next = node2
    node2.next = node3

    node4.next = node5
    node5.next = node6
    node6.next = node7

    println(mergeTwoSortedLists(node1, node4))
    println(mergeTwoSortedLists(null, node4))
    println(mergeTwoSortedLists(node1, null))
}