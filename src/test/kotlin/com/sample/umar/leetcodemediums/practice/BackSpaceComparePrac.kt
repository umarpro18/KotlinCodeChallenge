package com.sample.umar.leetcodemediums.practice

/**
 * Given two strings s and t, return true if they are equal when both are typed into a text editor.
 * means a backspace.
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Rules:
 * 	•	Process both strings from right to left
 * 	•	Use two pointers i and j
 * 	•	Use skip counters skip1 and skip2
 * 	•	Skip characters affected by ‘#’
 * 	•	Compare the final valid characters
 * 	•	If mismatch → return false
 * 	•	If both end together with no mismatch → return true
 *
 * 	Time: o(n) and space: o(1)
 */

fun main() {
    println(backSpaceCompare("y#fo##f", "y#f#o##f"))
}

fun backSpaceCompare(str1: String, str2: String): Boolean {
    // Pick the last index of both the strings and compare while skipping the char when # appear, two pointer approach
    var i = str1.length - 1
    var j = str2.length - 1

    // Use two skip counters
    var skipI = 0
    var skipJ = 0

    while (i >= 0 || j >= 0) {
        // Process str1
        while (i >= 0) {
            if (str1[i] == '#') {
                i--
                skipI++
            } else if (skipI > 0) {
                i--
                skipI--
            } else {
                break
            }
        }

        // Process str2
        while (j >= 0) {
            if (str2[j] == '#') {
                j--
                skipJ++
            } else if (skipJ > 0) {
                j--
                skipJ--
            } else {
                break
            }
        }

        // Check for conditions and return
        if (i >= 0 && j >= 0 && str1[i] != str2[j]) {
            return false
        } else if ((i >= 0) != (j >= 0)) {
            return false
        } else {
            i--
            j--
        }
    }
    // all the strings processed
    return true
}

/* Algo:
    1. Move i left until:
	    • You skip all #
	    • You skip all characters that should be removed
	    • You stop on the next valid letter: break
	2.	Move j left same way.
	3.	Compare the valid characters at i and j if mismatch return false.
	4.	Else If mismatch in size → return false.
	5.  Else decrement both the pointers
	6.	If both reach past the beginning → return true.
 */