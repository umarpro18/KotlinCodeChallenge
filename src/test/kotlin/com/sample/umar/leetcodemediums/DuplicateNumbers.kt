package com.sample.umar.leetcodemediums

fun main() {
    println(findDuplicates(listOf<Int>(1, 2, 2, 3, 4, 2, 3, 6, 4, 7, 8, 3)))
}

// return the duplicate numbers
fun findDuplicates(inputList: List<Int>): List<Int> {
    // declare a map and use the input value to process and set the numbers freq
    val freqMap: MutableMap<Int, Int> = mutableMapOf<Int, Int>()
    val resultList: MutableList<Int> = mutableListOf()
    for (i in inputList) {
        freqMap[i] = (freqMap[i] ?: 0) + 1
    }

    freqMap.forEach { (value, count) ->
        if (count > 1) {
            resultList.add(value)
        }
    }
    return resultList
}

/*
also learn about how to add prefix values in existing list?
 */