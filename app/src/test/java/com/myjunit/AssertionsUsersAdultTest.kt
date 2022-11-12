package com.myjunit

import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class AssertionsUsersAdultTest {

    private lateinit var bot: User
    private lateinit var juan: User

    @Before
    fun setup(){
        bot = User("8bit", 1, false)
        juan = User("Juan", 18, true)
    }

    @After
    fun tearDown(){
        bot = User()
        juan = User()
    }

    @Test
    fun isAdult() {
        val assertions = Assertions()
        assertions.setLocation("ES")
        assertTrue(assertions.isAdult(juan))
        assertTrue(assertions.isAdult(bot))
//        assertEquals(true, locationESRule.assertions?.isAdult(juan))
//        assertEquals(true, locationESRule.assertions?.isAdult(bot))
    }
}