package com.sample.umar.leetcodemediums

fun main() {
    println(majorityNumber(listOf<Int>(1, 2, 3, 3, 3, 2, 3, 2, 3, 3, 3, 5, 6)))
}

fun majorityNumber(inputList: List<Int>): Int {
    // store the freq of numbers in a map
    val freqMap = mutableMapOf<Int, Int>()

    inputList.forEach {
        freqMap[it] = (freqMap[it] ?: 0) + 1
    }

    for (i in freqMap.keys) {
        val counter = freqMap[i]
        if (counter != null && counter > inputList.size / 2) {
            return i
        }
    }
    return 0
}

fun majorityElementMooreSolution(inputList: List<Int>): Int {
    var candidate = 0
    var count = 0
    for (num in inputList) {
        if (count == 0) {
            candidate = num
        }

        if (num == candidate) {
            count++
        } else {
            count--
        }
    }

    return candidate
}

/*
    .   When count hits 0, pick a new candidate
	•	Increase count when numbers match
	•	Decrease count when they differ
	•	Final candidate is majority element
	No maps, no sorting, no extra loops.
 */