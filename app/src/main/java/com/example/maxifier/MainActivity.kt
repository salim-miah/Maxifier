package com.example.maxifier

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var randnumber1 = (0..100).random()
        var randnumber2 = (0..100).random()

        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var score = findViewById<TextView>(R.id.Score)
        var tries = findViewById<TextView>(R.id.tries)
        var retry = findViewById<Button>(R.id.retry)

        button1.setText(randnumber1.toString())
        button2.setText(randnumber2.toString())

        button1.setOnClickListener{
            if (button1.text.toString().toInt()>button2.text.toString().toInt()){
                var temp = score.text.toString().toInt()
                var sum = temp+button1.text.toString().toInt()
                score.setText(sum.toString())
            }else{
                var temp = score.text.toString().toInt()
                var sum = temp-button1.text.toString().toInt()
                score.setText(sum.toString())
            }
            //To randomise the numbers on buttons again
            randnumber1 = (0..100).random()
            randnumber2 = (0..100).random()
            button1.setText(randnumber1.toString())
            button2.setText(randnumber2.toString())
            //To increment the number of tries
            var temp = tries.text.toString().toInt()
            var sum = temp+1
            tries.setText(sum.toString())
        }

        button2.setOnClickListener{
            if (button2.text.toString().toInt()>button1.text.toString().toInt()){
                var temp = score.text.toString().toInt()
                var sum = temp+button2.text.toString().toInt()
                score.setText(sum.toString())
            }else{
                var temp = score.text.toString().toInt()
                var sum = temp-button2.text.toString().toInt()
                score.setText(sum.toString())
            }
            //To randomise the numbers on buttons again
            randnumber1 = (0..100).random()
            randnumber2 = (0..100).random()
            button1.setText(randnumber1.toString())
            button2.setText(randnumber2.toString())
            //To increment the number of tries
            var temp = tries.text.toString().toInt()
            var sum = temp+1
            tries.setText(sum.toString())
        }

        retry.setOnClickListener{
            score.setText("0")
            tries.setText("0")
        }
    }
}