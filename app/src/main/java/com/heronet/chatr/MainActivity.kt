package com.heronet.chatr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.heronet.chatr.screens.conversation.ConversationScreen
import com.heronet.chatr.screens.default.DefaultScreen
import com.heronet.chatr.screens.navigation.NavGraphScreen
import com.heronet.chatr.screens.navigation.Screen
import com.heronet.chatr.ui.theme.ChatRTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatRTheme {
                navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // To keep this acivity clean
                    DefaultScreen(navController = navController)
                }
            }
        }
    }
}