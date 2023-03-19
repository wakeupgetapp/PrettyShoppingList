package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wakeupgetapp.prettyshoppinglist.component.textField.ShoppingListTitleTextField
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntry
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingListEntryState

@Composable
fun ShoppingListScreen(
    shoppingListState: ShoppingListState,
    updateShoppingListTitle: (String) -> Unit,
    updateShoppingListDate: (String) -> Unit,
    addNewEntry: (String, String) -> Unit
) {
    if (shoppingListState is ShoppingListState.Success) {
        ShoppingListColumn(
            shoppingList = shoppingListState.shoppingList,
            updateShoppingListTitle = updateShoppingListTitle,
            updateShoppingListDate = updateShoppingListDate,
            addNewEntry = addNewEntry
        )
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

}


//@Composable
//fun ShoppingListColumn(
//    shoppingList: ShoppingList,
//    updateShoppingListTitle: (String) -> Unit,
//    updateShoppingListDate: (String) -> Unit,
//    addNewEntry: (String, String) -> Unit
//) {
//    Column(modifier = Modifier.fillMaxSize()) {
//        ShoppingListTitleTextField(
//            text = shoppingList.title,
//            onValueChange = updateShoppingListTitle
//        )
//        Text(text = shoppingList.date)
//        shoppingList.entriesList.forEach {
//            Row(
//                Modifier
//                    .fillMaxWidth()
//                    .height(54.dp)) {
//                Text(text = )
//            }
//        }
//    }
//
//}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingListColumn(
    shoppingList: ShoppingList,
    updateShoppingListTitle: (String) -> Unit,
    updateShoppingListDate: (String) -> Unit,
    addNewEntry: (String, String) -> Unit
){
    val categorizedEntries = shoppingList.entriesList.groupBy { it.category }

            LazyColumn {
                categorizedEntries.forEach { (category, entries) ->
                    stickyHeader {
                        Text(
                            text = category,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.secondary)
                                .padding(16.dp)
                        )
                    }
                    items(entries) { entry ->
                        ShoppingListEntryRow(entry = entry)
                    }

                }
            }
}


@Composable
fun ShoppingListEntryRow(entry: ShoppingListEntry) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = entry.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f)
        )
        when (entry.state) {
            ShoppingListEntryState.INITIAL -> Text(text = "To buy")
            ShoppingListEntryState.DURING -> Text(text = "In progress")
            ShoppingListEntryState.DONE -> Text(text = "Done")
        }
    }
}
