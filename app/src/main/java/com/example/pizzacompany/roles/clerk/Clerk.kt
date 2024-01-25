package com.example.pizzacompany.roles.clerk

import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._entities.OrderStatus
import com.example.pizzacompany._entities.PaymentStatus
import com.example.pizzacompany._information.MenuPizza
import com.example.pizzacompany.roles.cooker.CookerInterface

class Clerk(val cooker: CookerInterface) : ClerkInterface {
    override var order: Order = Order()
    override fun annotate(pizza: MenuPizza): OrderStatus {
        TODO("Not yet implemented")
    }

    override fun chargeWithStatusAndChange(paymentAmount: Double): Pair<PaymentStatus, Double> {
        TODO("Not yet implemented")
    }
}