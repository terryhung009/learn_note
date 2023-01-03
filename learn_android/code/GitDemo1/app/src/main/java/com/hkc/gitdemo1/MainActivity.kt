package com.hkc.gitdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.os.PersistableBundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel : MyViewModel
//    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.numberLiveData.observe(this, Observer {
            textView.text = "${it}"
        })

//        number = savedInstanceState?.getInt("NUMBER") ?:  0

        buttonAdd.setOnClickListener { myViewModel.add(1) }
        buttonSub.setOnClickListener { myViewModel.add(-1) }

//        textView.text = "${myViewModel.number}"
//        buttonAdd.setOnClickListener { textView.text = "${myViewModel.number++}" }
//        buttonSub.setOnClickListener { textView.text = "${myViewModel.number--}" }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)


    }

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//
//        outState.putInt("NUMBER",number)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menuRest){
            myViewModel.reset()
//            myViewModel.number = 0
//            textView.text = "${myViewModel.number}"
        }


        return super.onOptionsItemSelected(item)
    }
}