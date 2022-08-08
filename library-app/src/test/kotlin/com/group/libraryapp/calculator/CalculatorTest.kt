package com.group.libraryapp.calculator

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class CalculatorTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("beforeAll")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("afterAll")
        }
    }

    @Test
    fun addTest() {

        // given
        val calculator = Calculator(5)

        // when
        calculator.add(3)

        // then
        assertThat(calculator.number).isEqualTo(8)
    }

    @Test
    fun minusTest() {
        val calculator = Calculator(5)
        calculator.minus(3)
        assertEquals(2, calculator.number)
    }

    @Test
    fun multiply() {
        val calculator = Calculator(5)
        calculator.multiply(3)
        assertEquals(15, calculator.number)
    }

    @Test
    fun divide() {
        val calculator = Calculator(5)
        calculator.divide(5)
        assertEquals(1, calculator.number)
    }

    @Test
    fun divide_throw_divide_zero() {
        val calculator = Calculator(5)
        assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.apply {
            assertThat(message).isEqualTo("0으로 나눌 수 없습니다.")
        }
    }
}
