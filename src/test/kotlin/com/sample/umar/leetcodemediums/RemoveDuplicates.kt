package com.sample.umar.leetcodemediums

fun main() {
    println(removeDuplicates(mutableListOf<Int>(0, 1, 2, 3, 3, 4, 5, 6, 6, 6, 7, 8)))
}

/*
    .  Return the count of unique elements in a sorted array
	•	slow → points to where next unique value should be written
	•	fast → scans the full list
	->  space and time is o(1) and o(n)
 */
// Use two pointer solution to deal in same array (in-place modification)
fun removeDuplicates(inputList: MutableList<Int>): Int {
    var slow = 0
    for (fast in 0 until inputList.size) {
        if (inputList[fast] != inputList[slow]) {
            slow++
            inputList[slow] = inputList[fast]
        }
    }
    return slow + 1
}

