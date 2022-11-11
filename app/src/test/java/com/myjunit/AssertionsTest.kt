package com.myjunit

import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class AssertionsTest {
    @Test
    fun getArrayTest(){
        val assertions = Assertions()
        val array = arrayOf(35, 115)// valor esperado

        assertArrayEquals(array, assertions.getLuckyNumbers())
    }
}