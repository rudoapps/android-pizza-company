package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany.entities.Order

interface ClerkInterface {
    suspend fun receive(order: Order)
    suspend fun chargeAndReturn(order: Order, payment: Float): Float
}