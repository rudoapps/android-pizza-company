package com.example.pizzacompany._information
import com.example.pizzacompany._entities.Ingredient
import com.example.pizzacompany._entities.Pizza

var carbonara = Pizza(
    ingredients = listOf(queso, tomate, cebolla),
    price = 10.5)

var margarita = Pizza(
    ingredients = listOf(queso, tomate, jamon),
    price = 10.5)

var barbacoa = Pizza(
    ingredients = listOf(carne, queso, tomate, bacon),
    price = 10.5)


enum class MenuPizza {
    CARBONARA(ingredients = carbonara.ingredients, price = carbonara.price),
    MARGARITA(ingredients = margarita.ingredients, price = margarita.price),
    BARBACOA(ingredients = barbacoa.ingredients, price = barbacoa.price);

    var ingredients: List<Ingredient>
    var price: Double

    constructor(
        ingredients: List<Ingredient>,
        price: Double
    ) {
        this.ingredients = ingredients
        this.price = price
    }
}