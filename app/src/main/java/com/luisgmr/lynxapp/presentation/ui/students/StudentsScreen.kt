package com.luisgmr.lynxapp.presentation.ui.students

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.Fill
import com.adamglin.phosphoricons.Regular
import com.adamglin.phosphoricons.bold.Plus
import com.adamglin.phosphoricons.bold.Student
import com.adamglin.phosphoricons.fill.PencilSimple
import com.adamglin.phosphoricons.fill.Trash
import com.adamglin.phosphoricons.regular.ArrowBendDownRight
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.data.model.Student
import com.luisgmr.lynxapp.presentation.components.LynxScaffold
import com.luisgmr.lynxapp.presentation.theme.LynxAppTheme

@Preview(showBackground = true)
@Composable
fun StudentsScreenPreview() {
    StudentsScreen(rememberNavController())
}

@Composable
fun StudentsScreen(
    navController: NavController,
    viewModel: StudentsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadStudents()
    }
    LynxAppTheme {
        val students by viewModel.students.collectAsState()

        LynxScaffold(
            title = stringResource(R.string.students),
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
                                viewModel.goToStudentForm(navController, "new")
                            }
                        )
                        .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                        .padding(24.dp),
                ) {
                    Icon(
                        PhosphorIcons.Bold.Plus,
                        stringResource(R.string.icon),
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        ) {
            Text(
                if (students.isEmpty()) {
                    stringResource(R.string.no_students)
                } else {
                    stringResource(R.string.all_students)
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                students.forEach { student ->
                    StudentComponent(
                        student = student,
                        onEdit = {
                            viewModel.goToStudentForm(navController, student.id)
                        },
                        onDelete = {
                            viewModel.deleteStudent(student)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun StudentComponent(
    student: Student,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    val context = LocalContext.current
    var showDeleteDialog by remember { mutableStateOf(false) }
    val subjectCount = student.subjects.size
    val subjectStr = context.resources.getQuantityString(
        R.plurals.student_subject_count,
        subjectCount,
        subjectCount
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .padding(horizontal = 8.dp, vertical = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = PhosphorIcons.Bold.Student,
                    contentDescription = null
                )
                Spacer(Modifier.size(4.dp))
                Text(
                    text = student.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
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

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(PhosphorIcons.Regular.ArrowBendDownRight, contentDescription = null, tint = Color.LightGray)
            Text(
                subjectStr,
                color = Color.LightGray
            )
        }

        if (showDeleteDialog) {
            AlertDialog(
                onDismissRequest = { showDeleteDialog = false },
                title = { Text(text = stringResource(R.string.delete_student)) },
                text = { Text(text = stringResource(R.string.confirm_delete_student)) },
                confirmButton = { TextButton(
                        onClick = {
                            onDelete()
                            showDeleteDialog = false
                        }
                    ) {
                        Text(stringResource(R.string.positive_option))
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDeleteDialog = false
                        }
                    ) {
                        Text(stringResource(R.string.negative_option))
                    }
                }
            )
        }

    }
}

