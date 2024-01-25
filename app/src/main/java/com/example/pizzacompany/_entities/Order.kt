package com.example.pizzacompany._entities

import com.example.pizzacompany._information.MenuPizza

data class Order(
    val pizzas: MutableList<MenuPizza> = mutableListOf<MenuPizza>(),
    var total: Double = 0.0
)