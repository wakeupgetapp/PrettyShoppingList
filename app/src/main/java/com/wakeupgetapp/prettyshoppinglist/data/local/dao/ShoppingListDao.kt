package com.wakeupgetapp.prettyshoppinglist.data.local.dao

import androidx.room.*
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListCategoryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithCategories
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

    @Transaction
    @Query("SELECT id, date, title FROM ShoppingListEntity")
    fun getShoppingListHeadings(): Flow<List<ShoppingListEntity>>

    @Query("SELECT * FROM ShoppingListEntity WHERE id=:id")
    fun getShoppingListById(id: Long): Flow<ShoppingListEntity>

    @Delete
    fun deleteShoppingList(shoppingList: ShoppingListEntity)

    @Update
    suspend fun updateShoppingList(shoppingList: ShoppingListEntity)
}