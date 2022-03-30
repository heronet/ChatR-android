package com.heronet.chatr.screens.chat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Preview(showBackground = true)
@Composable
fun ChatScreen(
    viewModel: ChatViewModel = hiltViewModel()
) {
    MessageList(messages = viewModel.messages)
}

@Composable
fun MessageList(messages: List<String>) {
    LazyColumn {
        items(messages) { message ->
            Text(text = message)
        }
    }
}

