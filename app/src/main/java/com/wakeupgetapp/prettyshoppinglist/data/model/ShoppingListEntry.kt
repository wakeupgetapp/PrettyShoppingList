package com.wakeupgetapp.prettyshoppinglist.data.model


data class ShoppingListEntry(
    val id: Long,
    val category: String = "",
    val name: String = "",
    val state: ShoppingListEntryState = ShoppingListEntryState.INITIAL,
    )

enum class ShoppingListEntryState {
    INITIAL, DURING, DONE
}