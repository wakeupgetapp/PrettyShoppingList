package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.domain

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchShoppingListUseCase @Inject constructor(
    private val repository: ShoppingListRepository
): (Long) -> Flow<ShoppingList> {

    override fun invoke(id: Long): Flow<ShoppingList> {
        return repository.getShoppingList(id)
    }

}