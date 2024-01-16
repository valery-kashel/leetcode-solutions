package arrays

fun removeDuplicatesFromSortedArray(nums: IntArray): Int {
        var prevNumber = Int.MIN_VALUE
        var amountOfCurrentNum = 0
        var indexToInsert = 0
        for (i in nums.indices) {
            val current = nums[i]
            val needToInsert = indexToInsert < i
            if (prevNumber != current) {
                prevNumber = current
                amountOfCurrentNum = 1
            } else {
                amountOfCurrentNum++
            }

            if (needToInsert) {
                nums[indexToInsert] = current
            }
            if (amountOfCurrentNum <= 2) {
                indexToInsert++
            }
        }
        return indexToInsert
}

fun main() {
    val array = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    val newLength = removeDuplicatesFromSortedArray(array)
    println(array.joinToString())
    println(newLength)
}