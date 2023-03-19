package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain.FetchShoppingListUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ShoppingListViewModel @Inject constructor(
  //  fetchOrCreateShoppingListUseCase: FetchOrCreateShoppingListUseCase
): ViewModel() {
    
//    val ShoppingListState: StateFlow<ShoppingListState> = fetchOrCreateShoppingListUseCase()
//        .map<ShoppingList, ShoppingListState>(ShoppingListState::Success)
//        .onStart { emit(ShoppingListState.Loading) }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.Eagerly,
//            initialValue = ShoppingListState.Loading,
//        )

}