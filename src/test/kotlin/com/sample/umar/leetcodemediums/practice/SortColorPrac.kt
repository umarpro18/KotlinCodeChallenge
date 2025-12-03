package com.sample.umar.leetcodemediums.practice


/**
 * Sort the array in-place so that all zeros come first,
 * then ones, then twos.
 *
 * ❗ Constraints:
 * 	•	You must not return a new array
 * 	•	You must sort in-place
 * 	•	Time complexity: O(n)
 * 	•	Space complexity: O(1)
 *
 *  Algo:
 *  Let's try two pointer slow write and fast scan technique,
 *  Declare slow as 0 and iterate the given list with fast
 *  if input[fast] == 0 then set input[slow] = input[fast] and increment slow ++ until we finish and this gives 0's in the first
 *  Now, do the same for and iterate the list again with fast
 *  if input[fast] == 1 then set input[slow] = input[fast] and increment slow ++ until we finish and this gives 1's in the second place
 *  Return fill the remaining with 2's and return
 *
 *  time: o(n) + o(n) + o(n) = o(n)
 *  space: o(1)
 */
fun main() {
    println(sortUsingCounter(mutableListOf(1, 0, 2, 1, 1, 1, 2, 0, 1, 0, 0, 1)))
}

fun sortColorInPlace(inputList: MutableList<Int>): List<Int> {
    var slow = 0

    //Pass 1: check for 0's and sort
    for (fast in 0 until inputList.size) {
        if (inputList[fast] == 0) {
            inputList[slow] = inputList[fast]
            slow++
        }
    }

    println(inputList)

    //Pass 2: check for 1's and sort
    for (fast in 0 until inputList.size) {
        if (inputList[fast] == 1) {
            inputList[slow] = inputList[fast]
            slow++
        }
    }

    println(inputList)

    // Now fill the remaining with 2's
    while (slow < inputList.size) {
        inputList[slow] = 2
        slow++
    }

    return inputList
}

// Will try counter stuffs
fun sortUsingCounter(inputList: MutableList<Int>): List<Int> {
    var counter0 = 0
    var counter1 = 0
    var counter2 = 0

    // Pass 1
    inputList.forEach {
        when (it) {
            0 -> {
                counter0++
            }

            1 -> {
                counter1++
            }

            2 -> {
                counter2++
            }
        }
    }
    println("counter -->$counter0--$counter1--$counter2")

    var index = 0
    // Pass 2 rewrite
    repeat(counter0) {
        inputList[index] = 0
        index += 1
        println(index)
    }

    repeat(counter1) {
        inputList[index++] = 1
        println(index)
    }

    repeat(counter2) {
        inputList[index++] = 2
        println(index)
    }
    println(index)
    return inputList
}
