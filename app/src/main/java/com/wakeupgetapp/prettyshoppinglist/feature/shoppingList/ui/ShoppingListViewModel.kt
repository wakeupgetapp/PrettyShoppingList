package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.domain.FetchShoppingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    fetchShoppingListUseCase: FetchShoppingListUseCase,
    private val repository: ShoppingListRepository
) : ViewModel() {

    private val shoppingListId: Long = checkNotNull(savedStateHandle["listId"])

    val shoppingListState: StateFlow<ShoppingListState> = fetchShoppingListUseCase(shoppingListId)
        .map<ShoppingList, ShoppingListState>(ShoppingListState::Success)
        .onStart { emit(ShoppingListState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = ShoppingListState.Loading,
        )

    private val updateShoppingListMutex = Mutex()

    fun updateShoppingListTitle(title: String) {
        viewModelScope.launch {
            val shoppingList = shoppingListState.value as? ShoppingListState.Success ?: return@launch
            val newShoppingList = shoppingList.shoppingList.copy(title = title)

            updateShoppingListMutex.withLock {
                repository.updateShoppingList(newShoppingList)
            }
        }
    }


    fun updateShoppingListDate(date: String) {
        viewModelScope.launch {
            if (shoppingListState.value is ShoppingListState.Success) {
                val newShoppingList =
                    (shoppingListState.value as ShoppingListState.Success).shoppingList.copy(date = date)
                repository.updateShoppingList(newShoppingList)
            }
        }
    }


}