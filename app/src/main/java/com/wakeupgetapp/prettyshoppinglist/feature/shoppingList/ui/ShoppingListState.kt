package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui.ListOverviewState

interface ShoppingListState {

    object Loading: ShoppingListState
    data class Success(val list: ShoppingList): ShoppingListState

}