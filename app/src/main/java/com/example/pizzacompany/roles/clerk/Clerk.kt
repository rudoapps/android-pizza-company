package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany.entities.Order

class Clerk: ClerkInterface {
    override fun receive(order: Order): OrderStatus {
        TODO("Not yet implemented")
    }

    override fun charge(order: Order, payment: Float): PaymentStatus {
        TODO("Not yet implemented")
    }
}