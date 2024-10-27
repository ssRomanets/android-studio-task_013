package com.example.task_013

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FiveActivity : AppCompatActivity() {
    private lateinit var radioGroupRG: RadioGroup
    private lateinit var finalGameBTN: Button

    var curScores:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)

        radioGroupRG = findViewById(R.id.radioGroupRG)
        finalGameBTN = findViewById(R.id.finalGameBTN)

        var intentIn: Intent
        intentIn = getIntent()
        curScores = intentIn.getStringExtra("scores")!!.toInt()

        finalGameBTN.setOnClickListener{
            var id: Int = radioGroupRG.checkedRadioButtonId
            var scores: Int = 0;
            if (id == -1) {
                Toast.makeText(this,"Ответ не выбран", Toast.LENGTH_LONG).show()
            } else {
                val radio: RadioButton = findViewById(id)
                if (radio.text == "Порошенко.") scores = 100 else scores = 0

                val intentOut = Intent(this, ResultActivity::class.java)
                intentOut.putExtra("scores", (scores+curScores).toString())
                startActivity(intentOut)
            }
        }
    }

    fun radioButtonClick(view: View) {
        val radio: RadioButton = findViewById(radioGroupRG.checkedRadioButtonId)
        Toast.makeText(this,"Выбран ответ: ${radio.text}", Toast.LENGTH_LONG).show()
    }

}