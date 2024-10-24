package com.brian.myapplication.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    // LiveData to observe today's spending and receiving
    private val _todayStats = MutableLiveData<TodayStats>()
    val todayStats: LiveData<TodayStats> get() = _todayStats

    // Function to fetch today's stats (mock implementation)
    fun fetchTodayStats() {
        // Simulate fetching data
        _todayStats.value = TodayStats(spent = 100.0, received = 150.0)
    }
}

data class TodayStats(val spent: Double, val received: Double)
