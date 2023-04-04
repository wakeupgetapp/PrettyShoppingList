package com.wakeupgetapp.prettyshoppinglist.data.model

data class ShoppingListCategory(
    val id: Long = 0L,
    val name: String = "",
    val entries: List<ShoppingListEntry> = emptyList(),
    val shoppingListId: Long = 0L
)
