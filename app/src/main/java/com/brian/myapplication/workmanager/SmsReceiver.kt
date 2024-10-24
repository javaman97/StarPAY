package com.brian.myapplication.workmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager


class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle: Bundle? = intent.extras
            if (bundle != null) {
                val pdus = bundle.get("pdus") as Array<*>
                for (pdu in pdus) {
                    val message = SmsMessage.createFromPdu(pdu as ByteArray)
                    val sender = message.displayOriginatingAddress
                    val body = message.messageBody

                    // Create data for the work request
                    val data = Data.Builder()
                        .putString("sender", sender)
                        .putString("body", body)
                        .build()

                    // Enqueue work to handle the SMS message
                    val workRequest = OneTimeWorkRequestBuilder<SmsWorker>()
                        .setInputData(data)
                        .build()

                    WorkManager.getInstance(context!!).enqueue(workRequest)
                }
            }
        }
    }
}

