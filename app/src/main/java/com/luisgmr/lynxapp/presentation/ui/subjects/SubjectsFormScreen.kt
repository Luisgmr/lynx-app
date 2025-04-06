package com.luisgmr.lynxapp.presentation.ui.subjects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.presentation.components.LynxScaffold

@Composable
fun SubjectsFormScreen(
    navController: NavController,
    viewModel: SubjectFormViewModel = hiltViewModel()
) {
    LynxScaffold(
        title = stringResource(R.string.subjects),
        navController = navController
    ) {
        val subtitle =
            if (viewModel.isEditMode)
                stringResource(R.string.edit_subject)
            else
                stringResource(R.string.new_subject)
        Text(
            subtitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = viewModel.name,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text(stringResource(R.string.subject_name_input_hint)) },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small

            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                onClick = {
                    viewModel.save()
                    navController.popBackStack()
                }
            ) {
                Text(
                    if (viewModel.isEditMode)
                        stringResource(R.string.subject_button_edit)
                    else
                        stringResource(R.string.subject_button_new)
                )
            }
        }
    }
}
