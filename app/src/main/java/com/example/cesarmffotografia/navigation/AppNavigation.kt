package com.example.cesarmffotografia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cesarmffotografia.screens.HomeScreen
import com.example.cesarmffotografia.screens.LoginScreen
import com.example.cesarmffotografia.screens.RegisterScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val auth = FirebaseAuth.getInstance()

    val startDestination =
        if (auth.currentUser != null) {
            "home"
        } else {
            "login"
        }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable("login") {

            LoginScreen(
                onLoginSuccess = {

                    navController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },

                onCreateAccount = {
                    navController.navigate("register")
                }
            )
        }

        composable("register") {

            RegisterScreen(
                onRegisterSuccess = {

                    navController.navigate("home") {
                        popUpTo("register") {
                            inclusive = true
                        }
                    }
                },

                onBackToLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable("home") {

            HomeScreen(
                onLogout = {

                    auth.signOut()

                    navController.navigate("login") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}