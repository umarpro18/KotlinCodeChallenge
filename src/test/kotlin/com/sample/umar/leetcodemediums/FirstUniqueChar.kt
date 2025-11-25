package com.sample.umar.leetcodemediums

fun main() {
    println(firstUniqueChar("leetcode"))
}

// Return the first unique char index from the given string (two pass)
fun firstUniqueChar(inputStr: String): Int {
    // use a map to store the char freq
    val freqMap = mutableMapOf<Char, Int>()
    inputStr.forEach { char ->
        freqMap[char] = (freqMap[char] ?: 0) + 1
    }
    for (i in 0 until inputStr.length) {
        val count = freqMap[inputStr[i]]
        if (count == 1) return i
    }
    return -1
}