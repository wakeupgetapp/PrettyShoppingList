package com.wakeupgetapp.prettyshoppinglist.component.shoppingList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import java.util.Date

@Composable
fun ShoppingList(list: ShoppingList){
    Column {
        ShoppingListTopBar(list.title, list.date)
        //CategoryList()
    }
}

@Composable
fun ColumnScope.ShoppingListTopBar(title: String, date: String){
    Text(text = "title")
    Text(text = "date")
}

//@Composable
//fun CategoryList()