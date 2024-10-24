package com.brian.myapplication.views
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val searchHistory = listOf("Search 1", "Search 2", "Search 3") // Sample search history

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = searchQuery, onValueChange = { searchQuery = it }, label = { Text("Search") })

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(searchHistory) { historyItem ->
                Text(text = historyItem, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
