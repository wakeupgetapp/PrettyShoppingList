package com.wakeupgetapp.prettyshoppinglist.navigation

sealed class PslScreens(val route: String) {
    object ListOverview: PslScreens("listOverview")
    object ShoppingList: PslScreens("ShoppingList")

}