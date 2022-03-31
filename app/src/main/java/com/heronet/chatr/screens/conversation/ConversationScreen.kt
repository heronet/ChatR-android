package com.heronet.chatr.screens.conversation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.heronet.chatr.model.Message
import com.heronet.chatr.viewmodel.ChatViewModel

@Preview(showBackground = true)
@Composable
fun ConversationScreen(
    viewModel: ChatViewModel = hiltViewModel()
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 8.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            item { 
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(viewModel.messages) { message ->
                Bubble(message)
            }
        }
        Row(
            modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = {text = it},
                placeholder = { Text(text = "Enter your message") },
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = {
                if (text.isNotBlank()) viewModel.sendMessage(text)
                text = ""
            }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
            }
        }
    }
}

@Composable
fun Bubble(message: Message) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(4.dp)
    ) {
        Column(Modifier.padding(vertical = 4.dp)) {
            Text(text = message.text, modifier = Modifier.padding(horizontal = 8.dp))
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = message.timestamp,
                fontSize = 10.sp,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

    }
}