package com.sample.umar.leetcodemediums

fun main() {
    println(findMissingNumber(listOf<Int>(0)))
}

// Only one number will be missing and the input range is always n + 1 inclusive of 0
fun findMissingNumber(inputList: List<Int>): Int {
    // Let's use a set to store the numbers and lookup against the input list that will be o(1) for lookup
    val elementSet: MutableSet<Int> = mutableSetOf()

    inputList.forEach {
        elementSet.add(it)
    }

    for (i in 0..inputList.size) {
        if (!elementSet.contains(i)) return i
    }

    return 0
}