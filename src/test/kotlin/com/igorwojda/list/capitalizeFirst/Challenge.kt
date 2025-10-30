package com.igorwojda.list.capitalizeFirst

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import java.util.*

fun main() {
    capitalizeFirst(listOf("umar"))
}
private fun capitalizeFirst(list: List<String>): List<String> {
    val capsList = mutableListOf<String>()
    list.forEach { it ->
        capsList.add(it.substring(0).replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
    }
    return capsList
}

private class Test {
    @Test
    fun `capitalize list with one string`() {
        capitalizeFirst(listOf("igor")) shouldBeEqualTo listOf("Igor")
    }

    @Test
    fun `capitalize list with two strings`() {
        capitalizeFirst(listOf("igor", "wojda")) shouldBeEqualTo listOf("Igor", "Wojda")
    }

    @Test
    fun `capitalize list with empty string`() {
        capitalizeFirst(listOf("")) shouldBeEqualTo listOf("")
    }

    @Test
    fun `capitalize list with sentence`() {
        capitalizeFirst(listOf("what a", "beautiful", "morning")) shouldBeEqualTo listOf(
            "What a",
            "Beautiful",
            "Morning",
        )
    }
}
