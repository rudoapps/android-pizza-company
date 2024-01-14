package com.example.pizzacompany._warehouse

import com.example.pizzacompany._entities.Ingredient

interface WareHouseInterface {
    fun getIngredient(name: String): Ingredient
    fun withdraw(ingredient: Ingredient, quantity: Int)
}