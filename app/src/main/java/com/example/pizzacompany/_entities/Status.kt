package com.example.pizzacompany._entities

enum class OrderStatus {
    FINISH,
    NOMOREPIZZA
}

enum class PaymentStatus {
    OK,
    NOTENOUGH,
    CHANGE;
}

enum class FoodStatus {
    DONE,
    MISSINGINGREDIENTS
}