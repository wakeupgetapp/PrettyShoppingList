package com.wakeupgetapp.prettyshoppinglist.data.mapper

import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithEntries
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntry
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntryState

fun ShoppingListEntity.toShoppingList(): ShoppingList {
    return ShoppingList(
        id = id,
        title = title,
        date = date,
    )
}

fun ShoppingList.toShoppingListEntity(): ShoppingListEntity {
    return ShoppingListEntity(
        id = id,
        title = title,
        date = date,
    )
}

fun ShoppingListWithEntries.toDomainModel(): ShoppingList {
    val entries = entriesList.map { entry ->
        ShoppingListEntry(
            id = entry.id,
            category = entry.category,
            name = entry.name,
            state = ShoppingListEntryState.DONE//entry.state
        )
    }
    return ShoppingList(
        id = shoppingList.id,
        title = shoppingList.title,
        date = shoppingList.date,
        entriesList = entries
    )
}