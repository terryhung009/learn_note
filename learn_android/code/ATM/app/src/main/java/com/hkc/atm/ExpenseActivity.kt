package com.hkc.atm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.hkc.atm.Model.Expense
import com.hkc.atm.Model.ExpenseDatabase
import com.hkc.atm.databinding.ActivityExpenseBinding
import com.hkc.atm.databinding.ExpenseRowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class ExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpenseBinding
    private lateinit var binding2: ExpenseRowBinding
    private lateinit var database : ExpenseDatabase
//    private lateinit var adapter: RecyclerView.LayoutManager

    val expenseData = arrayListOf<Expense>(
        Expense("2021/02/01", "Lunch", 120),
//        Expense("2021/02/02", "停車費", 60),
//        Expense("2021/02/05", "日用品", 215),
//        Expense("2021/02/07", "Parking", 55),
//
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_expense)

        binding = ActivityExpenseBinding.inflate(layoutInflater)
        binding2 = ExpenseRowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        class ExpenseViewHolder(val expenseRowBinding: ExpenseRowBinding)
            :RecyclerView.ViewHolder(expenseRowBinding.root){
            val date = binding2.expDate
            val info = binding2.expInfo
            val amount = binding2.expAmount
        }



        //Query expenses
        CoroutineScope(Dispatchers.IO).launch{
        val expenses = database.expenseDao().getAll()
//        Log.d("TAG",expenses.size.toString())

        binding.recycler.layoutManager = LinearLayoutManager(this@ExpenseActivity)
        val adapter = object: RecyclerView.Adapter<ExpenseViewHolder>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
                val expenseRowBinding = ExpenseRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return ExpenseViewHolder(expenseRowBinding)
            }

            override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
                val exp = expenses.get(position)
                holder.expenseRowBinding.expDate.setText(exp.date)
                holder.expenseRowBinding.expInfo.setText(exp.info)
                holder.expenseRowBinding.expAmount.setText(exp.amount.toString())

            }

            override fun getItemCount(): Int {
                return expenses.size
            }

        }
            runOnUiThread {
//                binding.recycler.layoutManager = LinearLayoutManager(this@ExpenseActivity)
                binding.recycler.adapter = adapter

            }
    }


        binding.fab.setOnClickListener {
            database = Room.databaseBuilder(
                this,
                ExpenseDatabase::class.java, "expense.db")
                .build()

            CoroutineScope(Dispatchers.IO).launch {
                database.expenseDao().add(expenseData[0])
            }
//            Executors.newSingleThreadExecutor().execute {
//                database.expenseDao().add(expenseData[0])
//
//            }
        }
    }



}