package com.sample.umar.leetcodemediums.practise2

/**
 * Given a string s, return the index of the first non-repeating character.
 * If it doesn’t exist, return -1.
 *
 * Algo:
 * Iterate the given string as char and use a map to save its freq
 * iterate the input string against the map and return the index of the first occurred unique value through if its freq is 1
 */


fun main() {
    println(firstUniqueChar("dssskd"))
}

fun firstUniqueChar(inputStr: String): Int {
    val freqMap = mutableMapOf<Char, Int>()

    // store char freq
    inputStr.forEach {
        freqMap[it] = (freqMap[it] ?: 0) + 1
    }

    // return the first unique char index
    for (i in 0 until inputStr.length) {
        if (freqMap[inputStr[i]] == 1) return i
    }

    return -1
}