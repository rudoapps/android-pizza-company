package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._entities.OrderStatus
import com.example.pizzacompany._entities.PaymentStatus
import com.example.pizzacompany._information.MenuPizza

interface ClerkInterface {
    var order: Order
    fun annotate(pizza: MenuPizza): OrderStatus
    fun chargeWithStatusAndChange(paymentAmount: Double): Pair<PaymentStatus, Double>
}