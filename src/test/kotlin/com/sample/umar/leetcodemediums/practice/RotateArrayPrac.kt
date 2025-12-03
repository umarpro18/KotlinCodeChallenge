package com.sample.umar.leetcodemediums.practice

/**
 * Algo:
 * 1. Find a normalized k from the step via getting step % input array size (this will reduce number of rotations which produce same result)
 * 2. Use two pointer logic with start and end-1 and while start less than end swap the elements in same array
 * 3. Repeat the above step for three scenarios (1. full array input size, 2. for k elements and 3. form k to remaining elements)
 * 4. return the updated array
 *
 * Complexity: Time o(n) three linear iterations on n and space o(1)
 */

fun main() {
    println(rotateArray(mutableListOf<Int>(1, 2, 3, 5, 6, 7, 8, 2, 3, 4), 1))
}

fun rotateArray(inputList: MutableList<Int>, step: Int): List<Int> {
    // Find normalized k for reduced rotations
    val k = step % inputList.size

    fun localReverse(start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val temp = inputList[i]
            inputList[i] = inputList[j]
            inputList[j] = temp
            i++
            j--
        }
    }
    // full reverse
    localReverse(0, inputList.size - 1)

    // up to kth element
    localReverse(0, k - 1)

    // remaining from k
    localReverse(k, inputList.size - 1)

    return inputList
}