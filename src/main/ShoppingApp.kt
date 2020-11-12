package main

class ShoppingApp {
    fun main(shoppingList: Array<String>) {
        val productMap = mapOf("Apple" to 0.60, "Orange" to 0.25)
        println(findCost(shoppingList, productMap))
    }

    fun findCost(shoppingList: Array<String>, inventory: Map<String, Double>): Double {
        var cost = 0.00
        for (product in shoppingList) {
            cost += inventory.getOrElse(product) { 0.00 }
        }
        return cost
    }

}