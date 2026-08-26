package com.example.cesarmffotografia.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.cesarmffotografia.screens.components.AppHeader
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onCreateAccount: () -> Unit
) {

    val auth = FirebaseAuth.getInstance()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    // Cabeçalho
    AppHeader()

    //Conteúdo Principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "CesarMFFotografia"
        )

        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
            },

            label = {
                Text("E-mail")
            },

            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password,

            onValueChange = {
                password = it
            },

            label = {
                Text("Senha")
            },

            visualTransformation =
                PasswordVisualTransformation(),

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Button(

            onClick = {

                if (
                    email.isBlank() ||
                    password.isBlank()
                ) {

                    errorMessage =
                        "Preencha todos os campos."

                    return@Button
                }

                auth.signInWithEmailAndPassword(
                    email,
                    password
                ).addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        onLoginSuccess()

                    } else {

                        errorMessage =
                            task.exception?.message
                                ?: "Erro ao fazer login."
                    }
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            Text("Entrar")
        }

        Button(

            onClick = onCreateAccount,

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {

            Text("Criar conta")
        }

        if (errorMessage.isNotEmpty()) {

            Text(
                text = errorMessage,

                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
    }
}