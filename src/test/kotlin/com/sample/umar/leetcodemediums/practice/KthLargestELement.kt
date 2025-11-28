package com.sample.umar.leetcodemediums.practice

/**
 * Given an unsorted list of integers, return the k-th largest element.
 * 	•	Sort descending
 * 	•	Return element at index (k-1)
 */

fun main() {
    println(findKthLargest(mutableListOf<Int>(2, 1, 3, 2, 3, 6, 4, 8, 9), 7))
}

fun findKthLargest(inputList: MutableList<Int>, k: Int): Int {
    // sort the given list in the descending order
    // lets sort in-place
    for (i in 0 until inputList.size) {
        var maxIndex = i
        for (j in i + 1 until inputList.size) {
            if (inputList[j] > inputList[maxIndex]) {
                maxIndex = j
            }
        }
        val temp = inputList[i]
        inputList[i] = inputList[maxIndex]
        inputList[maxIndex] = temp
    }

    // return the k th largest from the sorted list
    return inputList[k - 1]
}