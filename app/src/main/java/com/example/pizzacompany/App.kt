package com.example.pizzacompany

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pizzacompany._client.Client
import com.example.pizzacompany.entities.Ingredient
import com.example.pizzacompany.entities.Order
import com.example.pizzacompany.entities.Pizza
import com.example.pizzacompany.roles.clerk.Clerk
import com.example.pizzacompany.ui.theme.PizzaCompanyTheme

class App : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaCompanyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var cebolla = Ingredient(name = "cebolla", quantity = 10)
                    var queso = Ingredient(name = "queso", quantity = 10)
                    var tomate = Ingredient(name = "tomate", quantity = 10)
                    var bacon = Ingredient(name = "bacon", quantity = 10)
                    var carne = Ingredient(name = "carne", quantity = 10)

                    var carbonara = Pizza(
                        ingredients = listOf(cebolla, queso, tomate),
                        price = 10.5f)

                    var clients = listOf(
                        Client(name = "Pedro", order = Order(pizzas = listOf(carbonara)), money = 10.0f)
                    )

                    var restaurant = Restaurant(
                        clients = clients,
                        clerk = Clerk()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzaCompanyTheme {
        Greeting("Android")
    }
}