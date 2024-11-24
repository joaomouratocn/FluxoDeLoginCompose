package br.com.devjmcn.loginscreencompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.devjmcn.loginscreencompose.R
import br.com.devjmcn.loginscreencompose.ui.theme.LoginScreenComposeTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier, user: String) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.str_hello, user),
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    LoginScreenComposeTheme {
        Scaffold { innerPadding ->
            MainScreen(
                modifier = Modifier.padding(innerPadding),
                user = "João"
            )
        }
    }
}