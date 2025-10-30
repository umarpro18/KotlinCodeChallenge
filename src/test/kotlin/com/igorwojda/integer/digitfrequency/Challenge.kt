package com.igorwojda.integer.digitfrequency

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
    println("Result: ${equalDigitFrequency(1234444, 123444)}")
    //println("Result: ${equalDigitFreq(1234, 1234)}")
}

/*private fun equalDigitFrequency(i1: Int, i2: Int): Boolean {
    val i1ToStr = i1.toString()
    val i2ToStr = i2.toString()
    return (i1ToStr.length == i2ToStr.length && i1 == i2)
}*/


private fun equalDigitFrequency(n1: Int, n2: Int): Boolean {
    val sampleList = listOf<Int>(n1, n2)
    val freqMap = mutableMapOf<Int, Int>()

    sampleList.forEach { it ->
        println(it)
        freqMap[it] = freqMap.getOrDefault(it, 0) + 1
    }

    freqMap.forEach { it -> println(it) }

    println("Actual size-->" + freqMap.size)


    return freqMap.size == 1
}

private class Test {
    @Test
    fun `'789' and '897' have the same digit frequency`() {
        equalDigitFrequency(789, 897) shouldBeEqualTo false
    }

    @Test
    fun `'123445' and '451243' have the same digit frequency`() {
        equalDigitFrequency(123445, 451243) shouldBeEqualTo false
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
