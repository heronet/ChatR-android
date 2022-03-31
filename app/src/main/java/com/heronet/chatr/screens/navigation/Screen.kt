package com.heronet.chatr.screens.navigation

sealed class Screen(val route: String) {
    object Chats: Screen(route = "chats_screen")
    object Conversation: Screen(route = "conversation_screen")
}
