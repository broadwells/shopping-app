package shopping.event

class EventManager {
    lateinit var listener: EventListener

    fun subscribe(listener: EventListener) {
        this.listener = listener
    }

    fun notify(status: String, orderCost: Double?) {
        listener.onProcessOrders(status, orderCost)
    }
}