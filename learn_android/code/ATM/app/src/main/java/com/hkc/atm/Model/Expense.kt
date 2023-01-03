package com.hkc.atm.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Expense (
    @ColumnInfo(name = "日期") var date: String,
    @ColumnInfo(name = "資訊") var info: String,
    @ColumnInfo(name = "價錢") var amount: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}