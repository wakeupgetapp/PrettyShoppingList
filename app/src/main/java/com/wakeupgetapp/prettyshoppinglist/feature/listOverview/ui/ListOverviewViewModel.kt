package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain.FetchListOfShoppingListsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListOverviewViewModel @Inject constructor(
    fetchListOfShoppingListsUseCase: FetchListOfShoppingListsUseCase,
    private val repository: ShoppingListRepository
) : ViewModel() {

    val listOverviewState: StateFlow<ListOverviewState> = fetchListOfShoppingListsUseCase()
        .map<List<ShoppingList>, ListOverviewState>(ListOverviewState::Success)
        .onStart { emit(ListOverviewState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = ListOverviewState.Loading,
        )

    private val _chosenListId = MutableStateFlow(-1L)
    val chosenListId: SharedFlow<Long>
        get() = _chosenListId.asSharedFlow()

    fun setChosenListId(value: Long) {
        viewModelScope.launch {
            _chosenListId.emit(value)
        }
    }


    fun createNewShoppingList() {
        viewModelScope.launch {
            val newListId = repository.addShoppingList(ShoppingList())
            setChosenListId(newListId)
        }
    }



//    suspend fun setListEntryStateInitial(shoppingListEntry: ShoppingListEntry){
//        repository.updateShoppingListEntryState(shoppingListEntry.id, ShoppingListEntryState.INITIAL)
//    }
//
//    suspend fun setListEntryStateDone(shoppingListEntry: ShoppingListEntry){
//        repository.updateShoppingListEntryState(shoppingListEntry.id, ShoppingListEntryState.DURING)
//        delay(3000)
//        if (shoppingListEntry.state != ShoppingListEntryState.INITIAL){
//            shoppingListEntry.updateShoppingListEntryState(shoppingListEntry, ShoppingListEntryState.DONE)
//        }
//    }
//
//    suspend fun updateListEntry(shoppingListEntry: ShoppingListEntry){
//        if(state == ShoppingListEntryState.INITIAL){
//            repository.updateShoppingListEntryState(shoppingListEntry.id, state)
//        }
//        else if (state == ShoppingListEntryState.DURING){
//
//        }
//    }
}