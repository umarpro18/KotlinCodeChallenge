package com.sample.umar.leetcodemediums

fun main() {
    println(productExpectSelf(listOf(1, 2, 3, 4)))
}


fun productExpectSelf(inputList: List<Int>): List<Int> {
    //Basically, use prefix and suffix of the index to product both sides separately and combine
    val resultList = MutableList(inputList.size) { 1 }
    var prefix = 1
    for (i in inputList.indices) {
        resultList[i] = prefix
        prefix *= inputList[i]
    }


    var suffix = 1
    for (i in inputList.size - 1 downTo 0) {
        resultList[i] = resultList[i] * suffix
        suffix *= inputList[i]
    }
    return resultList
}

/*
🔹 Prefix:
res[i] = prefix
prefix *= nums[i]

🔹 Suffix:

res[i] *= suffix
suffix *= nums[i]

O(n) for time due to linear scan of elements and preparing result list
 */