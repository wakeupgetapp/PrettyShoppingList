package com.wakeupgetapp.prettyshoppinglist.data.local.dao

import androidx.room.*
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithEntries
import kotlinx.coroutines.flow.Flow


@Dao
interface ShoppingListDao {

    @Transaction
    @Insert
    suspend fun insertShoppingList(shoppingList: ShoppingListEntity): Long


    @Transaction
    @Query("SELECT * FROM ShoppingListEntity")
    fun getShoppingLists(): Flow<List<ShoppingListWithEntries>>

    @Delete
    fun deleteShoppingList(shoppingList: ShoppingListEntity)
}