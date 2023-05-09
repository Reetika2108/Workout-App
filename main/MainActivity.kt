package com.example.workoutapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var userName: EditTextCustom
    lateinit var userPassword: EditTextCustom
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userName = findViewById(R.id.userName)
        userPassword = findViewById(R.id.userPassword)
        userPassword.setFocusableInTouchMode(true);
        userPassword.requestFocus();
        val sharedPreference = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val getUsername = sharedPreference.getString("USERNAME", "")
        val getPassword = sharedPreference.getString("PASSWORD", "")
        userPassword.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                // If the event is a key-down event on the "enter" button
                if (event.getAction() === KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                    val name = userName.text.toString()
                    val password = userPassword.text.toString()

                    val editor = sharedPreference.edit()
                    editor.putString("USERNAME", name)
                    editor.putString("PASSWORD", password)
                    editor.apply()

                    val i = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(i)
                    return true
                }
                return false
            }
        })
    }
}