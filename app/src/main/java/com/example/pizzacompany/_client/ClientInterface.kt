package com.example.pizzacompany._client

import com.example.pizzacompany.entities.Order

interface ClientInterface {
    fun pay(): Float
    fun order(): Order
}