package com.hkc.videorecorder

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var angle = 0f
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //識別返回對象及結果
        if (requestCode == 0 && resultCode == RESULT_OK){
            //取得影像並顯示於ImageView
            val image = data?.extras?.get("data") ?: return
            findViewById<ImageView>(R.id.imageView).setImageBitmap(image as Bitmap)

        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_photo).setOnClickListener {
        //建立一個要進行影像獲取的Intent物件
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            //用try-catch避免產生例外，若產生則顯示Toast
            try{
                startActivityForResult(intent,0)        //發送Intent


            }catch (e: ActivityNotFoundException){
                Toast.makeText(this,"此裝置無相機應用程式",Toast.LENGTH_LONG).show()

            }


        }
        findViewById<Button>(R.id.btn_rotate).setOnClickListener {
            angle += 90f        //原本角度再加上90度
            findViewById<ImageView>(R.id.imageView).rotation = angle    //使ImageView旋轉
        }


    }
}