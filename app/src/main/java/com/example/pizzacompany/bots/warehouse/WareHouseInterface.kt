package com.example.pizzacompany.bots.warehouse

import com.example.pizzacompany.entities.Ingredient

interface WareHouseInterface {
    fun getIngredient(name: String): Ingredient
    fun withdraw(ingredient: Ingredient, quantity: Int)
}