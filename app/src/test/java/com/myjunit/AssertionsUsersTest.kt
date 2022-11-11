package com.myjunit

import org.junit.After
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
        println("Before")
    }

    //se ejecuta despues de cada prueba
    //tearDown -> limpiar las variables inicializadas, incluso volverlas null de ser necesario
    @After
    fun tearDown(){
        bot = User()
        juan = User()
        println("After")
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
        println("checkHuman")
    }

    @Test
    fun checkNotNullUserTest(){
        assertNotNull(juan)
        println("checkNotNullUser")
    }

    /*Con println se ejecutan en le siguiente orden:
    Before
    checkHuman
    After
    Before
    checkNotNullUser
    After*/
}