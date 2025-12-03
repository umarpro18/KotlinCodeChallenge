package com.sample.umar.leetcodemediums.okx

/*
You are given 2 strings of the same length, consisting of 0-1. We call them string A and string B. Now we want to make them become the same string. We only have one operation. That is to select one character in A and swap with another character in B(You can choose any position in the string).
Then what is the minimum number of operations, we can make two strings become the same string.
 */

//Also some questions
/**
 * 1. What is memory leaks and how to detect memory leaks in production
 * 2. What is fps and how ui is rendered and what process happened during ui rendering
 * 3. What is the difference between apk and aab
 *
 */

fun main() {
    println(minOperationsToMakeEqual("0101", "0011")) // Output: 1
    println(minOperationsToMakeEqual("01010", "10100")) // Output: 2
    println(minOperationsToMakeEqual("011", "000")) // Output: -1
}

fun minOperationsToMakeEqual(A: String, B: String): Int {
    var count01 = 0
    var count10 = 0

    for (i in A.indices) {
        if (A[i] == '0' && B[i] == '1') count01++
        if (A[i] == '1' && B[i] == '0') count10++
    }
    return maxOf(count01, count10)
}
