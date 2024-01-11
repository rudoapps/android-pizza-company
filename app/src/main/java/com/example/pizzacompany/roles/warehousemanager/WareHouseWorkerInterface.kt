package com.example.pizzacompany.roles.warehousemanager

import com.example.pizzacompany.entities.Ingredient

interface WareHouseWorkerInterface {
    fun search(ingredient: Ingredient)
    fun provide(ingredients: List<Ingredient>): List<Ingredient>
}