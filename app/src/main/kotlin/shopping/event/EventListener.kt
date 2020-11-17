package shopping.event

interface EventListener {
    fun onProcessOrders(status: String, orderCost: Double?)
}