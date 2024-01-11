package com.example.pizzacompany.roles.cooker

import com.example.pizzacompany.entities.Ingredient
import com.example.pizzacompany.entities.Pizza

interface CookerInterface {
    fun take(ingredients: List<Ingredient>): List<Ingredient>
    fun cook(pizzas: List<Pizza>)
}