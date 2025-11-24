package com.sample.umar.leetcodemediums

fun main() {
    println(sortDuplicateNumbers(listOf(1, 2, 3, 4, 4, 5, 2, 7, 6, 3, 5)))
}


fun sortDuplicateNumbers(inputList: List<Int>): List<Int> {
    // Use a map to store the duplicates freq
    val mapFreq: MutableMap<Int, Int> = mutableMapOf()
    val resultList: MutableList<Int> = mutableListOf()

    inputList.forEach {
        mapFreq[it] = (mapFreq[it] ?: 0) + 1
    }
    // Sort the keys into a list using manual method
    //val sortedkeys = mapFreq.keys.sorted()
    val sortedKeys = sortKeys(mapFreq.keys.toMutableList())

    sortedKeys.forEach { key ->
        // add sorted list with duplicates
        val count = mapFreq[key]
        if (count != null) {
            repeat(count) {
                resultList.add(key)
            }
        }
    }
    return resultList
}

// Uses selection sort, and it is very expensive o(n2) for largen lists, sorted uses timsort algo which is o (n log n) and much quicker
fun sortKeys(inputList: MutableList<Int>): List<Int> {
    val sortedList = mutableListOf<Int>()
    while (inputList.isNotEmpty()) {
        var smallest = inputList[0]
        for (value in inputList) {
            if (value < smallest) {
                smallest = value
            }
        }
        sortedList.add(smallest)
        inputList.remove(smallest)
    }
    return sortedList
}