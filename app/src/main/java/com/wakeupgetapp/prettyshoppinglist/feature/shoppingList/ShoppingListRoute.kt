package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.wakeupgetapp.prettyshoppinglist.component.loading.LoadingScreen
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui.ShoppingListScreen
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui.ShoppingListState.*
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui.ShoppingListViewModel

@Composable
fun ShoppingListRoute(
    navController: NavHostController,
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    
    val shoppingListState by viewModel.shoppingListState.collectAsStateWithLifecycle()
    val updateShoppingListTitle = { it: String -> viewModel.updateShoppingListTitle(it) }

    when (shoppingListState) {
        Loading -> LoadingScreen()
        is Success -> ShoppingListScreen(
                shoppingList = (shoppingListState as Success).shoppingList,
            updateShoppingListTitle = { updateShoppingListTitle(it) }
        )
    }
    
}