package com.example.pizzacompany.roles.warehousemanager

import com.example.pizzacompany._entities.Ingredient

interface WareHouseWorkerInterface {
    fun search(ingredient: Ingredient): Ingredient?
    fun checkWithdrawAndReturn(ingredient: Ingredient): Ingredient?
}