package com.sample.umar.leetcodemediums.practice

/**
 * 1. Create a map of <String, MutableList<String>>
 *
 * 2. Loop through each word in the input list:
 *        - Sort the characters of the word → this becomes the key
 *        - If this sorted key is NOT in the map:
 *              create a new empty list for that key
 *        - Add the original word to the list stored under this key
 *
 * 3. After processing all words:
 *        return all the values of the map (each value is a group of anagrams)
 *
 * ⏱ Time:
 *
 * O(n · k log k)
 * (n strings, each sorted with length k)
 *
 * 💾 Space:
 *
 * O(n · k)
 * (groups stored in map)
 *
 * Time Complexity:
 *
 * “For each of n strings I sort its characters, which costs O(k log k).
 * Therefore the total complexity is O(n · k log k).”
 *
 * Space Complexity:
 *
 * “I store groups of anagrams inside a map.
 * In the worst case that requires O(nk) space.”
 */

fun main() {
    println(groupAnagrams(listOf<String>("eat", "tea", "tan", "ate", "nat", "bat")))
}

fun groupAnagrams(inputString: List<String>): List<List<String>> {
    // Create a map to store the key as input words in a sorted order and for every match create and append it to a list of word and return
    val freqMap = mutableMapOf<String, MutableList<String>>()
    inputString.forEach { str ->
        val charListStr = mutableListOf<Char>()
        for (i in 0 until str.length) {
            charListStr.add(str[i])
        }
        var sortedString = ""
        charListStr.sorted().forEach {
            sortedString += it.toString()
        }
        if (!freqMap.containsKey(sortedString)) {
            freqMap[sortedString] = mutableListOf<String>(str)
        } else {
            val valueList = freqMap[sortedString]
            valueList?.add(str)
        }
    }
    return freqMap.values.toList()
}
