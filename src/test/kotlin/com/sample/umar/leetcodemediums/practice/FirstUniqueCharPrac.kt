package com.sample.umar.leetcodemediums.practice

/**
 * Requirements:
 * 	•	Given a string, return the index of the first non-repeating character.
 * 	•	If none exist, return -1.
 * 	•	Use two-pass:
 * 	•	1st pass: count frequencies using a MutableMap<Char, Int>
 * 	•	2nd pass: find the first index with count == 1 by iterating the input string by its index and lookup map
 * 	•	Time: O(n)
 * 	•	Space: O(1) (because only 26 lowercase chars / constant)
 */

fun main() {
    println(firstUniqueCharIndex("sggvausbds"))
}

fun firstUniqueCharIndex(inputStr: String): Int {
    val freqMap = mutableMapOf<Char, Int>()

    for (i in 0 until inputStr.length) {
        val value = inputStr[i]
        freqMap[value] = (freqMap[value] ?: 0) + 1
    }

    for (i in 0 until inputStr.length) {
        if (freqMap[inputStr[i]] == 1) return i
    }
    return -1
}