package shopping.notification

import shopping.event.EventListener
import kotlin.random.Random


class OrderNotificationListener: EventListener {

    override fun onProcessOrders(status: String, orderCost: Double?) {
        when(status) {
            "Success" -> println("Order was successful, $${orderCost}. Estimated delivery is ${Random.nextInt(0,
                    10)} " +
                    "days.")
            "Processing" -> println("Order is processing")
        }
    }

}

