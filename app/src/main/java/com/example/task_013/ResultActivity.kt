package com.example.task_013

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var resultTV: TextView
    private lateinit var outputInfoTV: TextView
    private lateinit var returnBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultTV = findViewById(R.id.resultTV)
        outputInfoTV = findViewById(R.id.outputInfoTV)
        returnBTN = findViewById(R.id.returnBTN)

        var intentIn: Intent
        intentIn = getIntent()
        val resultData = intentIn.getStringExtra("result")!!.toInt()

        resultTV.text = "Результат игры " + resultData.toString() + " очков."

        when(resultData) {
            500 -> outputInfoTV.text = "Знаток отличный."
            400 -> outputInfoTV.text = "Знаток хороший."
            300 -> outputInfoTV.text = "Знаток удовлетворительный."
            200 -> outputInfoTV.text = "Знаток плохой."
            100 -> outputInfoTV.text = "Знаток отвратительный."
            0 -> outputInfoTV.text = "Знаток никакой."
        }

        returnBTN.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}