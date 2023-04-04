package com.wakeupgetapp.prettyshoppinglist.data.model


data class ShoppingListEntry(
    val id: Long = 0L,
    val name: String = "",
    val state: ShoppingListEntryState = ShoppingListEntryState.INITIAL,
    val shoppingListCategoryId: Long
    )

enum class ShoppingListEntryState {
    INITIAL, DURING, DONE
}