package com.example.pizzacompany._client

import com.example.pizzacompany._entities.Order

interface ClientInterface {
    fun pay(): Double
    fun order(): Order
}