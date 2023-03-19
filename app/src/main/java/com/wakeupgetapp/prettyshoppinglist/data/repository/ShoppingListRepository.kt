package com.wakeupgetapp.prettyshoppinglist.data.repository

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListRepository {
    fun getShoppingLists(): Flow<List<ShoppingList>>
    suspend fun addShoppingList(shoppingList: ShoppingList): Long
    fun deleteShoppingList(shoppingList: ShoppingList)
}

