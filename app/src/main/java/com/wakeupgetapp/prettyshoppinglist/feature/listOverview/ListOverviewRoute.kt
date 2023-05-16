package com.wakeupgetapp.prettyshoppinglist.feature.listOverview

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wakeupgetapp.prettyshoppinglist.component.loading.LoadingScreen
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui.ListOverviewScreen
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui.ListOverviewState.*
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui.ListOverviewViewModel
import com.wakeupgetapp.prettyshoppinglist.navigation.PslScreens
import timber.log.Timber
import java.time.LocalDate

@Composable
fun ListOverviewRoute(
    navController: NavHostController,
    viewModel: ListOverviewViewModel = hiltViewModel()
) {
    val listOverviewState by viewModel.listOverviewState.collectAsStateWithLifecycle()
    val chosenListId by viewModel.chosenListId.collectAsStateWithLifecycle(initialValue = -1L)

    Log.e("CHOSEN LIST ID", chosenListId.toString())

    LaunchedEffect(key1 = chosenListId){
        if (chosenListId != -1L){
            navController.navigate("${PslScreens.ShoppingList.route}/$chosenListId")
            viewModel.setChosenListId(-1L)
        }
    }

    when (listOverviewState) {
        Loading -> LoadingScreen()
        is Success ->
            ListOverviewScreen(
                shoppingList = (listOverviewState as Success).list,
                onShoppingListItemClick = { id -> viewModel.setChosenListId(id) },
                onAddNewClick = { name: String, date: LocalDate -> viewModel.createNewShoppingList(name, date) }
            )
    }

}