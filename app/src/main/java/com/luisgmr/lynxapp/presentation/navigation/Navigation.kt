package com.luisgmr.lynxapp.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
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
        composable(Screen.Menu) { MenuScreen(navController) }
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
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        content = content
    )
}