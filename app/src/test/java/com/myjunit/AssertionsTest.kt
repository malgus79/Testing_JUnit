package com.myjunit

import org.junit.Assert.*
import org.junit.Test

class AssertionsTest {
    @Test
    fun getArrayTest(){
        val assertions = Assertions()
        val array = arrayOf(35, 115)// valor esperado
        //val array = arrayOf(35, 11)// valor esperado
        assertArrayEquals(
            "mensaje personalizado de error en testing",
            array,
            assertions.getLuckyNumbers()
        )
    }

    @Test
    fun getNameTest(){
        val assertions = Assertions()
        val name = "Matias"
        val otherName = "Nico"
        assertEquals(name, assertions.getName())
        assertNotEquals(otherName, assertions.getName())
    }

    @Test
    fun checkHumanTest(){
        val assertions = Assertions()
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))

        /*Recomendaciones:
        -) solo una afirmacion en cada prueba
        -) verificar que las pruebas fallan si se invierte los valores esperados*/
    }

    @Test
    fun checkNullUserTest(){
        val user = null
        assertNull(user)
        val assertions = Assertions()
        assertNull(assertions.checkHuman(user))
    }

    @Test
    fun checkNotNullUserTest(){
        val juan = User("Juan", 18, true)
        assertNotNull(juan)
    }
}