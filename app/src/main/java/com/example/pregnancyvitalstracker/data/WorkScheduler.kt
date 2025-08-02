package com.example.pregnancyvitalstracker.data

import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

object WorkScheduler {

    fun scheduleReminder(context: Context) {
        val workRequest = PeriodicWorkRequestBuilder<ReminderWorker>(5, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "vitals_reminder",
            ExistingPeriodicWorkPolicy.KEEP, // don’t reschedule if already running
            workRequest
        )
    }
}
