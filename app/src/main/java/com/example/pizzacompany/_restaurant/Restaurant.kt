package com.example.pizzacompany._restaurant

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pizzacompany._client.Client
import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._entities.OrderStatus
import com.example.pizzacompany._entities.PaymentStatus
import com.example.pizzacompany.roles.clerk.ClerkInterface

class Restaurant(clients: List<Client>, private var clerk: ClerkInterface): ViewModel() {
    private var clients: List<Client> = clients

    fun open() {
        try {
            clients.forEach { client ->
                clerk.order = Order()
                Log.i("RESTAURANT", "---------------------------------")
                Log.i("RESTAURANT", "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: Hola " + client.name + " que quieres? ")
                Log.i("RESTAURANT", "\uD83E\uDDD1\u200D\uD83D\uDCBC Cliente: Hola, quiero " + client.order)
                client.order.pizzas.forEach { pizza ->
                    var status = clerk.annotate(pizza)
                    when (status) {
                        OrderStatus.FINISH -> {
                            Log.i("RESTAURANT", "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: Tu " + pizza.name + " ya esta acabada")
                        }
                        OrderStatus.NOMOREPIZZA -> {
                            Log.e("RESTAURANT", "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: No quedan ingredientes para tu: " + pizza.name)
                            Log.e("RESTAURANT", "\uD83E\uDDD1\u200D\uD83D\uDCBC Cliente: Vaya restaurante")
                        }
                    }
                }
                orderFinished(client.pay())
            }
        } catch (e: Exception) {
            Log.e("RESTAURANT", "⚠️ ⚠️ ⚠️ ERROR: La has liado, no tendría que pasar esto... has quemado el restaurante")
        }
    }
    private fun orderFinished(amountToPay: Double) {
        if (clerk.order.pizzas.count() > 0) {
            Log.i(
                "RESTAURANT",
                "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: Pedido terminado, hora de pagar"
            )
            Log.i("RESTAURANT", "\uD83E\uDDD1\u200D\uD83D\uDCBC Cliente: toma " + amountToPay + "€")
            var statusAndChange = clerk.chargeWithStatusAndChange(amountToPay)
            Log.i(
                "RESTAURANT",
                "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: son " + clerk.order.total + "€"
            )
            when (statusAndChange.first) {
                PaymentStatus.OK -> Log.i(
                    "RESTAURANT",
                    "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: dinero justo, gracias"
                )

                PaymentStatus.NOTENOUGH -> {
                    Log.e(
                        "RESTAURANT",
                        "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: No es suficiente. PAGA!"
                    )
                    Log.e(
                        "RESTAURANT",
                        "\uD83E\uDDD1\u200D\uD83D\uDCBC Cliente: \uD83C\uDFC3\u200D️ "
                    )
                }

                PaymentStatus.CHANGE -> Log.i(
                    "RESTAURANT",
                    "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: Gracias este es tu cambio: " + statusAndChange.second
                )
            }
        } else {
            Log.e(
                "RESTAURANT",
                "\uD83E\uDDD1\u200D\uD83C\uDF73 Dependiente: Lo siento no tenemos stock para tu pedido"
            )
            Log.e(
                "RESTAURANT",
                "\uD83E\uDDD1\u200D\uD83D\uDCBC Cliente: \uD83E\uDD2C \uD83E\uDD2C LLAMA A FRANCESCO!"
            )
        }
    }
}