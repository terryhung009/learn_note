package com.hkc.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textview:TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById<TextView>(R.id.textview)


        textview.text = "Jack"

        button = findViewById<Button>(R.id.button).also {
            it.setOnClickListener {

            }
        }


    }
}