package com.myjunit

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AssertionsUsersTest {

    private lateinit var bot: User  //("8bit", 1, false)
    private lateinit var juan: User  //("Juan", 18, true)

    //se ejecuta aqntes de cada prueba
    //el @Before es un complemento de la prueba
    @Before
    fun setup(){
        bot = User("8bit", 1, false)
        juan = User("Juan", 18, true)
        //println("Before")
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
    }

    @Test
    fun checkNotNullUserTest(){
        assertNotNull(juan)
    }
}