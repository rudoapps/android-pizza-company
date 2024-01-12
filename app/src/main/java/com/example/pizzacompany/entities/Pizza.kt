package com.example.pizzacompany.entities

data class Pizza(
    val pizzas: List<Pizza>,
    val total: Float
)