package com.example.pizzacompany._restaurant

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pizzacompany._client.Client
import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._entities.OrderStatus
import com.example.pizzacompany._entities.PaymentStatus
import com.example.pizzacompany.roles.clerk.ClerkInterface

class Restaurant(clients: List<Client>, private val clerk: ClerkInterface): ViewModel() {
    private var clients: List<Client> = clients

    fun open() {
        try {
            clients.forEach {
                Log.i("RESTAURANT", "Cliente " + it.name + ": Quiero pedir " + it.order)
                var status = clerk.receive(it.order)
                when (status) {
                    OrderStatus.FINISH -> orderFinished(it.order(), it.pay())
                    OrderStatus.NOMOREPIZZA -> Log.i("RESTAURANT", "Cliente: Os odio")
                }
            }
        } catch (e: Exception) {
            Log.i("RESTAURANT", "ERROR: La has liado, no tendría que pasar esto... has quemado el restaurante")
        }
    }
    private fun orderFinished(order: Order, money: Double) {
        Log.i("RESTAURANT", "Dependiente: Pedido terminado, hora de pagar")
        var statusAndChange = clerk.chargeWithStatusAndChange(order ,money)
        when(statusAndChange.first) {
            PaymentStatus.OK -> Log.i("RESTAURANT","Dependiente: dinero justo, gracias")
            PaymentStatus.NOTENOUGH -> Log.i("RESTAURANT","Dependiente: No es suficiente. PAGA!")
            PaymentStatus.CHANGE -> Log.i("RESTAURANT","Dependiente: Gracias este es tu cambio: " + statusAndChange.second)
        }
    }
}