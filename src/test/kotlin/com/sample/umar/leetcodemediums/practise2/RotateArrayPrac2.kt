package com.sample.umar.leetcodemediums.practise2

fun main() {
    println(rotate(mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7), 1))
}


fun rotate(inputList: MutableList<Int>, step: Int): List<Int> {
    // normalise the step to reduce rotations
    val k = step % inputList.size

    fun reverse(startIndex: Int, endIndex: Int) {
        var left = startIndex
        var right = endIndex
        while (left < right) {
            // swap elements
            val temp = inputList[left]
            inputList[left] = inputList[right]
            inputList[right] = temp
            left++
            right--
        }
    }

    // Reverse whole list
    reverse(0, inputList.size - 1)

    // Reverse the list from 0 until k -1
    reverse(0, k - 1)

    // Reverse list from k until input size
    reverse(k, inputList.size - 1)

    return inputList
}

/**
 *
 */