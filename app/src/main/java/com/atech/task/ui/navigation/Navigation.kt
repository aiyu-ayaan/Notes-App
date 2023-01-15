package com.atech.task.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atech.task.ui.screens.home_screen.components.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(
            route = Screen.HomeScreen.route,
        ) {
            HomeScreen()
        }
    }
}


sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object AddTaskScreen : Screen("add_task_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {args ->
                append("/${args}")
            }
        }
    }
}