package com.example.workoutapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class ArmWorkout : AppCompatActivity() {
    lateinit var armCircleCardView: CardView
    lateinit var tricepDipsCardView: CardView
    lateinit var pushupCardView: CardView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arm_workout)
        armCircleCardView = findViewById(R.id.armCirclesCard)
        tricepDipsCardView = findViewById(R.id.tricepDipsCard)
        pushupCardView = findViewById(R.id.pushupCard)
        armCircleCardView.setOnClickListener() {
            var intent = Intent(this@ArmWorkout, ArmCircles::class.java)
            startActivity(intent)
        }
        tricepDipsCardView.setOnClickListener() {
            var intent = Intent(this@ArmWorkout, TricepDips::class.java)
            startActivity(intent)
        }
        pushupCardView.setOnClickListener() {
            var intent = Intent(this@ArmWorkout, Pushup::class.java)
            startActivity(intent)
        }
    }
}