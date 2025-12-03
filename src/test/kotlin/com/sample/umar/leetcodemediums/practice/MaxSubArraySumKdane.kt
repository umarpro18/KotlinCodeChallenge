package com.sample.umar.leetcodemediums.practice

import kotlin.math.max

fun main() {
    println(maxSubArraySumKadane(listOf(-1, 0, 2, 3, 4, -2, 4, 7, -9)))
}


/**
 * Iterate the given input list and find the max sum of subarray
 * Declare two vars called currentsum and maxsum and access the first element
 * Decide to start a new subarray sum or extend the summation through finding its max
 */

fun maxSubArraySumKadane(inputList: List<Int>): Int {
    var currentMax = inputList[0]
    var maxSum = inputList[0]

    for (i in 1 until inputList.size) {
        currentMax = max(inputList[i], inputList[i] + currentMax)
        maxSum = max(maxSum, currentMax)
    }
    return maxSum
}