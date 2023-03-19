package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui

import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList

sealed interface ListOverviewState {

    object Loading: ListOverviewState
    data class Success(val list: List<ShoppingList> = emptyList()): ListOverviewState

}
