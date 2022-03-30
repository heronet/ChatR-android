package com.heronet.chatr.screens.chat

import android.os.Handler
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
   private val signalRClient: HubConnection
): ViewModel() {
    var messages = mutableStateListOf<String>()
    init {
        viewModelScope.launch {
            initializeSignalR()
        }
    }
    fun sendMessage(text: String) {
        if (signalRClient.connectionState == HubConnectionState.CONNECTED) {
            signalRClient.send("SendMessage", text)
        }
    }
    private fun initializeSignalR() {
        try {
            signalRClient.start()
        } catch (e: Exception) {
            Log.d("EXC", e.message.toString())
        }
        signalRClient.on("RecieveMessage", {text ->
            messages.add(text)
        }, String::class.java)
    }
}