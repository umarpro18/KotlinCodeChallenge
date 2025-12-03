package com.sample.umar.leetcodemediums.practise2

fun main() {
    println(backSpaceComparePrac2("ab#c", "ab#c"))
}


/**
 * Algo:
 * FOr the given two strings, use two pointers and start from the end and move left
 * for every # reduce the index and increment skip counter and if skip counter is greater than 0 move left again until it found a valid char and break
 * same for the second string as well
 *
 * if both index is greater than 0 and the chars does not match then return false
 * else if both index mismatch then return false
 * else move left
 *
 * on finishing the loop return true
 */


fun backSpaceComparePrac2(str1: String, str2: String): Boolean {
    var i = str1.length - 1
    var j = str2.length - 1
    var skip1 = 0
    var skip2 = 0

    while (i >= 0 || j >= 0) {
        // for left side string
        while (i >= 0) {
            if (str1[i] == '#') {
                i--
                skip1++
            } else if (skip1 > 0) {
                i--
                skip1--
            } else {
                break
            }
        }

        // for right side string
        while (j >= 0) {
            if (str2[j] == '#') {
                j--
                skip2++
            } else if (skip2 > 0) {
                j--
                skip2--
            } else {
                break
            }
        }

        if (i >= 0 && j >= 0 && str1[i] != str2[j]) { //char mismatch
            return false
        }
        if ((i >= 0) != (j >= 0)) { // char size mismatch
            return false
        }

        i--
        j--

    }
    return true
}