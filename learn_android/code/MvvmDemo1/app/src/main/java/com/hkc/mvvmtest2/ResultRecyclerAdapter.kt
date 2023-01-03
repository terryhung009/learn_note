package com.hkc.mvvmtest2

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hkc.mvvmtest2.Viewmodel.ResultViewModel

class ResultRecyclerAdapter (
    private val viewModel: ResultViewModel
): RecyclerView.Adapter<ResultRecyclerAdapter.ResultViewHolder>() {

    class ResultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textId: TextView = itemView.findViewById(R.id.textItemResultId)
        val textContent: TextView= itemView.findViewById(R.id.textItemResultContent)
        val textPrint: TextView= itemView.findViewById(R.id.textItemResultPrint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemresult, parent, false))
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        holder.textId.text= viewModel.getAllText()[position]._id.toString()
        holder.textContent.text= viewModel.getAllText()[position].content
        holder.textPrint.text= viewModel.getAllText()[position].print()
    }

    override fun getItemCount(): Int = viewModel.getAllText().size


}