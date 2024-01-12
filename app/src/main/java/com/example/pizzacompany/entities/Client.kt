package com.example.pizzacompany.entities

data class Client(
    val name: String,
    val order: Order,
    val money: Float
)