package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany.entities.Order

enum class OrderStatus {
    FINISH,
    NOPIZZALEFT
}

enum class PaymentStatus {
    OK,
    NOTENOUGH,
    MOREMONEY;

    var change: Float = 0.0f
}
interface ClerkInterface {
    fun receive(order: Order): OrderStatus
    fun charge(order: Order, payment: Float): PaymentStatus
}