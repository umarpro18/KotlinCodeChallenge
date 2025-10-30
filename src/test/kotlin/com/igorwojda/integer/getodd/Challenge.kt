package com.igorwojda.integer.getodd

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
    println(filterOdd(listOf(1,2,2,3,4,5,6,7,8,9,0,10,12,14,45,23,67,55,34,89,78)))
}
private fun filterOdd(list: List<Int>): List<Int> {
    return list.filter {it % 2 != 0}
}

private class Test {
    @Test
    fun `empty list returns empty list`() {
        filterOdd(listOf()) shouldBeEqualTo emptyList()
    }

    @Test
    fun `1, 2, 3 returns 1, 3`() {
        filterOdd(listOf(1, 2, 3)) shouldBeEqualTo listOf(1, 3)
    }

    @Test
    fun `2, 9, 2, 5, 4 returns 9, 5`() {
        filterOdd(listOf(2, 9, 2, 5, 4)) shouldBeEqualTo listOf(9, 5)
    }

    @Test
    fun `7, 4, 6, 8, 7, 9 returns 7, 7, 9`() {
        filterOdd(listOf(7, 4, 6, 8, 7, 9)) shouldBeEqualTo listOf(7, 7, 9)
    }
}
