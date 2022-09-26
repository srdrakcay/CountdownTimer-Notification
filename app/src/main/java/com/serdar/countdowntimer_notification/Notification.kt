package com.serdar.countdowntimer_notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.serdar.countdowntimer_notification.Constant.Companion.CHANNEL_ID
import com.serdar.countdowntimer_notification.Constant.Companion.CHANNEL_NAME

object Notification  {

    fun timerNotification(context: Context, title: String, description: String) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        timerNotificationChannel(notificationManager)

        val builder = timerNotificationCompat(context, title, description)

        notificationManager.notify(1, builder.build())
    }

    // Notification chanel
    private fun timerNotificationChannel(notificationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    //Notification Style
    private fun timerNotificationCompat(
        context: Context,
        title: String,
        description: String
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(R.drawable.notification)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    }
}