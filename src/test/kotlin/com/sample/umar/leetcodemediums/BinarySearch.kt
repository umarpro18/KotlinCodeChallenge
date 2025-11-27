package com.sample.umar.leetcodemediums

fun main() {
    println(binarySearch(listOf<Int>(1, 3, 4, 5, 6, 7, 2), 6))
}

fun binarySearch(inputList: List<Int>, target: Int): Int {
    var left = 0
    var right = inputList.size - 1

    while (left <= right) {
        //compute mid
        val mid = (left + right) / 2
        if (target == inputList[mid]) return mid
        if (target < inputList[mid]) right = mid - 1
        if (target > inputList[mid]) left = mid + 1
    }
    return left
}