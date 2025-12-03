package com.sample.umar.leetcodemediums.practice

/**
 * Remove Duplicates from Sorted Array — Version A
 * Goal:
 * 	•	Modify the array in-place
 * 	•	Keep only one copy of each distinct value
 * 	•	Return the number of unique elements
 *
 * Example:
 * [1,1,2,2,2,3] → unique = [1,2,3]
 * Return 3
 *
 */

// Use Slow writing and fast scanning approaching

fun main() {
    println(removeDuplicates(mutableListOf<Int>(1, 1, 2, 2, 2, 3)))
}

fun removeDuplicates(inputList: MutableList<Int>): Int {
    // slow pointer to write and fast pointer to scan the input
    var slow = 0
    for (fast in 0 until inputList.size) {
        if (inputList[fast] != inputList[slow]) {
            slow++
            inputList[slow] = inputList[fast]
        }
    }
    return slow + 1
}