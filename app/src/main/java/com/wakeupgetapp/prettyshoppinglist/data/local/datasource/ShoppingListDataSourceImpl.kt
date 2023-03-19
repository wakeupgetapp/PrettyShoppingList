package com.wakeupgetapp.prettyshoppinglist.data.local.datasource

import com.wakeupgetapp.prettyshoppinglist.data.local.dao.ShoppingListDao
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithEntries
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShoppingListDataSourceImpl @Inject constructor(
    private val shoppingListDao: ShoppingListDao
) : ShoppingListDataSource {
        override fun getShoppingLists(): Flow<List<ShoppingListWithEntries>> = shoppingListDao.getShoppingLists()

    override suspend fun addShoppingList(shoppingList: ShoppingListEntity): Long {
        return shoppingListDao.insertShoppingList(shoppingList)
    }

    override fun deleteShoppingList(shoppingList: ShoppingListEntity) {
        shoppingListDao.deleteShoppingList(shoppingList)
    }

}