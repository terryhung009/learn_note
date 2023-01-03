package com.hkc.practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hkc.practice1.ViewModel.MainViewModel
import com.hkc.practice1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    var secret = 0
//    var times = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.message.observe(this, Observer {
            binding.message.setText(it)
        })
        viewModel.times.observe(this, Observer {
            binding.counter.setText(it.toString())
        })
        binding.button.setOnClickListener {
            viewModel.guess(binding.number.text.toString().toInt())
        }
//        secret = Random.nextInt(10)+1
//        binding.message.setText("")
//        binding.button.setOnClickListener{
//            val num = binding.number.text.toString().toInt()
//            val text = when(num-secret){
//                0 -> "答對了"
//                in 1..10 -> "小一點"
//                    else -> "大一點"
//
//            }
//            times++
//            binding.counter.setText(times.toString())
//            binding.message.setText(text)
//        }
    }
}