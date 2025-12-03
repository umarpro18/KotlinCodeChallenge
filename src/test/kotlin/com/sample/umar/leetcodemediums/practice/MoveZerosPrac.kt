package com.sample.umar.leetcodemediums.practice

//Return the array with all zeros moved to the end, maintaining the order of other elements.
/*
  Algorithm/Steps:
    1. We can use a two pass approach
    2. First pass o(n): Scan the input array and store non-zero elements in a result list
    3. Calculate the zero's size from total size of input array - non zero result list
    4. Append/add the zeros based on the zero's size to the result list and return

    Time = O(n)
    Space = O(n)

    // Use in-place method with a slow and fast pointer. o(1) space
    1. slow pointer to index/put the nonzero value
    2. fast to scan the input list
    3. Finally, move the zeros to the last by using slow value and check against the inputList.size
 */


fun main() {
    println(moveZeroInPlace(mutableListOf<Int>(0, 0, 2, 3, 1, 4, 5, 6, 7, 9, 8, 0, 3)))
}

// Two pass approach
fun moveZeros(inputList: List<Int>): List<Int> {
    val resultList = mutableListOf<Int>()

    for (value in inputList) {
        if (value != 0) resultList.add(value)
    }
    val nonZeroSize = inputList.size - resultList.size
    repeat(nonZeroSize) {
        resultList.add(0)
    }
    return resultList
}

//in-place approach
fun moveZeroInPlace(inputList: MutableList<Int>): List<Int> {
    // slow pointer to index/put the nonzero value
    var slow = 0
    for (fast in 0 until inputList.size) {
        if (inputList[fast] != 0) {
            inputList[slow] = inputList[fast]
            slow++
        }
    }

    // New move the zeroes to the right
    while (slow < inputList.size) {
        inputList[slow] = 0
        slow++
    }
    return inputList
}

/*
I used a slow pointer to collect all non-zero elements in the front while preserving order,
then filled the rest with zeros.
This yields O(n) time and O(1) space.
 */


