package com.sample.umar.leetcodemediums

fun main() {
    println(sortColors(listOf<Int>(1, 2, 0, 0, 2, 1, 0, 1, 2, 0)))
}

fun sortColors(inputList: List<Int>): List<Int> {
    // Two pass approach, use counter variable for each digit since the input is only 0, 1, and 2
    var count0 = 0
    var count1 = 0
    var count2 = 0

    inputList.forEach {
        when (it) {
            0 -> count0++
            1 -> count1++
            2 -> count2++
        }
    }

    // overwrite the input list save space o(1)
    val resultList = inputList.toMutableList()
    var index = 0
    for(i in 0 until count0) { resultList[index++] = 0 }
    for(i in 0 until count1) { resultList[index++] = 1 }
    for(i in 0 until count2) { resultList[index++] = 2 }

    return resultList
}