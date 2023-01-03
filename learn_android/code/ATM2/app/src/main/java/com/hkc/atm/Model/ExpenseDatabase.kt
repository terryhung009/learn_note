package com.hkc.atm.Model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hkc.atm.Model.Expense
import com.hkc.atm.Model.ExpenseDao


@Database(entities = arrayOf(Expense::class),version = 1)
abstract class ExpenseDatabase: RoomDatabase(){
    abstract fun expenseDao(): ExpenseDao
}