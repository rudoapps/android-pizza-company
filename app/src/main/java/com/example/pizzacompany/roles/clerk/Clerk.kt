package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._entities.OrderStatus
import com.example.pizzacompany._entities.PaymentStatus
import com.example.pizzacompany.roles.cooker.CookerInterface

class Clerk(val cooker: CookerInterface): ClerkInterface {
    override fun receive(order: Order): OrderStatus {
        TODO("Not yet implemented")
    }

    override fun chargeWithStatusAndChange(order: Order, payment: Double): Pair<PaymentStatus, Double> {
        TODO("Not yet implemented")
    }
}