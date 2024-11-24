package br.com.devjmcn.loginscreencompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.devjmcn.loginscreencompose.ui.screens.LoginScreen
import br.com.devjmcn.loginscreencompose.ui.screens.MainScreen
import br.com.devjmcn.loginscreencompose.ui.screens.RegisterScreen

@Composable
fun NavigationApp(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MAIN/{USER}") {
        composable("MAIN/{USER}") { entry ->
            entry.arguments?.getString("USER")?.let { user ->
                MainScreen(modifier = modifier, user = user)
            } ?: LaunchedEffect(key1 = null) {
                navController.navigate("LOGIN")
            }
        }

        composable("LOGIN") {
            LoginScreen(
                modifier = modifier,
                onClickRegister = { navController.navigate("REGISTER") },
                onClickAccess = { userModel ->
                    navController.navigate("MAIN/${userModel.username}")
                })
        }

        composable("REGISTER") {
            RegisterScreen(modifier = modifier, onEventClick = {
                navController.popBackStack()
            })
        }
    }
}