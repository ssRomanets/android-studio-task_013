package com.example.task_013

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var beginGameBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beginGameBTN = findViewById(R.id.beginGameBTN)

        beginGameBTN.setOnClickListener{
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
    }
}