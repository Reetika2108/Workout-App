package com.example.workoutapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    lateinit var notificationManager:NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    val notificationId = 1234
    val channelId = "My Channel"
    val title = "Login Successful"
    val description = "Hello user, You've successfully logged in!"
    lateinit var pendingIntent:PendingIntent
    lateinit var corecardview: CardView
    lateinit var legcardview: CardView
    lateinit var armcardview:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val welcometext: TextView = findViewById(R.id.welcome)
        val sharedPreference = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val username = sharedPreference.getString("USERNAME","").toString()
        welcometext.text = "Welcome $username! \nLet's get started"
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var intent = Intent(this, MainActivity2::class.java)
        pendingIntent = PendingIntent.getActivity(this, 0 , intent, PendingIntent.FLAG_IMMUTABLE)
        createMyChannel()
        notificationManager.notify(notificationId, builder.build())
        corecardview = findViewById(R.id.coreWorkoutCard)
        legcardview = findViewById(R.id.legWorkoutCard)
        armcardview = findViewById(R.id.armWorkoutCard)
        corecardview.setOnClickListener() {
            val intent = Intent(this@HomeActivity, CoreWorkout::class.java)
            startActivity(intent)
        }
        legcardview.setOnClickListener() {
            val intent = Intent(this@HomeActivity, LegWorkout::class.java)
            startActivity(intent)
        }
        armcardview.setOnClickListener() {
            val intent = Intent(this@HomeActivity, ArmWorkout::class.java)
            startActivity(intent)
        }
    }
    fun createMyChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableVibration(true)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_baseline_notifications_active_24))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
        else {
            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_baseline_notifications_active_24))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
    }
}