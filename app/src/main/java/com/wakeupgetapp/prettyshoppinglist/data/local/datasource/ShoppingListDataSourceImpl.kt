package com.wakeupgetapp.prettyshoppinglist.data.local.datasource

import com.wakeupgetapp.prettyshoppinglist.data.local.dao.ShoppingListDao
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListCategoryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntryEntity
import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListWithCategoriesAndEntries
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShoppingListDataSourceImpl @Inject constructor(
    private val shoppingListDao: ShoppingListDao
) : ShoppingListDataSource {
    override fun getShoppingLists(): Flow<List<ShoppingListEntity>> = shoppingListDao.getShoppingLists()

    override suspend fun addShoppingList(shoppingList: ShoppingListEntity): Long {
        return shoppingListDao.insertShoppingList(shoppingList)
    }

    override suspend fun addShoppingListCategory(shoppingListCategoryEntity: ShoppingListCategoryEntity): Long {
        return shoppingListDao.insertShoppingListCategory(shoppingListCategoryEntity)
    }

    override suspend fun addShoppingListEntry(shoppingListEntryEntity: ShoppingListEntryEntity): Long {
        return shoppingListDao.insertShoppingListEntry(shoppingListEntryEntity)
    }

    override fun getShoppingList(id: Long): Flow<ShoppingListWithCategoriesAndEntries> {
        return shoppingListDao.getShoppingListById(id)
    }

    override fun deleteShoppingList(shoppingList: ShoppingListEntity) {
        shoppingListDao.deleteShoppingList(shoppingList)
    }

    override suspend fun updateShoppingList(shoppingList: ShoppingListEntity) {
        shoppingListDao.updateShoppingList(shoppingList)
    }


}