package com.wakeupgetapp.prettyshoppinglist.component.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wakeupgetapp.prettyshoppinglist.R
import com.wakeupgetapp.prettyshoppinglist.ui.theme.Typography

@Composable
fun ShoppingListTitleTextField(text: String, onValueChange: (String) -> Unit) {


    TextField(
        value = text,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        placeholder = {
            Text(
                text = stringResource(id = R.string.enter_list_title),
                style = Typography.h1
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(0.dp)
    )

}

@Preview
@Composable
private fun ShoppingListTitleTextField() {
    Column(modifier = Modifier.background(Color.White)) {
        ShoppingListTitleTextField(text = "randomText", onValueChange = {})
    }

}