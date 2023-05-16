package com.wakeupgetapp.prettyshoppinglist.component.clickable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wakeupgetapp.prettyshoppinglist.R
import com.wakeupgetapp.prettyshoppinglist.data.model.ShoppingList
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Dimens.paddingSmall
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Typography

@Composable
fun ListOverviewItem(shoppingList: ShoppingList, onClick: (Long) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(shoppingList.id) }
            .padding(paddingSmall)
    ) {
        Text(
            text = shoppingList.title.ifBlank { stringResource(id = R.string.no_title) },
            style = Typography.titleMedium,
        )
        Text(
            text = shoppingList.date.toString().ifBlank { stringResource(id = R.string.no_date) },
            style = Typography.titleSmall,
        )

    }
}