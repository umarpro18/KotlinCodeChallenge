package com.sample.umar.leetcodemediums

fun main() {
    println(twoSumIndices(listOf<Int>(1, 2, 4, 3, 6, 8), 6))
}

fun twoSumIndices(inputList: List<Int>, targetValue: Int): Pair<Int, Int> {
    // Declare a map and store the value as key and its index as value because we need to return index as results
    val indicesMap = mutableMapOf<Int, Int>()
    inputList.forEachIndexed { index, value ->
        indicesMap[value] = index
    }
    println(indicesMap)

    // Find complement which is target - current list value once the complement is identified then return the index of both map and input list
    for (i in inputList.indices) {
        val complement = targetValue - inputList[i]
        if (indicesMap.containsKey(complement) && i != indicesMap[complement]) {
            return Pair(i, indicesMap[complement]!!)
        }
    }
    return Pair(0, 0)
}

// A lookup in map or set is always o(1) worst case is o(n)
// list is o(n) and with nested loop it will be o(n2) but lookup through index is o(1)