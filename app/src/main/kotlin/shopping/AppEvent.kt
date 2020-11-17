package shopping

import shopping.notification.OrderNotificationListener
import shopping.order.OrdersService

fun main(shoppingList: Array<String>) {
    val ordersService = OrdersService(shoppingList)
    ordersService.event.subscribe(OrderNotificationListener())
    ordersService.processOrder()
}
