package com.brian.myapplication.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

//class SmsWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
//    override fun doWork(): Result {
//        val smsText = inputData.getString("sms_text") ?: return Result.failure()
//
//        // Process the SMS text here
//        // Example: Extracting relevant information
//        Log.d("SmsWorker", "Received SMS: $smsText")
//
//        return Result.success()
//    }
//}

class SmsWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        // Get the SMS data passed in
        val sender = inputData.getString("sender")
        val body = inputData.getString("body")

        // Process the SMS (for example, log it or save it to a database)
        if (sender != null && body != null) {
            // Here you can process the SMS as needed
            // For example:
            println("SMS received from: $sender, message: $body")
        }

        // Return success or failure
        return Result.success()
    }
}

