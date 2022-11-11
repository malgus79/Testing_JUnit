package com.myjunit

import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

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

    @Test
    fun checkNotSameUsersTest(){
        val bot = User("8bit", 1, false)
        val juan = User("Juan", 18, true)
        assertNotSame(bot, juan)
    }

    @Test
    fun checkSameUsersTest(){
        val bot = User("Juan", 18, true)
        val juan = User("Juan", 18, true)
        val copyJuan = juan
        /*assertSame(bot, juan)
        //no pasa la prueba porque se crea una referencia por objeto o instancia de clase
        //esta afirmacion verifica si realmente se trata del mismo objeto,
        //que tengan las mismas propiedades no significa que sean el mismo objeto*/

        assertSame(copyJuan, juan)
    }

    //limitar el timeout (ejemplo en las peticiones a servidor externo)
    @Test(timeout = 1_000)
    fun getCitiesTest(){
        val cities = arrayOf("México", "Perú", "Argentina")
        Thread.sleep(Random.nextLong(100, 1_100))
        //Thread.sleep(Random.nextLong(900, 1_100))
        assertEquals(3, cities.size)
    }
}