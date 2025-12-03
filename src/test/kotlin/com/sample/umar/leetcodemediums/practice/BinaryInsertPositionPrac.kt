package com.sample.umar.leetcodemediums.practice

/**
 * Given a sorted list of integers and a target value, return the index where the target should be inserted.
 * Requirements:
 * 	•	Use binary search
 * 	•	O(log n) time (Anything we divide)
 * 	•	O(1) space
 * 	•	If target exists → return its index
 * 	•	If not → return the index where it should be inserted
 * 	•	Do NOT scan linearly (O(n))
 * 	•	Do NOT sort the array — it is already sorted
 * Time: o(log n) and space: o(1)
 */

fun main() {
    print(insertPositionIndex(listOf<Int>(1, 2, 3, 6, 7, 8, 9), 5))
}

fun insertPositionIndex(inputList: List<Int>, target: Int): Int {
    // Use binary search technique o(log n) divide and search
    var left = 0
    var right = inputList.size - 1

    while (left <= right) {
        val mid = (left + right) / 2
        if (target == inputList[mid]) return mid
        if (target < inputList[mid]) right = mid - 1
        if (target > inputList[mid]) left = mid + 1
    }
    return left
}