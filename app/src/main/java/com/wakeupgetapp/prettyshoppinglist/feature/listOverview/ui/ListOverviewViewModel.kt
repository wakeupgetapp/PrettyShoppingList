package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.repository.ShoppingListRepository
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain.CreateNewShoppingListUseCase
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.domain.FetchListOfShoppingListsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class ListOverviewViewModel @Inject constructor(
    fetchListOfShoppingListsUseCase: FetchListOfShoppingListsUseCase,
    private val createNewShoppingListUseCase: CreateNewShoppingListUseCase
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
        Timber.tag("chosen val").e(value.toString())
        viewModelScope.launch {
            _chosenListId.emit(value)
        }
    }


    fun createNewShoppingList() {
        viewModelScope.launch {
            val newListId = createNewShoppingListUseCase()
            setChosenListId(newListId)
        }
    }


}