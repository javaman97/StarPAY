package com.brian.myapplication.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UserDetailsScreen(s: String) {
    val userTransactions = listOf("Transaction A", "Transaction B", "Transaction C") // Sample transactions

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "User Details", style = MaterialTheme.typography.bodyMedium)
        // Placeholder for profile image
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Profile Image", color = Color.White)
        }
        Text(text = "Name: User Name", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Total Money Sent: \$200.00", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Total Money Received: \$300.00", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Transactions", style = MaterialTheme.typography.headlineSmall)

        LazyColumn {
            items(userTransactions) { transaction ->
                Text(text = transaction, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
