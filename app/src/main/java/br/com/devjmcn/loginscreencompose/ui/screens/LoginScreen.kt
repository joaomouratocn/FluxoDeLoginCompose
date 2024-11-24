package br.com.devjmcn.loginscreencompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devjmcn.loginscreencompose.R
import br.com.devjmcn.loginscreencompose.model.UserModel
import br.com.devjmcn.loginscreencompose.ui.theme.LoginScreenComposeTheme

@Composable
fun LoginScreen(
    modifier: Modifier,
    onClickRegister: () -> Unit,
    onClickAccess: (UserModel) -> Unit
) {
    Column(
        modifier = modifier
            .padding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = stringResource(R.string.str_logo_image),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(CircleShape)
        )

        var username by remember { mutableStateOf("") }
        TextField(
            value = username,
            onValueChange = { newString -> username = newString },
            label = {
                Text(stringResource(R.string.str_username))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = stringResource(R.string.str_image_account)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        var password by remember { mutableStateOf("") }
        var viewPassword by remember { mutableStateOf(false) }
        TextField(
            value = password,
            onValueChange = { newString -> password = newString },
            label = {
                Text(stringResource(R.string.str_password))
            },
            visualTransformation = if (viewPassword) PasswordVisualTransformation() else VisualTransformation.None,
            leadingIcon = {
                Icon(
                    imageVector = if (viewPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = stringResource(id = R.string.str_image_view_password),
                    modifier = Modifier.clickable { viewPassword = !viewPassword }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = {
                val user =
                    UserModel(name = "", email = "", username = username, password = password)
                onClickAccess(user)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.str_login))
        }

        Text(
            text = stringResource(R.string.str_register),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { onClickRegister() }
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreenComposeTheme {
        Scaffold { innerPadding ->
            LoginScreen(
                modifier = Modifier.padding(innerPadding),
                onClickRegister = {},
                onClickAccess = {}
            )
        }
    }
}