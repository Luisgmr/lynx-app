package com.luisgmr.lynxapp.presentation.ui.students

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.presentation.components.LynxScaffold

@Composable
fun StudentsFormScreen(
    navController: NavController,
    viewModel: StudentFormViewModel = hiltViewModel()
) {
    LynxScaffold(
        title = stringResource(R.string.students),
        navController = navController
    ) {
        val subtitle = if (viewModel.isEditMode) {
            stringResource(R.string.edit_student)
        } else {
            stringResource(R.string.new_student)
        }
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = MaterialTheme.shapes.small)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = viewModel.name,
                onValueChange = { viewModel.onNameChange(it) },
                label = { Text(stringResource(R.string.student_name_input_hint)) },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small
            )

            Column(
                modifier = Modifier.padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.select_subjects),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                viewModel.allSubjects.forEach { subject ->
                    val isChecked = subject in viewModel.selectedSubjects

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.small)
                            .clickable (
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(
                                    bounded = true,
                                ),
                                onClick = {
                                    viewModel.toggleSubject(subject)
                                }
                            )
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = null,
                        )
                        Text(subject.name)
                    }
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                onClick = {
                    viewModel.save()
                    navController.popBackStack()
                }
            ) {
                Text(
                    text = if (viewModel.isEditMode)
                        stringResource(R.string.student_button_edit)
                    else
                        stringResource(R.string.student_button_new)
                )
            }

        }
    }
}
