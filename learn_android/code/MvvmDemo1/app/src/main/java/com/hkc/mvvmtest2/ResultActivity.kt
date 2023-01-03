package com.hkc.mvvmtest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hkc.mvvmtest2.Viewmodel.MyViewModelFactory
import com.hkc.mvvmtest2.Viewmodel.ResultViewModel

class ResultActivity : AppCompatActivity() {

    private val viewModel: ResultViewModel by lazy {
        ViewModelProvider(this, MyViewModelFactory()).get(ResultViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val recyclerView: RecyclerView = findViewById(R.id.listResult)

        recyclerView.adapter = ResultRecyclerAdapter(viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //
//        recyclerView.apply {
//            adapter= ResultRecyclerAdapter(viewModel)
//            layoutManager= LinearLayoutManager(context)
//        }
    }
}