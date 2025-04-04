package com.luisgmr.lynxapp.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArgs: List<NamedNavArgument> = emptyList()
) {
    data object Menu : Screen("menu")
    data object Students : Screen("students")
    data object Subjects : Screen("subjects")

    data object StudentEdit : Screen(
        route = "student_edit?id={id}",
        navArgs = listOf(
            navArgument("id") {
                type = NavType.StringType
                defaultValue = "new"
            }
        )
    ) {
        fun createRoute(id: String) = "student_edit?id=$id"
    }

    data object SubjectEdit : Screen(
        route = "subject_edit?id={id}",
        navArgs = listOf(
            navArgument("id") {
                type = NavType.StringType
                defaultValue = "new"
            }
        )
    ) {
        fun createRoute(id: String) = "subject_edit?id=$id"
    }
}