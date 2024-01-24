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
import com.example.pizzacompany._warehouse.WareHouse
import com.example.pizzacompany._entities.Order
import com.example.pizzacompany._information.MenuPizza
import com.example.pizzacompany._information.stocks
import com.example.pizzacompany._restaurant.Restaurant
import com.example.pizzacompany.roles.clerk.Clerk
import com.example.pizzacompany.roles.cooker.Cooker
import com.example.pizzacompany.roles.warehousemanager.WareHouseWorker
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

                    var clients = listOf(
                        Client(
                            name = "Pedro",
                            order = Order(
                                pizzas = listOf(
                                    MenuPizza.CARBONARA,
                                    MenuPizza.MARGARITA,
                                    MenuPizza.BARBACOA)),
                            money = 10.0)
                    )

                    var wareHouse = WareHouse(stocks = stocks)
                    var wareHouseWorker = WareHouseWorker(wareHouse = wareHouse)
                    var cooker = Cooker(wareHouseWorker = wareHouseWorker)
                    var clerk = Clerk(cooker = cooker)
                    var restaurant = Restaurant(
                        clients = clients,
                        clerk = clerk
                    )

                    restaurant.open()
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