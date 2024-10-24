package com.brian.myapplication.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brian.myapplication.viewmodels.AuthViewModel

@Composable
fun AccountScreen(authViewModel: AuthViewModel) {
    var username by remember { mutableStateOf("Current Username") }
    var profileImageUri by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Account Settings", style = MaterialTheme.typography.bodyLarge)
        TextField(value = username, onValueChange = { username = it }, label = { Text("Username") })

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Profile Image", style = MaterialTheme.typography.bodyMedium)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Image", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            // Log out
            authViewModel.logout()
        }) {
            Text("Log Out")
        }
    }
}

