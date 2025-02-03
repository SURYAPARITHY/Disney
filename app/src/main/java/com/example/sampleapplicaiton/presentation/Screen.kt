package com.example.sampleapplicaiton.presentation


sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
}