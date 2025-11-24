package com.sample.umar.leetcodemediums

import java.lang.Integer.max

fun main() {
    println(longestSubString("abcghsccdef"))
}

fun longestSubString(inputStr: String): Int {
    var maxLength = 0
    val setChars = mutableSetOf<Char>()
    var start = 0

    for(end in inputStr.indices) {
        val currentChar = inputStr[end]
        // use while, not if, because the window may contain multiple copies of the same chars 'bbb'
        while (setChars.contains(currentChar)) {
            setChars.remove(inputStr[start])
            start ++
        }
        setChars.add(currentChar)
        maxLength = max(maxLength, end - start + 1)
    }

    return maxLength
}

/**
 * for (end in s.indices) {
 *     while (duplicate) shrink from left
 *     add char at end
 *     update max (maxLength, end-start + 1)
 * }
 *
 * O(n) due to sign operation of add or remove and o(1) for space due to unique chars
 */