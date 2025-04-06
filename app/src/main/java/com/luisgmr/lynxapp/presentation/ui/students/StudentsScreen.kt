package com.luisgmr.lynxapp.presentation.ui.students

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.Fill
import com.adamglin.phosphoricons.bold.Plus
import com.adamglin.phosphoricons.bold.Student
import com.adamglin.phosphoricons.fill.PencilSimple
import com.adamglin.phosphoricons.fill.Trash
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.data.model.Student
import com.luisgmr.lynxapp.presentation.components.LynxScaffold
import com.luisgmr.lynxapp.presentation.navigation.Screen
import com.luisgmr.lynxapp.presentation.theme.LynxAppTheme

@Preview(showBackground = true)
@Composable
fun StudentsScreen(
    navController: NavController = rememberNavController()
) {
    LynxAppTheme {
        LynxScaffold(
            title = stringResource(R.string.students),
            navController = navController,
            floatingButton = {
                Row(
                    modifier = Modifier
                        .clickable {

                        }
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
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    "Alunos cadastrados",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StudentComponent(Student("Luis Gustavo"))
                    StudentComponent(Student("Rita de Cassia"))
                }
            }
        }
    }
}

@Composable
fun StudentComponent(
    student: Student
) {
    Row(
        modifier = Modifier
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(PhosphorIcons.Bold.Student, stringResource(R.string.icon))
            Text(
                text = student.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
//                            Text(
//                                text = "6 disciplinas",
//                                style = MaterialTheme.typography.bodyLarge,
//                                overflow = TextOverflow.Ellipsis,
//                                color = Color.Gray
//                            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .clickable {  }
                    .background(
                        color = Color(0x738FFCFF),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    PhosphorIcons.Fill.PencilSimple,
                    stringResource(R.string.icon),
                    tint = Color(0x7314C5CB),
                )
            }
            Row(
                modifier = Modifier
                    .clickable {  }
                    .background(
                        color = Color(0xFFFFA5A5),
                        shape = MaterialTheme.shapes.small
                    )
                    .padding(8.dp)
            ) {
                Icon(
                    PhosphorIcons.Fill.Trash,
                    stringResource(R.string.icon),
                    tint = Color(0xFFA92525),
                )
            }
        }
    }
}