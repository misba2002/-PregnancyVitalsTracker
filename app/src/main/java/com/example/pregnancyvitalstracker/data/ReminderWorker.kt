package com.example.pregnancyvitalstracker.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.pregnancyvitalstracker.MainActivity
import com.example.pregnancyvitalstracker.R

class ReminderWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        showNotification(applicationContext)
        return Result.success()
    }

    private fun showNotification(context: Context) {
        val channelId = "vitals_reminder_channel"
        val notificationId = 1

        // Intent to open MainActivity when clicked
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Create notification channel (Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Vitals Reminder"
            val descriptionText = "Reminds to log pregnancy vitals"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // ✅ Check if notifications are enabled (Android 13+ safe)
        val notificationManagerCompat = NotificationManagerCompat.from(context)
        if (
            Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            notificationManagerCompat.areNotificationsEnabled()
        ) {
            val notification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Time to log your vitals!")
                .setContentText("Stay on top of your health. Please update your vitals now!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()

            notificationManagerCompat.notify(notificationId, notification)
        }
    }
}
