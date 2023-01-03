package com.hkc.mvvmtest2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.hkc.mvvmtest2.Viewmodel.MainViewModel
import com.hkc.mvvmtest2.Viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var edit: EditText
    private lateinit var btnSave: Button
    private lateinit var btnResult: Button

    private lateinit var viewModel: MainViewModel


//    private val viewModel: MainViewModel by lazy {
//        ViewModelProvider(this, MyViewModelFactory()).get(MainViewModel::class.java)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit= findViewById(R.id.editMain)
        btnSave= findViewById(R.id.btnMainSave)
        btnResult= findViewById(R.id.btnMainResult)
        //建立ViewModel實例
        viewModel = ViewModelProvider(this, MyViewModelFactory()).get(MainViewModel::class.java)


//        var myViewModelFactory= MyViewModelFactory()

        btnSave.setOnClickListener {
            viewModel.saveText(edit.text.toString())
            edit.text = null
        }

        btnResult.setOnClickListener {
            intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)

            //濃縮為一句
//            startActivity(Intent(this, ResultActivity::class.java))
        }


    }
}