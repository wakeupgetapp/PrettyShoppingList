package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain

import com.wakeupgetapp.prettyshoppinglist.data.local.model.ShoppingListEntity
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchShoppingListUseCase @Inject constructor(
    private val shoppingListRepository: ShoppingListRepository
): ()-> Flow<List<ShoppingList>> {
    override fun invoke(): Flow<List<ShoppingList>> {
        return shoppingListRepository.getShoppingLists()
    }
}