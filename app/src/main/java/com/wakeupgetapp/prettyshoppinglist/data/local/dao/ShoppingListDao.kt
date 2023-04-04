package com.wakeupgetapp.prettyshoppinglist.data.local.dao

import androidx.room.*
import com.wakeupgetapp.prettyshoppinglist.data.local.model.*
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import kotlinx.coroutines.flow.Flow


@Dao
interface ShoppingListDao {

    @Transaction
    @Insert
    suspend fun insertShoppingList(shoppingList: ShoppingListEntity): Long

    @Transaction
    @Insert
    suspend fun insertShoppingListCategory(category: ShoppingListCategoryEntity): Long

    @Transaction
    @Insert
    suspend fun insertShoppingListEntry(entry: ShoppingListEntryEntity): Long

    @Transaction
    @Query("SELECT * FROM ShoppingListEntity")
    fun getShoppingLists(): Flow<List<ShoppingListEntity>>

    @Query("SELECT * FROM ShoppingListEntity WHERE id=:id")
    fun getShoppingListById(id: Long): Flow<ShoppingListWithCategoriesAndEntries>

    @Delete
    fun deleteShoppingList(shoppingList: ShoppingListEntity)

    @Update
    suspend fun updateShoppingList(shoppingList: ShoppingListEntity)
}