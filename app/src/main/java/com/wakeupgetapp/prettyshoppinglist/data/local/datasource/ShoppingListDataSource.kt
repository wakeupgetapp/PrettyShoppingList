package com.wakeupgetapp.prettyshoppinglist.data.local.datasource

import com.wakeupgetapp.prettyshoppinglist.data.local.model.*
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListDataSource {
    fun getShoppingLists(): Flow<List<ShoppingListEntity>>
    fun getShoppingList(id: Long): Flow<ShoppingListWithCategoriesAndEntries>
    suspend fun addShoppingList(shoppingList: ShoppingListEntity): Long
    suspend fun addShoppingListCategory(shoppingListCategoryEntity: ShoppingListCategoryEntity): Long
    suspend fun addShoppingListEntry(shoppingListEntryEntity: ShoppingListEntryEntity): Long
    fun deleteShoppingList(shoppingList: ShoppingListEntity)

    suspend fun updateShoppingList(shoppingList: ShoppingListEntity)
}