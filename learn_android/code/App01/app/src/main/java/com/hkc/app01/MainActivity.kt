package com.hkc.app01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
/*因android的app有生命週期
所以入口點是OnCreate，不是main函數
 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//定義變量sum(合計結果)給下面使用
    var sum = 0

    fun increment(view:View){
        sum++
        //加上自己再加1
        showScores(sum)

    }

    fun decrement(v:View){
        sum--
        showScores(sum)


    }

    private fun showScores(sum: Int) {
        val textView:TextView = findViewById(R.id.textView)
        textView.text = sum.toString()

    }


}