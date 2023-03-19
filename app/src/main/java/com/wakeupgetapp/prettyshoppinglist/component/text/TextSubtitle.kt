package com.wakeupgetapp.prettyshoppinglist.component.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Typography

@Composable
fun TextSubtitle(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        style = Typography.subtitle2,
    )
}