package com.wakeupgetapp.prettyshoppinglist.navigation.navGraph

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.wakeupgetapp.prettyshoppinglist.feature.listOverview.ListOverviewRoute
import com.wakeupgetapp.prettyshoppinglist.feature.shoppingList.ShoppingListRoute
import com.wakeupgetapp.prettyshoppinglist.navigation.NavRoutes
import com.wakeupgetapp.prettyshoppinglist.navigation.PslScreens
import timber.log.Timber

fun NavGraphBuilder.shoppingListNavGraph(navController: NavController) {

    navigation(startDestination = PslScreens.ListOverview.route, route = NavRoutes.SHOPPING_LIST) {
        composable(route = PslScreens.ListOverview.route) {
            ListOverviewRoute(navController = navController as NavHostController)
        }

        composable(route = "${PslScreens.ShoppingList.route}/{listId}",
            arguments = listOf(navArgument("listId") { type = NavType.LongType })) {
            Timber.e("navigation")
            ShoppingListRoute(navController = navController as NavHostController)
        }
    }
}