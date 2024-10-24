package com.brian.myapplication.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotificationScreen() {
    val notifications = listOf(
        Pair("Notification 1", false),
        Pair("Notification 2", true),
        Pair("Notification 3", false)
    ) // Sample notifications

    LazyColumn {
        items(notifications) { (text, isRead) ->
            val backgroundColor = if (isRead) Color.Transparent else Color.LightGray
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .background(backgroundColor),
            ) {
                Text(text = text, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
