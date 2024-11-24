package br.com.devjmcn.loginscreencompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devjmcn.loginscreencompose.R
import br.com.devjmcn.loginscreencompose.model.UserModel
import br.com.devjmcn.loginscreencompose.ui.theme.LoginScreenComposeTheme

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, onEventClick: (UserModel) -> Unit) {
    var passwordErrorIsVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        var name by remember { mutableStateOf("") }
        TextField(
            value = name,
            onValueChange = { newName -> name = newName },
            label = { Text(stringResource(R.string.str_insert_your_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        var email by remember { mutableStateOf("") }
        TextField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            label = { Text(stringResource(R.string.str_insert_your_best_email)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        var username by remember { mutableStateOf("") }
        TextField(
            value = username,
            onValueChange = { newUsername -> username = newUsername },
            label = { Text(stringResource(R.string.str_insert_your_username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        var password by remember { mutableStateOf("") }
        TextField(
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
                if(passwordErrorIsVisible) {
                    passwordErrorIsVisible = false
                }
            },
            label = { Text(stringResource(R.string.str_insert_your_password)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        if (passwordErrorIsVisible) {
            Text(
                stringResource(
                    R.string.str_your_password_must_contain_at_least_8_letters_including_uppercase_lowercase_and_special_characters
                ),
                color = Color.Red,
                modifier = Modifier
                    .padding(8.dp)
            )
        }

        Button(
            onClick = {
                val user = UserModel(
                    name = name,
                    email = email,
                    username = username,
                    password = password
                )
                onEventClick(user)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(stringResource(R.string.str_register))
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    LoginScreenComposeTheme {
        Scaffold { innerPadding ->
            RegisterScreen(modifier = Modifier.padding(innerPadding), onEventClick = {})
        }
    }
}