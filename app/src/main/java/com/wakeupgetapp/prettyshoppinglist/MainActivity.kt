package com.wakeupgetapp.prettyshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wakeupgetapp.prettyshoppinglist.ui.theme.PrettyShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrettyShoppingListTheme {
                PslApp()
            }
        }
    }
}
