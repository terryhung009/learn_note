package com.hkc.mvvmtest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hkc.mvvmtest3.ViewModel.MainViewModel
import com.hkc.mvvmtest3.ViewModel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var edit: EditText
    private lateinit var btnSave: Button
    private lateinit var textResult: TextView

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MyViewModelFactory()).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit = findViewById(R.id.editMain)
        btnSave = findViewById(R.id.btnMainSave)
        textResult = findViewById(R.id.textMainResult)

        btnSave.setOnClickListener {
            viewModel.saveText(edit.text.toString())
            edit.text = null
        }

        viewModel.getText().observe(this, Observer {
            textResult.text = it
        })
    }
}