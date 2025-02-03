package com.example.sampleapplicaiton.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Popup
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sampleapplicaiton.presentation.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(onClick = {
                navController.navigate(Screen.HomeScreen.route) {
                    popUpTo(Screen.LoginScreen.route) {
                        inclusive = true
                    }
                }
            })
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(onClick = {
                navController.navigate(Screen.DetailScreen.route + "/$it")
            })
        }

        composable(route = Screen.DetailScreen.route + "/{name}", arguments = listOf(
            navArgument("name") { type = NavType.StringType }
        )) { backStackEntry ->
            DetailScreen(name = backStackEntry.arguments?.getString("name"))
        }
    }
}