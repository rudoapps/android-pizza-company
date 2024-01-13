package com.example.pizzacompany.roles.cooker

import com.example.pizzacompany._entities.FoodStatus
import com.example.pizzacompany._entities.Ingredient
import com.example.pizzacompany._entities.Pizza
import com.example.pizzacompany._information.MenuPizza

interface CookerInterface {
    fun take(ingredients: List<Ingredient>): List<Ingredient>
    fun cook(pizza: MenuPizza): FoodStatus
}