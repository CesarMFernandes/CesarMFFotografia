package com.example.cesarmffotografia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cesarmffotografia.navigation.AppNavigation
import com.example.cesarmffotografia.ui.theme.CesarMFFotografiaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CesarMFFotografiaTheme {

                AppNavigation()
            }
        }
    }
}