package com.luisgmr.lynxapp.presentation.ui.students

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.presentation.components.LynxScaffold
import com.luisgmr.lynxapp.presentation.navigation.Screen

@Preview(showBackground = true)
@Composable
fun StudentsScreen(
    navController: NavController = rememberNavController()
) {
    LynxScaffold(
        title = stringResource(R.string.students),
        navController = navController
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Button(
            onClick = { navController.navigate(Screen.Students.route) },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(text = stringResource(R.string.students))
        }
    }
}