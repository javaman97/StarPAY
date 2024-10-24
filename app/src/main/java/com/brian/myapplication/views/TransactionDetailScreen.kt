package com.brian.myapplication.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TransactionDetailScreen(transactionId: String) {
    // Sample transaction details
    val details = "Details of transaction $transactionId"

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Transaction Details", style = MaterialTheme.typography.bodyMedium)
        Text(text = details, style = MaterialTheme.typography.bodyLarge)
    }
}
