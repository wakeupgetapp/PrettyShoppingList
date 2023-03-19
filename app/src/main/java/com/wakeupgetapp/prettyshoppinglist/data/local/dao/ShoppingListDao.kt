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

    @Query("SELECT * FROM ShoppingListEntity WHERE id=:id")
    fun getShoppingListById(id: Long): Flow<ShoppingListEntity>

    @Delete
    fun deleteShoppingList(shoppingList: ShoppingListEntity)

    @Update
    suspend fun updateShoppingList(shoppingList: ShoppingListEntity)
}