package shopping.notification

import shopping.order.OrdersService
import kotlin.random.Random

class MailService {
    /**
     * My initial attempt to listen for when the thread finishes to print to the terminal that the order was successful.
     * This was my first time learning and working with threads and the execution was not successful. With more time
     * I would've done more research on threading and setting up a class to properly listen for the action to be
     * completed.
     */
    fun listener(thread: Thread) {
        when (thread.state) {
            Thread.State.WAITING -> {
                println("Waiting")
            }
            Thread.State.RUNNABLE -> {
                println("Running")
            }
            else -> {
                println("Order is complete. Estimated delivery time is ${Random.nextInt(0, 5)} hours.")
            }
        }
    }
}

fun main(shoppingList: Array<String>) {
    val mailService = MailService()
    val thread = Thread(OrdersService(shoppingList))
        // start thread
        thread.start()
    // listen for when thread ends
    mailService.listener(thread)
}