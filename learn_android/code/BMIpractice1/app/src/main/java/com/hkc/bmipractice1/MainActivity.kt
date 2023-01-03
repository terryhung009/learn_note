package com.hkc.bmipractice1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hkc.bmipractice1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*        binding.bHelp.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("體重(kg)/身高的平方(m)")
                .setTitle("BMI說明")
                .setPositiveButton("OK",null)
                .show()*/
//        }
        val app = getString(R.string.app_name)


    }

    fun bmi(view: View){
        val weight = binding.edWeight.text.toString().toFloat()
        val height = binding.edHeight.text.toString().toFloat()
        val bmi = weight / (height * height)
//        Log.d("BMI",bmi.toString())
        /*Toast.makeText(this,bmi.toString(),Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setMessage(bmi.toString())
            .setTitle("Your BMI")
            .setPositiveButton("OK",null)
            .setNeutralButton("Cancel",null)
            .show()*/
       /* val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("BMI_EXTRA",bmi)
        startActivity(intent)*/

        Intent(this,ResultActivity::class.java).apply{
            val bag = Bundle()
            bag.putFloat("BMI_EXTRA",bmi)
            bag.putString("TEST_EXTRA","Testing")
            putExtras(bag)
            startActivity(this)
    }


    }




}