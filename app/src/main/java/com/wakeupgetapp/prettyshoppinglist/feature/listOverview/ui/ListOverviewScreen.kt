package com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wakeupgetapp.prettyshoppinglist.R
import com.wakeupgetapp.prettyshoppinglist.component.clickable.ListOverviewItem
import com.wakeupgetapp.prettyshoppinglist.component.dialog.AddShoppingListDialog
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Dimens
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Dimens.paddingMedium
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Dimens.paddingSmall
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Typography
import java.time.LocalDate

@Composable
fun ListOverviewScreen(
    shoppingList: List<ShoppingList>,
    onShoppingListItemClick: (Long) -> Unit,
    onAddNewClick: (String, LocalDate) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        AddShoppingListDialog(
            onAddShoppingList = { title, date ->
                onAddNewClick(title, date)
            },
            onDismiss = { showDialog = false }
        )
    }

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(paddingMedium),
        topBar = { ListOverviewTopBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_new_shopping_list),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },

        ) { paddings ->

        LazyColumn(modifier = Modifier.padding(paddings)) {
            itemsIndexed(shoppingList) { index, item ->
                ListOverviewItem(item, onShoppingListItemClick)
                if (index != shoppingList.lastIndex) {
                    Divider(
                        Modifier,
                        thickness = Dimens.dividerSmall,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }

        }

    }
}

@Composable
private fun ListOverviewTopBar() {
    Column(Modifier.padding(top = paddingSmall, bottom = paddingSmall)) {
        Text(
            text = stringResource(id = R.string.shopping_list_overview_title),
            style = Typography.titleLarge,
        )
    }

}