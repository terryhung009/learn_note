package com.hkc.atm

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hkc.atm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userid = getSharedPreferences("atm", MODE_PRIVATE)
            .getString("PREF_USERID","")
        binding.edUserid.setText(userid)

        binding.button.setOnClickListener {
            login()
        }



        fun cancel(view:View){



        }



    }

    private fun login (){
        val userid = binding.edUserid.text.toString()
        val passwd = binding.edPasswd.text.toString()
        if (userid == "jack" && passwd == "1234"){
            getSharedPreferences("atm", Context.MODE_PRIVATE)
                .edit()
                .putString("PREF_USERID",userid)
                .apply()

            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show()
            intent.putExtra("LOGIN_USERID",userid)
            intent.putExtra("LOGIN_PASSWD",passwd)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }else{
            AlertDialog.Builder(this)
                .setTitle("ATM")
                .setMessage("登入失敗")
                .setPositiveButton("OK",null)
                .show()
        }


    }

}