package com.sample.umar.leetcodemediums

fun main() {
    println(moveZeros(listOf<Int>(1, 3, 4, 5, 6, 0, 1, 4, 0, 3, 2, 0, 9)))
}


fun moveZeros(inputList: List<Int>): List<Int> {
    // filter non zeros from the give list and move it to a result list
    val resultList = mutableListOf<Int>()
    val inputSize = inputList.size

    for (i in inputList.indices) {
        if (inputList[i] != 0) {
            resultList.add(inputList[i])
        }
    }

    println(resultList)

    // filtered and added all non-zero elements now get the difference in size
    val zeroSize = inputSize - resultList.size

    (0 until zeroSize).forEach { _ ->
        resultList.add(0)
    }

    return resultList
}