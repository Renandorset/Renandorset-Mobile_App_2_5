package com.example.renanbarbosaassignment5

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null, // Auto-generated primary key
    val name: String, // Required field
    val quantity: Int, // Numeric field
    val supplier: String = "Co-op Store", // Default value for supplier
    val costPerUnit: Double = 0.0 // Values in decimal with default
)
