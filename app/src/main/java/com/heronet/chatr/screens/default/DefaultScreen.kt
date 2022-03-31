package com.heronet.chatr.screens.default

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.heronet.chatr.screens.navigation.NavGraphScreen
import com.heronet.chatr.screens.navigation.Screen

@Composable
fun DefaultScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBarWithNav(navController = navController)
        }
    ) {
        NavGraphScreen(navController = navController, padding = it)
    }
}

@Composable
fun TopAppBarWithNav(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    TopAppBar(
        title = {
            when (currentRoute) {
                Screen.Chats.route -> {
                    Text(text = "ChatR")
                }
                Screen.Conversation.route -> {
                    Text(text = "Conversation")
                }
                else -> {
                    Text(text = "Blank")
                }
            }
        },
        navigationIcon = if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "BackButton"
                    )
                }
            }
        } else {
            null
        }
    )
}