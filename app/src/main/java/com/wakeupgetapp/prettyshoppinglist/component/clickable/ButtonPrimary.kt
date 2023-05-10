package com.wakeupgetapp.prettyshoppinglist.component.clickable


import androidx.compose.material3.Button
import androidx.compose.material3.Text
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