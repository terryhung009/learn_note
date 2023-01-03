package com.hkc.sqlitetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//自訂建構子並繼承SQLiteOpenHelper類別
class MyDBHelper (
    context: Context,
    name: String = database,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = v
    ): SQLiteOpenHelper(context, name, factory, version){
    companion object{
        private const val database = "myDatabase"       //資料庫名稱
        private const val v = 1                         //資料庫版本


    }

    override fun onCreate(db: SQLiteDatabase?) {
        //建立MyTable資料夾，表內有book字串欄位和price整數欄位
        db?.execSQL(
            "CREATE TABLE myTable(book text PRIMARY KEY, price integer NOT NULL)")


    }

    override fun onUpgrade(db:SQLiteDatabase, oldversion: Int, newVersion: Int){
        //升級資料庫版本時，刪除舊資料表，並重新執行onCreate()，建立新資料表
        db.execSQL("DROP TABLE IF EXISTS myTable")
        onCreate(db)


    }






}