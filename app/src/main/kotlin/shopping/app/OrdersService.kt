package shopping.app

import kotlin.math.floor
import kotlin.random.Random

class OrdersService(shoppingList: Array<String>) : Runnable {
    private var productMap: Map<String, Map<String, Any>> = emptyMap()
    private var shoppingList: Array<String> = emptyArray()

    init {
        this.productMap = mapOf("apple" to mapOf("price" to 0.60, "offer" to 2), "orange"
                to mapOf("price" to 0.25, "offer" to 3))
        this.shoppingList = shoppingList
    }

    override fun run() {
        println("Order number: ${Random.nextInt(0, 100)} is being processed.")
        println(findCost(shoppingList))
    }

    fun findCost(shoppingList: Array<String>): Double {
        var cost = 0.00
        val itemCount: Map<String, Int> = findItemCount(shoppingList)
        for (product in itemCount) {
            try {
                cost += specialOfferPrice(product.value,
                        productMap[product.key.toLowerCase()]?.get("offer") as Int,
                        productMap[product.key.toLowerCase()]?.get("price") as Double)
            } catch (e: NullPointerException) {
                println("${product.key} is currently not an option")
                continue
            }
        }

        return cost
    }

     fun findItemCount(shoppingList: Array<String>): Map<String, Int> {
        val itemCount = mutableMapOf(shoppingList[0].toLowerCase() to 0)
        for (productItem in shoppingList) {
            val product: String = productItem.toLowerCase()
            if (product.isEmpty()) {
                // ignore empty strings
                continue
            }
            if (!itemCount.containsKey(product)) {
                itemCount.put(product, 1)
            } else {
                itemCount.put(product, itemCount[product]?.plus(1)!!)
            }
        }
        return itemCount
    }

     fun specialOfferPrice(itemCount: Int, offer: Int, price: Double): Double {
        val itemCountAfterOffer: Int = floor(itemCount.div(offer).toDouble()).toInt()
        return price.times((itemCount.minus(itemCountAfterOffer)))
    }
}

fun main(shoppingList: Array<String>) {
    val thread = Thread(OrdersService(shoppingList))
    thread.start()
}
