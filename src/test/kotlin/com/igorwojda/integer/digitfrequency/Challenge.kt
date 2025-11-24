package com.igorwojda.integer.digitfrequency

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
    println("Result: ${equalDigitFrequency(124446, 123444)}")
}

private fun equalDigitFrequency(n1: Int, n2: Int): Boolean {
    // Try to convert two integers into strings e.g. 1234, 1234
    val str1 = n1.toString()
    val str2 = n2.toString()
    if (str1.length != str2.length) return false
    val str1Map = processMap(str1)
    val str2Map = processMap(str2)
    println("map data -->$str1Map---$str2Map")
    return str1Map == str2Map

}

private fun processMap(data: String): MutableMap<String, Int> {
    val counterMap: MutableMap<String, Int> = mutableMapOf<String, Int>()
    data.forEach {
        if (counterMap.containsKey(it.toString())) {
            counterMap[it.toString()] = counterMap[it.toString()]!!.plus(1)
        } else {
            counterMap[it.toString()] = 1
        }
    }
    return counterMap
}


private fun sortWithFreq(inputList: List<Int>): List<Int> {
    val countFreq: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

    for (num in inputList) {
        countFreq[num] = (countFreq[num] ?: 0) + 1
    }

    return emptyList()
}

private class Test {
    @Test
    fun `'789' and '897' have the same digit frequency`() {
        equalDigitFrequency(789, 897) shouldBeEqualTo true
    }

    @Test
    fun `'123445' and '451243' have the same digit frequency`() {
        equalDigitFrequency(123445, 451243) shouldBeEqualTo true
    }

    @Test
    fun `'447' and '477' have different digit frequency`() {
        equalDigitFrequency(447, 477) shouldBeEqualTo false
    }

    @Test
    fun `'578' and '0' have different digit frequency`() {
        equalDigitFrequency(578, 0) shouldBeEqualTo false
    }

    @Test
    fun `'0' and '0' have the same digit frequency`() {
        equalDigitFrequency(0, 0) shouldBeEqualTo true
    }
}
