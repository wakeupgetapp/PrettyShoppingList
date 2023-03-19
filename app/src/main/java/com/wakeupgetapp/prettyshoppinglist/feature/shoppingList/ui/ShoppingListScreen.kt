package com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wakeupgetapp.prettyshoppinglist.component.textField.ShoppingListTitleTextField
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList

@Composable
fun ShoppingListScreen(shoppingList: ShoppingList, updateShoppingListTitle: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        ShoppingListTitleTextField(
            text = shoppingList.title,
            onValueChange = updateShoppingListTitle
        )
    }
}