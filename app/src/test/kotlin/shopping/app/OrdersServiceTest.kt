package shopping.app

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class OrdersServiceTest {

    @Test fun findCostOf3Apples1Orange() {
        val shoppingList = arrayOf("Apple", "Apple", "Orange", "Apple")
        // expected response matches cost of BOGO + 1 apples and 1 orange
        assertEquals(1.45, OrdersService(shoppingList).findCost(shoppingList))
    }

    @Test fun findCostOf2Apples2Orange() {
        val shoppingList = arrayOf("Apple", "apple", "Orange", "Apple", "Orange", "Orange")
        // expected response matches cost of BOGO + 1 apples and B2GO oranges
        assertEquals(1.70, OrdersService(shoppingList).findCost(shoppingList))
    }

    @Test fun findCostOf2ValidFruitOptionsAndEmptyString() {
        // parameter arguments include fruit that is not listed in the product options
        val shoppingList = arrayOf("Apple", "Apple", "Orange", "")
        // expect response to match cost of BOGO apples and 1 orange
        assertEquals(0.85, OrdersService(shoppingList).findCost(shoppingList))
    }

    @Test fun findItemCountOf3ApplesAnd3Oranges() {
        // given: parameter arg of 3 apples and 3 oranges
        val shoppingList = arrayOf("Apple", "Orange", "Apple", "Orange", "Apple", "Orange")

        // when: OrdersService findItem count is called
        val itemsCounted: Map<String, Int>  = OrdersService(shoppingList).findItemCount(shoppingList)

        // then: expect key/value of Apple: 3 and Orange: 3
        assertEquals(3, itemsCounted["Apple".toLowerCase()])
        assertEquals(3, itemsCounted["Orange".toLowerCase()])
    }

    @Test fun findItemCountIgnoresEmptyString() {
        // given: parameter arg of 3 apples and 2 oranges and empty string
        val shoppingList = arrayOf("Apple", "Orange", "Apple", "Orange", "Apple", "")

        // when: OrdersService findItem count is called
        val itemsCounted: Map<String, Int>  = OrdersService(shoppingList).findItemCount(shoppingList)

        // then: expect key/value of Apple: 3 and Orange: 3
        assertTrue(itemsCounted.size == 2)
        assertEquals(3, itemsCounted["Apple".toLowerCase()])
        assertEquals(2, itemsCounted["Orange".toLowerCase()])
    }

    @Test fun specialOfferPriceBOGOApples() {
        // given: String array of 4 apples
        val shoppingList = arrayOf("Apple", "Apple", "Apple", "Apple")
        val ordersService = OrdersService(shoppingList)

        // when: specialOfferPrice is called
        val costAfterOffer: Double = ordersService.specialOfferPrice(shoppingList.size, 2, 0.6)

        // then: expect costAfterOffer to equal the cost of 2 apples instead of 4
        assertEquals(1.2, costAfterOffer)
    }

    @Test fun specialOfferPriceB2GOOranges() {
        // given: String array of 3 apples
        val shoppingList = arrayOf("Orange", "Orange", "Orange")
        val ordersService = OrdersService(shoppingList)

        // when: specialOfferPrice is called
        val costAfterOffer: Double = ordersService.specialOfferPrice(shoppingList.size, 3, 0.25)

        // then: expect costAfterOffer to equal the cost of 2 oranges instead of 3
        assertEquals(0.5, costAfterOffer)
    }
}