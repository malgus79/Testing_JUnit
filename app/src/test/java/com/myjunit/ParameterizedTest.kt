package com.myjunit

import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedTest(var currentValue: Boolean, var currentUser: User) {

    @get:Rule
    val locationESRule = LocationESRule()

    //indicar el arreglo con el cual van a hacerse todos los casos
    companion object{
        var assertions: Assertions? = null

        @BeforeClass
        @JvmStatic
        fun setupCommon(){
            assertions = Assertions()
        }
        @AfterClass
        @JvmStatic
        fun tearDownCommon(){
            assertions = null
        }

        @Parameterized.Parameters @JvmStatic
        /*fun getUsersUS() = arrayOf(
            //cada par debe ser un array interno
            arrayOf(false, User("Pedro", 12)),
            arrayOf(true, User("Clara", 34)),
            arrayOf(true, User("Bot21", 4, false)),
            arrayOf(false, User("Alex", 18)))*/
        fun getUsersES() = arrayOf(
            arrayOf(true, User("Pedro", 19)),
            arrayOf(false, User("Clara", 14)),
            arrayOf(true, User("Bot21", 4, false)),
            arrayOf(true, User("Alex", 18)))
    }

    @Test
    fun isAdultTest() {
        //prueba de getUsersUS() -> sin rule
        //assertEquals(currentValue, assertions?.isAdult(currentUser))
        //prueba de getUsersES() -> con rule
        assertEquals(currentValue, locationESRule.assertions?.isAdult(currentUser))
    }
}