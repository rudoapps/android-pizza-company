package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._entities.OrderStatus
import com.example.pizzacompany._entities.PaymentStatus

interface ClerkInterface {
    fun receive(order: Order): OrderStatus
    fun chargeWithStatusAndChange(order: Order, payment: Double): Pair<PaymentStatus, Double>
}