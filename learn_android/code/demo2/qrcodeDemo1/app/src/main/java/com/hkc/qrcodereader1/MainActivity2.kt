package com.hkc.qrcodereader1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.*
import kotlinx.android.synthetic.main.activity_main2.*

private const val CAMERA_REQUEST_CODE = 101

class MainActivity2 : AppCompatActivity() {

    private lateinit var codeScanner :CodeScanner
    private lateinit var permissionArray : Array<String>
    private lateinit var text : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//        var permission = arrayOf(android.Manifest.permission.CAMERA)
        permissionArray = arrayOf(android.Manifest.permission.CAMERA)

        setupPermissions()
        initcodescanner()
        SMS_Button.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","1922",null))
            intent.putExtra("sms_body",text)
            startActivity(intent)

        }
    }

    private fun initcodescanner() {
        codeScanner = CodeScanner(this,scanner_view)

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false


            decodeCallback = DecodeCallback {
                runOnUiThread {

//                    tv_textView.text = it.text
                    tv_textView.text = "已獲取二維碼，請按發送"
                    text = it.text

                }
            }

            errorCallback = ErrorCallback {
                runOnUiThread {
                    Log.e("Main","Camera initialzation error ${it.message}")
                }
            }
        }

        scanner_view.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()

        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun setupPermissions(){
        val permission : Int = ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)

        if (permission != PackageManager.PERMISSION_GRANTED){
            makeRequest()
        }

    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),CAMERA_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_REQUEST_CODE ->{
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"請允許相機以使用掃描功能",Toast.LENGTH_LONG).show()

                }else{
                    //Permission Successful
                }
            }
        }

    }
}