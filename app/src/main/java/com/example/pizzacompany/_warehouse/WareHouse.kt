package com.example.pizzacompany._warehouse

import android.util.Log
import com.example.pizzacompany._entities.Ingredient
import com.example.pizzacompany._entities.Stock

data class NotFoundException(override val message: String) : Exception(message) {
    init {
        Log.e("RESTAURANT", message)
    }
}
data class NotEnoughException(override val message: String) : Exception(message){
    init {
        Log.e("RESTAURANT", message)
    }
}

class WareHouse(var stocks: List<Stock>): WareHouseInterface {

    override fun getIngredient(name: String): Ingredient {
        var stock = stocks.firstOrNull { it.ingredient.name == name }
        if (stock != null) {
            return stock.ingredient
        }
        throw(NotFoundException(message = "ERROR: El ingrediente no se ha encontrado"))
    }

    override fun withdraw(ingredient: Ingredient, quantity: Int) {
        var stock: Stock = stocks.firstOrNull { it.ingredient.name == ingredient.name }.let { it }
            ?: throw(NotFoundException(message = "ERROR: El ingrediente no se ha encontrado"))
        if (stock.quantity - quantity < 0) {
            throw(NotEnoughException(message = "ERROR: No hay suficiente cantidad de este ingrediente"))
        }
        stock.quantity -= quantity
    }
}