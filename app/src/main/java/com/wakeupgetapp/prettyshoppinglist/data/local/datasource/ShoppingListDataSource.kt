package com.wakeupgetapp.prettyshoppinglist.data.local.datasource

import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithEntries
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import kotlinx.coroutines.flow.Flow

interface ShoppingListDataSource {
    fun getShoppingLists(): Flow<List<ShoppingListWithEntries>>
    fun getShoppingList(id: Long): Flow<ShoppingListEntity>
    suspend fun addShoppingList(shoppingList: ShoppingListEntity): Long
    fun deleteShoppingList(shoppingList: ShoppingListEntity)

    suspend fun updateShoppingList(shoppingList: ShoppingListEntity)
}