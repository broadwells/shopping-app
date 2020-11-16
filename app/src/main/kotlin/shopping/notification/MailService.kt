package shopping.notification

import shopping.AppEvent
import shopping.order.OrdersService

class MailService {
    fun listener() {
        AppEvent.listen(OrdersService::class.java)?.subscribe {
            println("order successful.")
        }
    }
}
