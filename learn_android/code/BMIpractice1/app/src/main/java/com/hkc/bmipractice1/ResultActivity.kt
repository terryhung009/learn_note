package com.hkc.bmipractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hkc.bmipractice1.databinding.ActivityMainBinding
import com.hkc.bmipractice1.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val bmi = intent.getFloatExtra("BMI_EXTRA",0f)
        binding.result.setText(bmi.toString())*/

        val bundle = intent.extras
        val bmi = bundle?.getFloat("BMI_EXTRA",0f)
        val testing = bundle?.getString("TEST_EXTRA")

        binding.result.setText(bmi.toString())


    }
}