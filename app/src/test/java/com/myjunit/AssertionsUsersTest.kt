package com.myjunit

import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class AssertionsUsersTest {

    private lateinit var bot: User

    //@BeforeClass y @AfterClass -> para inicializar y liberar recursos mas pesados
    companion object {
        private lateinit var juan: User

        @BeforeClass @JvmStatic
        fun setupCommon(){
            juan = User("Juan", 18, true)
            println("BeforeClass")
        }

        @AfterClass @JvmStatic
        fun tearDownCommon(){
            juan = User()
            println("AfterClass")
        }
    }

    //se ejecuta aqntes de cada prueba
    //el @Before es un complemento de la prueba
    @Before
    fun setup(){
        bot = User("8bit", 1, false)
        println("Before")
    }

    //se ejecuta despues de cada prueba
    //tearDown -> limpiar las variables inicializadas, incluso volverlas null de ser necesario
    @After
    fun tearDown(){
        bot = User()
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

    @Test
    fun checkNotSameUsersTest(){
        assertNotSame(bot, juan)
        println("checkNotSameUsers")
    }

    @Test
    fun checkSameUsersTest(){
        val copyJuan = juan
        assertSame(copyJuan, juan)
        println("checkSameUsers")
    }
}