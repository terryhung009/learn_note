package com.hkc.atm.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hkc.atm.Model.Expense


@Dao
interface ExpenseDao {
    @Insert
    fun add(expense: Expense)

    @Query("select * from Expense")
    fun getAll(): List<Expense>

}