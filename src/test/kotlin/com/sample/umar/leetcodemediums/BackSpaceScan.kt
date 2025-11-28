package com.sample.umar.leetcodemediums

//Given 2 strings s and t, each containing letters and # (which means backspace),
// return true if both strings are equal after applying backspaces.
//# means delete the previous character.
fun main() {
    println(backSpaceCharEquality("ab#c", "add#c"))
}

// Use the two-pointer backward approach "It’s faster and more optimal"
fun backSpaceCharEquality(str1: String, str2: String): Boolean {
    var i = str1.length - 1
    var j = str2.length - 1

    var skip1 = 0
    var skip2 = 0

    while (i >= 0 || j >= 0) {
        while (i >= 0) {
            if (str1[i] == '#') {
                skip1++
                i--
            } else if (skip1 > 0) {
                i--
            } else {
                break
            }
        }

        while (j >= 0) {
            if (str2[j] == '#') {
                skip2++
                j--
            } else if (skip2 > 0) {
                j--
            } else {
                break
            }
        }

        // compare both strings
        if (i >= 0 && j >= 0 && str1[i] != str2[j]) {
            return false
        } else if ((i < 0 && j >= 0) || (j < 0 && i >= 0)) {
            return false
        } else {
            i--
            j--
        }
    }
    return true
}


/* Algo:
    1. Move i left until:
	    • You skip all #
	    • You skip all characters that should be removed
	    • You stop on the next valid letter
	2.	Move j left same way.
	3.	Compare the valid characters at i and j.
	4.	Else If mismatch in size → return false.
	5.  Else decrement both the pointers
	6.	If both reach past the beginning → return true.
 */