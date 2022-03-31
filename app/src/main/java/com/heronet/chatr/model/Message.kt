package com.heronet.chatr.model

data class Message(
    val text: String,
    val timestamp: String,
    val username: String,
    val id: String,
    val conversationId: String
)
