package com.sample.umar.leetcodemediums

fun main() {
    println(rotateArray(mutableListOf<Int>(1, 2, 4, 3, 5, 6, 4, 8), 1))
}

// Given an array, rotate it to the right by k steps.
// Reverse method steps, since it is in-place and o(1) space and o(n) time
fun rotateArray(inputList: MutableList<Int>, step: Int): List<Int> {
    //normalise the k (reduces the number of rotations that produce same result)
    val k = step % inputList.size

    fun reverse(startIndex: Int, endIndex: Int) {
        var left = startIndex
        var right = endIndex
        //reverse is in-place
        while (left < right) {
            val temp = inputList[left]
            inputList[left] = inputList[right]
            inputList[right] = temp
            left++
            right--
        }
    }
    // Step 1: Reverse whole array
    reverse(0, inputList.size - 1)

    // Step 2: Reverse only the first k elements
    reverse(0, k - 1)

    // step 3: Reverse remaining elements
    reverse(k, inputList.size - 1)

    return inputList
}


/*
Algo:
1. Reverse whole array
2. Reverse first k elements
3. Reverse remaining elements
4. Use a inline fun to reverse(left, right) that use basic swap via temp variable with left < right
 */

