package com.sample.umar.leetcodemediums.practise2

fun main() {
    println(validPalindrome("aba"))
}


/**
 * Algo:
 * Iterate the given input string with two pointer, i starts from 0 and j from last index
 * when i is less than j
 * check if the char at i and j are equal and do i++ and j--
 * else reiterate once to skip by passing the index (i+1, j) and (i, j-1) if either is true return true or return false
 * if loop finishes then return true
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
            return checkPalindrome(left + 1, right) || checkPalindrome(left, right - 1)
        }
    }

    return true
}