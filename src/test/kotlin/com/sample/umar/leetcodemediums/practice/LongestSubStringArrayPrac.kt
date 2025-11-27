package com.sample.umar.leetcodemediums.practice

import kotlin.math.max

/**
 * Requirements:
 * 	•	Sliding window
 * 	•	Use a Set (O(1) lookup)
 * 	•	Expand window with end
 * 	•	Shrink window with start
 * 	•	Track max length
 * 	•	No duplicates allowed
 * 	•	Return the length (Int)
 */

/**
 * Algo:
 * Declare a variable as maxLength to 0 as fallback and start to 0
 * Loop through the given input string and use variables end and start (slide window) and move start ++ if char is already present in the set and remove else add it to the set
 * Finally once loop finished, calculate the max length of unique chars through end - start + 1 and return
 *
 * Complexity: o(n) for scanning and o(1) lookup space
 */

fun main() {
    println(maxLengthLongestSubString("pwwkew"))
}

fun maxLengthLongestSubString(inputString: String): Int {
    var maxLength = 0
    var start = 0
    val charSet = mutableSetOf<Char>()
    for (end in 0 until inputString.length) {
        while (charSet.contains(inputString[end])) {
            // remove the element at start
            charSet.remove(inputString[start])
            start++
        }
        charSet.add(inputString[end])
        maxLength = max(maxLength, end - start + 1)
    }
    return maxLength
}


