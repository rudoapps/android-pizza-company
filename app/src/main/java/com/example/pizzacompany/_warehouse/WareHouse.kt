package com.example.pizzacompany._warehouse

import com.example.pizzacompany.entities.Ingredient

data class NotFoundException(override val message: String) : Exception(message)
data class NotEnoughException(override val message: String) : Exception(message)

class WareHouse: WareHouseInterface {
    private var ingredients: List<Ingredient> = emptyList()

    override fun getIngredient(name: String): Ingredient {
        var ingredient = ingredients.firstOrNull { it.name == name }
        if (ingredient != null) {
            return ingredient
        }
        throw(NotFoundException(message = "El ingrediente no se ha encontrado"))
    }

    override fun withdraw(ingredient: Ingredient, quantity: Int) {
        var ingredientInWH: Ingredient = ingredients.firstOrNull { it.name == ingredient.name }.let { it }
            ?: throw(NotFoundException(message = "El ingrediente no se ha encontrado"))
        if (ingredientInWH.quantity - quantity < 0) {
            throw(NotEnoughException(message = "No hay suficiente cantidad de este ingrediente"))
        }
        ingredientInWH.quantity -= quantity
    }
}