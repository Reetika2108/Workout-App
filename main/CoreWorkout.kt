package com.example.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class CoreWorkout : AppCompatActivity() {
    lateinit var plankCardview: CardView
    lateinit var russianTwistsCardView: CardView
    lateinit var bridgeposeCardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core_workout)
        plankCardview = findViewById(R.id.plankCard)
        russianTwistsCardView = findViewById(R.id.russianTwistsCard)
        bridgeposeCardView = findViewById(R.id.bridgePoseCard)
        plankCardview.setOnClickListener() {
            val intent = Intent(this@CoreWorkout, Plank::class.java)
            startActivity(intent)
        }
        russianTwistsCardView.setOnClickListener() {
            val intent = Intent(this@CoreWorkout, RussianTwists::class.java)
            startActivity(intent)
        }
        bridgeposeCardView.setOnClickListener() {
            val intent = Intent(this@CoreWorkout, BridgePose::class.java)
            startActivity(intent)
        }
    }
}