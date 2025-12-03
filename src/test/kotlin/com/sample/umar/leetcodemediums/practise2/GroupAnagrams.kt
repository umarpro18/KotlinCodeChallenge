package com.sample.umar.leetcodemediums.practise2

/**
 * Group anagrams
 * ["eat", "tea", "tan", "ate", "nat", "bat"]
 * [
 *   ["eat", "tea", "ate"],
 *   ["tan", "nat"],
 *   ["bat"]
 * ]
 *
 * Algo:
 * Iterate teh given list of strings
 * Step 1: Sort each string value and store it in a map as a key
 * Step 2: Check the string against the map key and if it exists append the value to a list else create a new list wit that value within that group
 * Step 3: return the map value
 *
 */

fun main() {
    println(groupAnagrams(listOf<String>("eat", "tea", "tan", "ate", "nat", "bat")))
}

fun groupAnagrams(inputStr: List<String>): List<List<String>> {
    // Iterate the given input list of strings
    // sort the string as char and join it back to string
    // declare a map with key string (sorted string) and value list of strings in the group
    // check if the sorted string already present if not create al list with the given string
    // else add to the map value list
    // after full iteration return the map value list
    val resultMap = mutableMapOf<String, MutableList<String>>()
    inputStr.forEach {
        val sortedCharJoinToString = it.toCharArray().sorted().joinToString("")
        if (!resultMap.containsKey(sortedCharJoinToString)) {
            resultMap[sortedCharJoinToString] = mutableListOf<String>(it)
        } else {
            val valueList = resultMap[sortedCharJoinToString]
            valueList?.add(it)
        }
    }
    return resultMap.values.toList()
}