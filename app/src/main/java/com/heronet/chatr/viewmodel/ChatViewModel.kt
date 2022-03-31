package com.heronet.chatr.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heronet.chatr.model.Message
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
   private val signalRClient: HubConnection
): ViewModel() {
    var messages = mutableStateListOf<Message>()
    init {
        viewModelScope.launch {
            val message = Message(
                id = "sdsd",
                username = "Sirat",
                timestamp = "4:55 PM",
                conversationId = "FAF",
                text = "Hello from "
            )
            messages.add(message)
            initializeSignalR()
        }
    }
    fun sendMessage(text: String) {
        if (signalRClient.connectionState == HubConnectionState.CONNECTED) {
            signalRClient.invoke("SendMessage", text).doOnComplete {
                Log.d("MES", "Message Sent")
            }
        }
    }
    private fun initializeSignalR() {
        try {
            signalRClient.start().doOnComplete {
                Log.d("MES", "Connected Succesfully")
            }.blockingAwait()
        } catch (e: Exception) {
            Log.d("EXC", e.message.toString())
        }
        signalRClient.on("RecieveMessage", {message ->
            messages.add(message)
        }, Message::class.java)
        signalRClient.onClosed {
            Log.d("MES", "Connection Closed")
        }
    }
}