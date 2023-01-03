package com.hkc.course9_coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Random

class MainActivity : AppCompatActivity() {
    //建立兩個數值，用於計算兔子與烏龜的進度
    private var progressRabbit = 0
    private var progressTurtle = 0
    //建立變數以利後續綁定元件
    private lateinit var btn_start: Button
    private lateinit var sb_rabbit: SeekBar
    private lateinit var sb_turtle: SeekBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //將變數與XML元建綁定
        btn_start = findViewById(R.id.btn_start)
        sb_rabbit = findViewById(R.id.sb_rabbit)
        sb_turtle = findViewById(R.id.sb_turtle)
        //對開始按鈕設定監聽器
        btn_start.setOnClickListener{
            btn_start.isEnabled = false //進行賽跑後按鈕不可被操作
            progressRabbit = 0  //初始化兔子的賽跑進度
            progressTurtle = 0  //初始化烏龜的賽跑進度
            sb_rabbit.progress = 0  //初始化兔子的SeekBar進度
            sb_turtle.progress = 0  //初始化烏龜的SeekBar進度
            runRabbit() //兔子起跑
            runTurtle() //烏龜起跑
        }

    }

//建立shotToast方法顯示Toast訊息
private fun showToast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

//建立Handler物件接收訊息
private val handler = Handler(Looper.getMainLooper()){msg ->
    //判斷編號，並更新兔子的進度
    if(msg.what == 1)
        sb_rabbit.progress = progressRabbit

    //若兔子抵達，則顯示兔子勝利
    if (progressRabbit >= 100 && progressTurtle < 100){
        showToast("兔子勝利")   //顯示兔子勝利
        btn_start.isEnabled = true
    }
    true
}
//用Thread模擬兔子移動
private fun runRabbit(){
    Thread{
        //兔子有三分之二的機率會偷懶
        val sleepProbability = arrayOf(true,true,false)
        while (progressRabbit < 100 && progressTurtle <100){
            try{
                Thread.sleep(100)  //延遲0.1秒更新賽況
                if (sleepProbability.random())
                    Thread.sleep(300)  //兔子偷懶0.3秒
            }catch (e: InterruptedException){
                e.printStackTrace()
            }
            progressRabbit += 3 //每次跑3步

            val msg = Message() //建立Message物件
            msg.what = 1  //加入編號
            handler.sendMessage(msg)//傳送兔子的賽況訊息
        }
    }.start()  //啟動Thread
}
//用Coroutines模擬烏龜移動
private fun runTurtle(){
    GlobalScope.launch(Dispatchers.Main){
        while(progressTurtle < 100 && progressRabbit < 100){
            delay(100)  //延遲0.1秒更新賽況
            progressTurtle += 1  //每次跑1步
            sb_turtle.progress = progressTurtle //更新烏龜的進度
        if (progressTurtle >=100 && progressRabbit <100){
            showToast("烏龜勝利")  //顯示烏龜勝利
            btn_start.isEnabled = true  //按鈕可操作
        }



        }
    }



}



}