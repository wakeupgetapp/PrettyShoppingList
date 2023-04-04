package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListCategory
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import javax.inject.Inject

class CreateNewShoppingListUseCase @Inject constructor(
    private val repository: ShoppingListRepository
): suspend () -> Long {
    override suspend fun invoke(): Long {
        val shoppingListId = repository.addShoppingList(ShoppingList())
        repository.addShoppingListCategory(ShoppingListCategory(shoppingListId = shoppingListId))
        return shoppingListId
    }
}