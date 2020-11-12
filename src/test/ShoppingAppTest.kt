package test

import main.ShoppingApp
import org.junit.Test
import kotlin.test.assertEquals

class ShoppingAppTest {

    @Test fun findCostOf3Apples1Orange() {
        val shoppingList = arrayOf("Apple", "Apple", "Orange", "Apple")
        val productOptions = mapOf("Apple" to 0.60, "Orange" to 0.25)
        // expected response matches cost of 3 apples and 1 orange
        assertEquals(2.05, ShoppingApp().findCost(shoppingList, productOptions))
    }

    @Test fun findCostOf2ValidFruitOptions1InvalidFruit() {
        // parameter arguments include fruit that is not listed in the product options
        val shoppingList = arrayOf("Apple", "Apple", "Orange", "Pear")
        val productOptions = mapOf("Apple" to 0.60, "Orange" to 0.25)
        // expect response to match cost of 2 apples and 1 orange
        assertEquals(1.45, ShoppingApp().findCost(shoppingList, productOptions))
    }

    @Test fun findCostOf3Apples2Orange() {
        val shoppingList = arrayOf("Apple", "Apple", "Orange", "Apple", "Orange")
        val productOptions = mapOf("Apple" to 0.60, "Orange" to 0.25)
        // expected response matches cost of 3 apples and 1 orange
        assertEquals(2.30, ShoppingApp().findCost(shoppingList, productOptions))
    }

    @Test fun findCostOf2ValidFruitOptionsAndEmptyString() {
        // parameter arguments include fruit that is not listed in the product options
        val shoppingList = arrayOf("Apple", "Apple", "Orange", "")
        val productOptions = mapOf("Apple" to 0.60, "Orange" to 0.25)
        // expect response to match cost of 2 apples and 1 orange
        assertEquals(1.45, ShoppingApp().findCost(shoppingList, productOptions))
    }
}