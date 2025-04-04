package com.luisgmr.lynxapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luisgmr.lynxapp.presentation.navigation.AppNavigation
import com.luisgmr.lynxapp.presentation.theme.LynxAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LynxAppTheme {
                AppNavigation()
            }
        }
    }
}