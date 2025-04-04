package com.luisgmr.lynxapp.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luisgmr.lynxapp.presentation.ui.menu.MenuScreen
import com.luisgmr.lynxapp.presentation.ui.students.StudentsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Menu.route
    ) {
        // Menu
        composable(Screen.Menu) { MenuScreen(navController) }

        // Students
        composable(Screen.Students) { StudentsScreen(navController) }

        // Subjects
//        composable(Screen.Subjects) { SubjectsScreen(navController) }

//        // Student Form
//        composable(Screen.StudentEdit) { backStackEntry ->
//            val id = backStackEntry.arguments?.getString("id") ?: "new"
//            StudentEditScreen(
//                id = id,
//                navController = navController
//            )
//        }
    }
}

private fun NavGraphBuilder.composable(
    screen: Screen,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = screen.route,
        arguments = screen.navArgs,
        content = content
    )
}