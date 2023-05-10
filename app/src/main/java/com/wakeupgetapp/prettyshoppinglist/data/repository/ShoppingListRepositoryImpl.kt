package com.wakeupgetapp.prettyshoppinglist.data.repository

import com.wakeupgetapp.prettyshoppinglist.data.local.datasource.ShoppingListDataSource
import com.wakeupgetapp.prettyshoppinglist.data.mapper.*
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListCategory
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShoppingListRepositoryImpl @Inject constructor(
    private val localShoppingListDataSource: ShoppingListDataSource
) : ShoppingListRepository {
    override fun getShoppingLists(): Flow<List<ShoppingList>> =
        localShoppingListDataSource.getShoppingLists().map { it -> it.map { it.toShoppingList() } }

    override fun getShoppingList(id: Long): Flow<ShoppingList> =
        localShoppingListDataSource.getShoppingList(id).map { it.toShoppingList() }

    override suspend fun addShoppingList(shoppingList: ShoppingList): Long =
        localShoppingListDataSource.addShoppingList(shoppingList.toShoppingListEntity())


    override suspend fun addShoppingListCategory(shoppingListCategory: ShoppingListCategory): Long =
        localShoppingListDataSource.addShoppingListCategory(shoppingListCategory.toShoppingListCategoryEntity())


    override suspend fun addShoppingListEntry(shoppingListEntry: ShoppingListEntry): Long =
        localShoppingListDataSource.addShoppingListEntry(shoppingListEntry.toShoppingListEntryEntity())


    override fun deleteShoppingList(shoppingList: ShoppingList) {
        localShoppingListDataSource.deleteShoppingList(shoppingList.toShoppingListEntity())
    }

    override suspend fun updateShoppingList(shoppingList: ShoppingList) {
        localShoppingListDataSource.updateShoppingList(shoppingList.toShoppingListEntity())
    }

}