package com.luisgmr.lynxapp.presentation.ui.subjects

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.Fill
import com.adamglin.phosphoricons.bold.Plus
import com.adamglin.phosphoricons.bold.BookBookmark
import com.adamglin.phosphoricons.fill.Trash
import com.adamglin.phosphoricons.fill.PencilSimple
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.data.model.Subject
import com.luisgmr.lynxapp.presentation.components.LynxScaffold

@Composable
fun SubjectsScreen(
    navController: NavController,
    viewModel: SubjectsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadSubjects()
    }

    val subjects by viewModel.subjects.collectAsState()

    LynxScaffold(
        title = stringResource(R.string.subjects),
        navController = navController,
        floatingButton = {
            Row(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(
                            bounded = true,
                        ),
                        onClick = {
                            viewModel.goToSubjectForm(navController, "new")
                        }
                    )
                    .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                    .padding(24.dp),
            ) {
                Icon(
                    PhosphorIcons.Bold.Plus,
                    contentDescription = stringResource(R.string.new_subject),
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) {
        Text(
            if (subjects.isEmpty()) {
                stringResource(R.string.no_subjects)
            } else {
                stringResource(R.string.all_subjects)
            },
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            subjects.forEach { subject ->
                SubjectComponent(
                    subject = subject,
                    onEdit = {
                         viewModel.goToSubjectForm(navController, subject.id)
                    },
                    onDelete = {
                        viewModel.deleteSubject(subject)
                    }
                )
            }
        }
    }
}

@Composable
fun SubjectComponent(
    subject: Subject,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = PhosphorIcons.Bold.BookBookmark,
                contentDescription = null
            )
            Spacer(Modifier.size(4.dp))

            Text(
                text = subject.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(
                            bounded = true,
                        ),
                        onClick = { onEdit() }
                    )
                    .background(
                        color = Color(0x73D7D7D7),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = PhosphorIcons.Fill.PencilSimple,
                    contentDescription = null,
                    tint = Color(0xFF2B2B2B),
                )
            }
            Row(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(
                            bounded = true,
                        ),
                        onClick = { showDeleteDialog = true }
                    )
                    .background(
                        color = Color(0xD9F3BDBD),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = PhosphorIcons.Fill.Trash,
                    contentDescription = null,
                    tint = Color(0xFFA92525),
                )
            }
        }
    }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text(stringResource(R.string.delete_subject)) },
            text = { Text(stringResource(R.string.confirm_delete_subject)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete()
                        showDeleteDialog = false
                    }
                ) {
                    Text(stringResource(R.string.positive_option))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text(stringResource(R.string.negative_option))
                }
            }
        )
    }
}

