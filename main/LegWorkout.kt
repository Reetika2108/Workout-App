package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class LegWorkout : AppCompatActivity() {
    lateinit var wallSitCardView: CardView
    lateinit var lungesCardView: CardView
    lateinit var squatsCardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leg_workout)
        wallSitCardView = findViewById(R.id.wallSitCard)
        lungesCardView = findViewById(R.id.lungesCard)
        squatsCardView = findViewById(R.id.squatCard)
        wallSitCardView.setOnClickListener() {
            var intent = Intent(this@LegWorkout, WallSit::class.java)
            startActivity(intent)
        }
        lungesCardView.setOnClickListener() {
            var intent = Intent(this@LegWorkout, Lunges::class.java)
            startActivity(intent)
        }
        squatsCardView.setOnClickListener() {
            var intent = Intent(this@LegWorkout, Squats::class.java)
            startActivity(intent)
        }
    }
}