package com.sample.umar.leetcodemediums

import kotlin.math.max

fun main() {
    println(maxSubArraySum(listOf<Int>(-1, 0, 1, 2, 3, -2, 1, 4, 5)))
}

fun maxSubArraySum(inputList: List<Int>): Int {
    var currentSum = inputList[0]
    var maxSum = inputList[0]

    // Should I start a new subarray from this number?
    // Or should I extend the previous running sum?
    // update the maxSum to keep a track and return
    for (i in 1..inputList.size - 1) {
        currentSum = max(inputList[i], inputList[i] + currentSum)
        maxSum = max(maxSum, currentSum)
    }
    return maxSum
}