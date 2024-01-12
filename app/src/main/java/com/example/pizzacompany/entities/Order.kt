package com.example.pizzacompany.entities

data class Order(
    val pizzas: List<Pizza>,
    val total: Float = 0.0f
)