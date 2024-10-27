package com.example.task_013

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var radioGroupRG: RadioGroup
    private lateinit var nextQuestionBTN: Button

    var curScores:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        radioGroupRG = findViewById(R.id.radioGroupRG)
        nextQuestionBTN = findViewById(R.id.nextQuestionBTN)

        var intentIn: Intent
        intentIn = getIntent()
        curScores = intentIn.getStringExtra("scores")!!.toInt()

        nextQuestionBTN.setOnClickListener{
            var id: Int = radioGroupRG.checkedRadioButtonId
            var scores: Int = 0;
            if (id == -1) {
                Toast.makeText(this,"Ответ не выбран", Toast.LENGTH_LONG).show()
            } else {
                val radio: RadioButton = findViewById(id)
                if (radio.text == "ВС России.") scores = 100 else scores = 0

                val intentOut = Intent(this, ThirdActivity::class.java)
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