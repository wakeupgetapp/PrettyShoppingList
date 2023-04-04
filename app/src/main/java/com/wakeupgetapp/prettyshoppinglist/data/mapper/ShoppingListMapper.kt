package com.wakeupgetapp.prettyshoppinglist.data.mapper

import com.wakeupgetapp.prettyshoppinglist.data.local.model.*
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

fun ShoppingListWithCategoriesAndEntries.toShoppingList(): ShoppingList {
    return ShoppingList(
        id = shoppingList.id,
        title = shoppingList.title,
        date = shoppingList.date,
        categories = shoppingListCategories.map { it.toShoppingListCategories() }
    )
}

fun ShoppingListCategoryWithEntries.toShoppingListCategories(): ShoppingListCategory {
    return ShoppingListCategory(
        id = shoppingListCategoryEntity.id,
        name = shoppingListCategoryEntity.name,
        shoppingListId = shoppingListCategoryEntity.shoppingListId,
        entries = shoppingListEntries.map { it.toShoppingListEntry() }
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