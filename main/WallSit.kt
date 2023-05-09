package com.example.workoutapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class WallSit : AppCompatActivity() {
    lateinit var timer: CountDownTimer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall_sit)
        val timeTextView: TextView = findViewById(R.id.timertext)
        val timerButton: Button = findViewById(R.id.startTimer)

        timer = object: CountDownTimer(90_000, 1_000) {
            var time = 90
            override fun onFinish() {
                timeTextView.text = "Done!"
            }

            override fun onTick(p0: Long) {
                timeTextView.text = (--time).toString()
            }
        }
        timerButton.setOnClickListener() {
            timer.start()
        }
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }
}