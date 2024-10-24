package com.brian.myapplication

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize WorkManager
        WorkManager.initialize(this, Configuration.Builder().build())
    }
}
