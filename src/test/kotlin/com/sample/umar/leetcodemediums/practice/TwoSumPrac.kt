package com.sample.umar.leetcodemediums.practice

fun main() {
    println(twoSumIndices(listOf<Int>(1, 2, 4, 5, 2, 3, 8, 6), 7))
}

fun twoSumIndices(inputList: List<Int>, target: Int): Pair<Int, Int> {
    val lookUpMap: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

    inputList.forEachIndexed { index, value ->
        lookUpMap[value] = index
    }
    // Compute the complement
    for (i in 0 until inputList.size) {
        val complement = target - inputList[i]
        // Look up for the complement existence
        if (lookUpMap.contains(complement) && i != lookUpMap[complement]) {
            return Pair(i, lookUpMap[complement]!!)
        }
    }
    return Pair(0, 0)
}

/**
 * Algo:
 * 1. Declare an mutable map and store its key as input value and value as an index to that value
 * 2. Compute a complement as target - current value
 * 3. Loop up for that complement in the map and if present and the index is not the same as input list then return the index of it as well as the current value
 * 4. Put in a pair and return
 *
 * Complexity: o(n) for populating the map and o(1) for lookup
 *
 */