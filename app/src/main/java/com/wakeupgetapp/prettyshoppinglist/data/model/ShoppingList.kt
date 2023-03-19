package com.wakeupgetapp.prettyshoppinglist.data.model

data class ShoppingList(
    val id: Long = 0L,
    val title: String = "",
    val date: String = "",
    val entriesList: List<ShoppingListEntry> = emptyList()
)
