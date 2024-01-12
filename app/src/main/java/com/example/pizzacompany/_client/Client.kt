package com.example.pizzacompany._client

import com.example.pizzacompany.entities.Order

data class Client(
    val name: String,
    val order: Order,
    val money: Float
): ClientInterface {
    override fun pay(): Float {
        return money
    }

    override fun order(): Order {
        return order
    }
}