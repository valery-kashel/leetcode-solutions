package linkedlist

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

    fun flatten(root: Node?): Node? {
        var current = root
        while (current != null) {
            if (current.child == null) {
                current = current.next
            } else {
                val next = current.next
                val child = current.child!!
                val lastFromChild = getLastChildNode(child)
                current.next = child
                child.prev = current

                if (next != null) {
                    lastFromChild.next = next
                    next.prev = lastFromChild
                }

                current.child = null
                current = child
            }
        }
        return root
    }

    fun getLastChildNode(node: Node): Node {
        var current = node
        while (current.next != null) {
            current = current.next!!
        }
        return current
    }

fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
//    val node4 = Node(4)
//    val node5 = Node(5)
//    val node6 = Node(6)
//
//    val node7 = Node(7)
//    val node8 = Node(8)
//    val node9 = Node(9)
//    val node10 = Node(10)
//
//    val node11 = Node(11)
//    val node12 = Node(12)

//    node1.next = node2
//
//    node2.prev = node1
//    node2.next = node3
//
//    node3.prev = node2
//    node3.next = node4
//
//    node4.prev = node3
//    node4.next = node5
//
//    node5.prev = node4
//    node5.next = node6
//
//    node7.next = node8
//
//    node8.prev = node7
//    node8.next = node9
//
//    node9.prev = node8
//    node9.next = node10
//
//    node11.next = node12
//
//    node12.prev = node11
//
//    node3.child = node7
//
//    node8.child = node11

    node1.next = node2
    node2.prev = node1

    node1.child = node3

    val newHead = flatten(node1)
    val resultString = StringBuilder()
    var current = newHead
    while (current != null){
        resultString.append("${current.`val`}")
        if (current.next != null) resultString.append(" -> ")
        current = current.next
    }

    println(resultString.toString())
}
