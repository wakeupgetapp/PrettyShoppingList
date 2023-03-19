package com.wakeupgetapp.prettyshoppinglist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wakeupgetapp.prettyshoppinglist.navigation.navGraph.shoppingListNavGraph

@Composable
fun PslNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutes.SHOPPING_LIST
) {
    NavHost(navController = navController, startDestination = startDestination, route = NavRoutes.ROOT){
        shoppingListNavGraph(navController = navController)
    }
}