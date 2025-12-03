package com.sample.umar.leetcodemediums.practice


// Use prefix and suffix logic and derive the product moving left and right expect the selected element
fun main() {
    println(productExpectSelf(listOf<Int>(1, 2, 3, 4, 5)))
}

fun productExpectSelf(inputList: List<Int>): List<Int> {
    // Declare a result list with default value as 1 matching the input list size we can overwrite
    // the products into respective positions
    val resultList: MutableList<Int> = MutableList(inputList.size) { 1 }

    // Use prefix to product the left side of the element
    var prefix = 1
    // Use suffix to product the right side of the element
    var suffix = 1

    for (i in 0 until inputList.size) {
        resultList[i] = prefix
        prefix *= inputList[i]
    }

    for (j in inputList.size - 1 downTo 0) {
        resultList[j] *= suffix
        suffix *= inputList[j]
    }

    return resultList
}

/**
 * I build a prefix product and suffix product,
 * and combine them in a single result array.
 * Time O(n), space O(1) without extra result array
 */

fun test2ProductExpectSelf(inputList: List<Int>): List<Int> {
    // declare a result list prefilled with defaults same as input list size
    // we will do product the left and right side of list elements expect the current
    val resultList = MutableList(inputList.size) { 1 }

    // Use two vars to store default before we start the product once left and then do the right with the arrived result, prefix to left and suffix to right
    var prefix = 1
    var suffix = 1

    // from left
    for (i in 0 until inputList.size) {
        resultList[i] = prefix
        prefix *= inputList[i]
    }

    // from right
    for (i in inputList.size - 1 downTo 0) {
        resultList[i] *= suffix
        suffix *= inputList[i]
    }

    return resultList
}

/**
 * 	•	resultList with 1s
 * 	•	prefix for cumulative product from the left
 * 	•	suffix for cumulative product from the right
 */
