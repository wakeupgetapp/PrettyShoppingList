package com.wakeupgetapp.prettyshoppinglist.data.repository

import com.wakeupgetapp.prettyshoppinglist.data.local.datasource.ShoppingListDataSource
import com.wakeupgetapp.prettyshoppinglist.data.mapper.toDomainModel
import com.wakeupgetapp.prettyshoppinglist.data.mapper.toShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.mapper.toShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShoppingListRepositoryImpl @Inject constructor(
    private val localShoppingListDataSource: ShoppingListDataSource
) : ShoppingListRepository {
    override fun getShoppingLists(): Flow<List<ShoppingList>> = localShoppingListDataSource.getShoppingLists().map { it -> it.map { it.toDomainModel() } }
    override fun getShoppingList(id: Long): Flow<ShoppingList> = localShoppingListDataSource.getShoppingList(id)
        .map { it.toShoppingList() }

    override suspend fun addShoppingList(shoppingList: ShoppingList): Long {
        return localShoppingListDataSource.addShoppingList(shoppingList.toShoppingListEntity())
    }

    override fun deleteShoppingList(shoppingList: ShoppingList) {
        localShoppingListDataSource.deleteShoppingList(shoppingList.toShoppingListEntity())
    }

    override suspend fun updateShoppingList(shoppingList: ShoppingList) {
        localShoppingListDataSource.updateShoppingList(shoppingList.toShoppingListEntity())
    }

}