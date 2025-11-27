package com.sample.umar.leetcodemediums

fun main() {
    println(validPalindrome("abbca"))
}

/*
"aba" → true
"abca" → true  (delete 'b' or 'c')
"abc" → false
** Pattern: Two-pointers + One skip allowed
 */
fun validPalindrome(inputStr: String): Boolean {
    var left = 0
    var right = inputStr.length - 1

    fun checkPalindrome(left: Int, right: Int): Boolean {
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
            left++
            right--
        } else {
            // mismatch : “delete ONE character” rule (but we check and actually skip)
            // call a helper func
            return (checkPalindrome(left + 1, right) || checkPalindrome(left, right - 1))
        }
    }
    return true
}

