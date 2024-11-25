package com.example.renanbarbosaassignment5

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface InventoryDao {

    // Insert new or update existing
    @Upsert
    suspend fun upsertProduct(inventory: Inventory)

    // Remove a product
    @Delete
    suspend fun deleteProduct(inventory: Inventory)

    // Calculate total monetary worth
    @Query("SELECT SUM(quantity * costPerUnit) FROM inventory")
    suspend fun getTotalMonetaryWorth(): Double?
}