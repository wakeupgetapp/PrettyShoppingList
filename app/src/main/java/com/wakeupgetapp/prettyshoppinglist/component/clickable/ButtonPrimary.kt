package com.wakeupgetapp.prettyshoppinglist.component.clickable

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonPrimary(
    text: String,
    onClick: ()-> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(modifier = modifier,
        enabled = enabled,
        onClick = { onClick() }) {
        Text(text = text)
    }
}