package com.wakeupgetapp.prettyshoppinglist.data.mapper

import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListCategoryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntryEntity
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListCategory
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntry

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

fun ShoppingListCategory.toShoppingListCategoryEntity(): ShoppingListCategoryEntity {
    return ShoppingListCategoryEntity(
        id = id,
        name = name,
        shoppingListId = shoppingListId
    )
}

fun ShoppingListCategoryEntity.toShoppingListCategory(): ShoppingListCategory {
    return ShoppingListCategory(
        id = id,
        name = name,
        shoppingListId = shoppingListId
    )
}

fun ShoppingListEntry.toShoppingListEntryEntity(): ShoppingListEntryEntity {
    return ShoppingListEntryEntity(
        id = id,
        name = name,
        state = state,
        shoppingListCategoryId = shoppingListCategoryId
    )
}

fun ShoppingListEntryEntity.toShoppingListEntry(): ShoppingListEntry {
    return ShoppingListEntry(
        id = id,
        name = name,
        state = state,
        shoppingListCategoryId = shoppingListCategoryId
    )
}