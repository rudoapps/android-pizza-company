package com.example.pizzacompany._client

import com.example.pizzacompany._entities.Order

data class Client(
    val name: String,
    val order: Order,
    val money: Double
): ClientInterface {
    override fun pay(): Double {
        return money
    }

    override fun order(): Order {
        return order
    }
}