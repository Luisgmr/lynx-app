package com.luisgmr.lynxapp.presentation.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.Fill
import com.adamglin.phosphoricons.Regular
import com.adamglin.phosphoricons.bold.Cat
import com.adamglin.phosphoricons.fill.Cat
import com.adamglin.phosphoricons.fill.Exam
import com.adamglin.phosphoricons.fill.Student
import com.adamglin.phosphoricons.regular.Cat
import com.luisgmr.lynxapp.R
import com.luisgmr.lynxapp.presentation.navigation.Screen
import com.luisgmr.lynxapp.presentation.theme.LynxAppTheme

@Preview
@Composable
fun MenuScreen(
    navController: NavController = rememberNavController()
) {
    LynxAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(PhosphorIcons.Regular.Cat, contentDescription = stringResource(R.string.icon), Modifier.size(36.dp), tint = Color.White)
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
                Spacer(Modifier.size(16.dp))
                Text(
                    text = "Bem-vindo(a), Luis!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(
                        Color(0xffeaeaea),
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .width(72.dp)
                        .height(8.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(24.dp))
                ) {

                }
                Text("Selecione uma opção", fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    ScreenNavigationButton(
                        stringResource(R.string.students),
                        PhosphorIcons.Fill.Student,
                        navController
                    )
                    ScreenNavigationButton(
                        stringResource(R.string.subjects),
                        PhosphorIcons.Fill.Exam,
                        navController
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenNavigationButton(
    text: String,
    icon: ImageVector,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .size(128.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true,
                ),
                onClick = {
                    navController.navigate(Screen.Students.route)
                }
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, contentDescription = stringResource(R.string.icon), Modifier.size(36.dp))
        Text(text)
    }
}