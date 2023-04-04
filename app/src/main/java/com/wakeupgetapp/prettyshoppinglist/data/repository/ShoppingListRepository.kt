package com.wakeupgetapp.prettyshoppinglist.data.repository

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListCategory
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntry
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {
    fun getShoppingLists(): Flow<List<ShoppingList>>
    fun getShoppingList(id: Long): Flow<ShoppingList>
    suspend fun addShoppingList(shoppingList: ShoppingList): Long
    suspend fun addShoppingListCategory(shoppingListCategory: ShoppingListCategory): Long
    suspend fun addShoppingListEntry(shoppingListEntry: ShoppingListEntry): Long
    fun deleteShoppingList(shoppingList: ShoppingList)
    suspend fun updateShoppingList(shoppingList: ShoppingList)

}

