package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui.ShoppingListScreen
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui.ShoppingListViewModel

@Composable
fun ShoppingListRoute(
    navController: NavHostController,
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    
    val shoppingListState by viewModel.shoppingListState.collectAsStateWithLifecycle()

    ShoppingListScreen(
        shoppingListState = shoppingListState,
        updateShoppingListTitle = viewModel::updateShoppingListTitle,
        updateShoppingListDate = viewModel::updateShoppingListDate,
        addNewEntry = viewModel::addNewEntry,
        addNewCategory = viewModel::addNewCategory
    )

    
}