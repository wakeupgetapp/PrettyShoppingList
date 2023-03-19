package com.wakeupgetapp.prettyshoppinglist.data.local.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingListEntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val category: String = "",
    val name: String,
    val state: String = "pies",
    val shoppingListId: Int
)

