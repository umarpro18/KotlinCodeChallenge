package com.sample.umar.leetcodemediums.practice

fun main() {
    println(checkPalindrome("abcdef"))
}

/**
 * Algo:
 * Use two pointers left and right and move inwards comparing the char's to be valid palindrome
 * If chars match move pointers if not recheck with moving one and the other separately and repeat
 * for a mismatch return false else true for successful iteration through comparison
 */

fun checkPalindrome(inputStr: String, deletions: Int = 0): Boolean {
    var left = 0
    var right = inputStr.length - 1

    fun checkForPalindrome(left: Int, right: Int, kDeletions: Int): Boolean {
        var i = left
        var j = right

        while (i < j) {
            if (inputStr[i] == inputStr[j]) {
                i++
                j--
            } else {
                return false
            }
        }
        return true
    }

    while (left < right) {
        if (inputStr[left] == inputStr[right]) {
            // char match move pointer inwards
            left++
            right--
        } else {
            return checkForPalindrome(left + 1, right, deletions - 1) || checkForPalindrome(
                left,
                right - 1,
                deletions - 1
            )
        }
    }
    return true
}

fun checkPalindromeK(inputStr: String, k: Int = 3): Boolean {
    // helper function that checks palindrome with deletesLeft
    fun checkForPalindrome(leftStart: Int, rightStart: Int, deletesLeft: Int): Boolean {
        var left = leftStart
        var right = rightStart
        var kLeft = deletesLeft

        while (left < right) {
            if (inputStr[left] == inputStr[right]) {
                // characters match → move inward
                left++
                right--
            } else {
                // mismatch and no deletions left → fail
                if (kLeft == 0) return false

                // try removing LEFT or removing RIGHT
                return checkForPalindrome(left + 1, right, kLeft - 1) ||
                        checkForPalindrome(left, right - 1, kLeft - 1)
            }
        }
        return true
    }

    // start with full string and k deletions allowed
    return checkForPalindrome(0, inputStr.length - 1, k)
}