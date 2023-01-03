package com.hkc.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("MainActivity","OnCreate")
        //建立FragmentPagerAdapter物件
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //連接Adapter，讓畫面(Fragment)與ViewPager建立關聯
        findViewById<ViewPagerager2>(R.id.ViewPager).adapter = adapter
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity","onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity","onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.e("MainActivity","onPause")

    }

    override fun onStop(){
        super.onStop()
        Log.e("MainActivity","onStop")



    }

    override fun onDestroy(){
        super.onDestroy()
        Log.e("MainActivity","onDestroy")


    }

}

class ViewPagerAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm){
    //回傳對應位置的fragment，決定頁面的呈現順序
    override fun getItem(position: Int) = when(position){
        0 -> FirstFragment()     //第一頁要呈現的Fragment
        1 -> SecondFragment()    //第二頁要呈現的Fragment
        else -> ThirdFragment()  //第三頁要呈現的Fragment

    }

    override fun getCount() = 3




}