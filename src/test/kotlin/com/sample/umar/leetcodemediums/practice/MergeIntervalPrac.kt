package com.sample.umar.leetcodemediums.practice

/**
 * Given: When two intervals overlap, you should merge them into ONE interval.
 * [[1,3], [2,6], [8,10], [15,18]] -> [[1,6], [8,10], [15,18]]
 *
 * Complexity: Time o(n log n) and space O(n)
 *
 * Algo:
 * 1. Sort intervals by start.
 * 2. Scan left to right and merge whenever current.start <= last.end.
 * 3. If no overlap, append as new interval.
 * 4. Return merged list.
 */


fun main() {
    val inputList: MutableList<MutableList<Int>> =
        mutableListOf(mutableListOf<Int>(1, 3), mutableListOf<Int>(8, 10), mutableListOf<Int>(2, 6))
    println(mergeInterval(inputList))
}

fun mergeInterval(inputList: MutableList<MutableList<Int>>): List<List<Int>> {
    // Step 1: Sort intervals by start time
    val sortedList = inputList.sortedBy { it[0] }

    val resultList = mutableListOf<MutableList<Int>>()

    for (interval in sortedList) {
        // Let interval = [start, end]
        val currentStart = interval[0]
        val currentEnd = interval[1]
        // If result is empty OR current interval starts after last merged interval ends
        if (resultList.isEmpty() || currentStart > resultList.last()[1]) {
            // --------- NO OVERLAP ---------
            // Safe to add new interval
            resultList.add(interval)

        } else {
            // --------- OVERLAP ---------
            // Merge current interval with the last one in the result
            val lastMerged = resultList.last()
            lastMerged[1] = maxOf(lastMerged[1], currentEnd)
        }
    }

    return resultList
}

/**
 * For each interval:
 *    If result is empty → add it
 *    Else:
 *       If no overlap → add it
 *       If overlap → merge by extending end
 */