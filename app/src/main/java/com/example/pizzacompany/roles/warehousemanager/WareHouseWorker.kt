package com.example.pizzacompany.roles.warehousemanager

import com.example.pizzacompany._warehouse.WareHouseInterface
import com.example.pizzacompany._entities.Ingredient

class WareHouseWorker(val wareHouse: WareHouseInterface): WareHouseWorkerInterface {
    private fun search(ingredient: Ingredient): Ingredient? {
        //Úsalo si crees que lo necesitas
        return null
    }

    override fun checkWithdrawAndReturn(ingredient: Ingredient): Ingredient? {
        TODO("Not yet implemented")
    }
}