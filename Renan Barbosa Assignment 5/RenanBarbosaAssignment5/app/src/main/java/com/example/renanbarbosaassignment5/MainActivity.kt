package com.example.renanbarbosaassignment5

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inventoryItem1 = Inventory(
            name = "Laptop",
            quantity = 10,
            supplier = "Tech Supplies",
            costPerUnit = 1500.0
        )

        val inventoryItem2 = Inventory(
            name = "Mouse",
            quantity = 8,
            supplier = "TechGuru",
            costPerUnit = 10.0
        )

        CoroutineScope(Dispatchers.IO).launch {
            val db = InventoryDatabase.getInstance(context)
            db.dao.upsertProduct(inventoryItem1)
            db.dao.upsertProduct(inventoryItem2)

            val totalWorth = db.dao.getTotalMonetaryWorth() ?: 0.0
            println("Total Monetary Worth: $totalWorth")
        }
    }
}


