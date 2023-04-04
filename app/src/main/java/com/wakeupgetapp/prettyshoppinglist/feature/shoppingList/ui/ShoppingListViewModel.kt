package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntry
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntryState
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


    fun updateShoppingListTitle(title: String) =
        viewModelScope.launch {
            (shoppingListState.value as? ShoppingListState.Success)?.let { shoppingListState ->
                repository.updateShoppingList(shoppingListState.shoppingList.copy(title = title))
            }
        }


    fun updateShoppingListDate(date: String) =
        viewModelScope.launch {
            (shoppingListState.value as? ShoppingListState.Success)?.let { shoppingListState ->
                repository.updateShoppingList(shoppingListState.shoppingList.copy(date = date))
            }
        }


    fun addNewEntry(name: String, category: Long) =
        viewModelScope.launch {
            repository.addShoppingListEntry(
                ShoppingListEntry(
                    name = name,
                    state = ShoppingListEntryState.INITIAL,
                    shoppingListCategoryId = category
                )
            )
        }
}