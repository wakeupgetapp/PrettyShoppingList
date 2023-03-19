package com.wakeupgetapp.prettyshoppinglist.component.clickable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wakeupgetapp.prettyshoppinglist.component.text.TextSubtitle
import com.wakeupgetapp.prettyshoppinglist.component.text.TextTitle
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Dimens.paddingSmall

@Composable
fun ListOverviewItem(shoppingList: ShoppingList, onClick: (Long) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingSmall)
            .clickable { onClick(shoppingList.id) }
    ) {
        TextTitle(text = shoppingList.title)
        TextSubtitle(text = shoppingList.date)
    }
}