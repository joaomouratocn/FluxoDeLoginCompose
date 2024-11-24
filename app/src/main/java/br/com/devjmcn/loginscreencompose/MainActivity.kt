package br.com.devjmcn.loginscreencompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.devjmcn.loginscreencompose.model.UserModel
import br.com.devjmcn.loginscreencompose.ui.NavigationApp
import br.com.devjmcn.loginscreencompose.ui.screens.LoginScreen
import br.com.devjmcn.loginscreencompose.ui.screens.MainScreen
import br.com.devjmcn.loginscreencompose.ui.screens.RegisterScreen
import br.com.devjmcn.loginscreencompose.ui.theme.LoginScreenComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreenComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}