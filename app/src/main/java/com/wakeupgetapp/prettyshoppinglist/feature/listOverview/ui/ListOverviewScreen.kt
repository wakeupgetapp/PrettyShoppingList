package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wakeupgetapp.prettyshoppinglist.R
import com.wakeupgetapp.prettyshoppinglist.component.clickable.ListOverviewItem
import com.wakeupgetapp.prettyshoppinglist.component.text.TextTitle
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Dimens.paddingMedium

@Composable
fun ListOverviewScreen(
    shoppingList: List<ShoppingList>,
    onShoppingListItemClick: (Long) -> Unit,
    onAddNewClick: () -> Unit
) {
    Scaffold(modifier = Modifier.padding(paddingMedium),
        topBar = { ListOverviewTopBar() },
        floatingActionButton = { FloatingActionButton(onClick = { onAddNewClick() }) {
        } }
    ) { paddings->

        LazyColumn(modifier = Modifier.padding(paddings)) {
            items(shoppingList){
                ListOverviewItem(it, onShoppingListItemClick)
            }
        }

    }
}

@Composable
private fun ListOverviewTopBar(){
    TextTitle(text = stringResource(id = R.string.shopping_list_overview_title))
}