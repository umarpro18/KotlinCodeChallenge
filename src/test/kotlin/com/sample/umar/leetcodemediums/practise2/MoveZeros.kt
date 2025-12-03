package com.sample.umar.leetcodemediums.practise2

/**
 * Given an array of integers, move all zeros to the end while keeping the relative order of non-zero elements, and do it in-place.
 * Algo:
 * Use two pointer slow write and fast scan approach
 * iterate the given list via fast pointer, check if the value is non-zero and write the value via slow pointer
 * Now, refill the zero's for the remaining positions and return
 *
 */

fun main() {
    println(moveZeros(mutableListOf<Int>(0, 1, 2, 30, 0, 5, 70, 7)))
}

fun moveZeros(inputList: MutableList<Int>): List<Int> {
    // two pointer slow and fast
    var slow = 0

    for (fast in 0 until inputList.size) {
        if (inputList[fast] != 0) {
            inputList[slow] = inputList[fast]
            slow++
        }
    }

    // refill the zero's
    while (slow < inputList.size) {
        inputList[slow] = 0
        slow++
    }

    return inputList
}