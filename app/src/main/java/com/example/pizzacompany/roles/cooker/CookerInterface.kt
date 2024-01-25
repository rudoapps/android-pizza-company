package com.example.pizzacompany.roles.cooker

import android.util.Log
import com.example.pizzacompany._entities.FoodStatus
import com.example.pizzacompany._entities.Ingredient
import com.example.pizzacompany._entities.Pizza
import com.example.pizzacompany._information.MenuPizza

data class NotEnoughException(override val message: String) : Exception(message){
    init {
        Log.e("RESTAURANT", message)
    }
}
interface CookerInterface {
    fun cook(pizza: MenuPizza): FoodStatus
}