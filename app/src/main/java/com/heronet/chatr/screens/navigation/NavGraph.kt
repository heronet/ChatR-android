package com.heronet.chatr.screens.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.heronet.chatr.screens.chats.ChatsScreen
import com.heronet.chatr.screens.conversation.ConversationScreen

@Composable
fun NavGraphScreen(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(navController = navController, startDestination = Screen.Chats.route, modifier = Modifier.padding(padding)) {
        composable(route = Screen.Chats.route) { ChatsScreen(navController) }
        composable(route = Screen.Conversation.route) { ConversationScreen() }
    }
}