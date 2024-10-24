package com.brian.myapplication.views
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TransactionsListScreen() {
    val transactions = listOf("Transaction 1", "Transaction 2", "Transaction 3") // Sample transaction data

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Filter by:", style = MaterialTheme.typography.bodyMedium)
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { /* Filter by date */ }) {
                Text("Date")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* Filter by name */ }) {
                Text("Name")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(transactions) { transaction ->
                Card(
                    modifier = Modifier.padding(8.dp),
                ) {
                    Text(text = transaction, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
