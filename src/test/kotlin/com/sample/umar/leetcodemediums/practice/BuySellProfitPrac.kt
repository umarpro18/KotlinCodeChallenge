package com.sample.umar.leetcodemediums.practice

/**
 * maxProfit(listOf(7,1,5,3,6,4))  // returns 5
 *
 * Algo:
 * Two pointer approach: create buy and sell planned for next day to arrive max profit on the given list of prises
 * If the value of sell is greater the value of buy then compute (sell -  buy) to arrive max profit
 * Else assign the buy as sell and continue until arrive we arrive profit by moving sell pointer ahead
 *
 * O(n)
 */


fun main() {
    println(maxProfit(listOf(7, 1, 5, 3, 6, 4)))
}

fun maxProfit(inputList: List<Int>): Int {
    // two pointer approach
    var buy = 0
    var sell = 1
    var maxProfit = 0

    while (sell < inputList.size) {
        if (inputList[sell] > inputList[buy]) {
            // Profit made
            val profit = inputList[sell] - inputList[buy]
            maxProfit = maxOf(maxProfit, profit)
        } else {
            // find better price to buy
            buy = sell
        }
        sell++
    }

    return maxProfit
}