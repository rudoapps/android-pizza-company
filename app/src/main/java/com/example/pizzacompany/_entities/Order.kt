package com.example.pizzacompany._entities

import com.example.pizzacompany._information.MenuPizza

data class Order(
    val pizzas: List<MenuPizza>,
    val total: Float = 0.0f
)