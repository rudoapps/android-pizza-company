package com.example.pizzacompany.roles.cooker

import com.example.pizzacompany._entities.FoodStatus
import com.example.pizzacompany._entities.Ingredient
import com.example.pizzacompany._information.MenuPizza
import com.example.pizzacompany.roles.warehousemanager.WareHouseWorkerInterface

class Cooker(val wareHouseWorker: WareHouseWorkerInterface): CookerInterface {
    private fun takeAll(ingredients: List<Ingredient>): List<Ingredient> {
        return emptyList()
    }

    override fun cook(pizza: MenuPizza): FoodStatus {
        TODO("Not yet implemented")
    }
}