package com.example.task_013

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    private lateinit var radioGroupRG: RadioGroup
    private lateinit var nextQuestionBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        radioGroupRG = findViewById(R.id.radioGroupRG)
        nextQuestionBTN = findViewById(R.id.nextQuestionBTN)

        nextQuestionBTN.setOnClickListener{
            var id: Int = radioGroupRG.checkedRadioButtonId
            var scores: Int = 0;
            if (id == -1) {
                Toast.makeText(this,"Ответ не выбран", Toast.LENGTH_LONG).show()
            } else {
                val radio: RadioButton = findViewById(id)
                if (radio.text == "Наполовину.") scores = 100 else scores = 0

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("scores", scores.toString())
                startActivity(intent)
            }
        }
    }

    fun radioButtonClick(view: View) {
        val radio: RadioButton = findViewById(radioGroupRG.checkedRadioButtonId)
        Toast.makeText(this,"Выбран ответ: ${radio.text}", Toast.LENGTH_LONG).show()
    }
}