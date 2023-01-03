package com.hkc.roombasicdemo2;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.hkc.roombasicdemo2.Word;

import java.util.List;

@Dao  //Database access object
public interface WordDao {
    @Insert
    void insertWords(Word...Words);

    @Update
    void updateWords(Word...Words);

    @Delete
    void deleteWords(Word...Words);

    @Query("DELETE FROM WORD")
    void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
//    List<Word> getAllWords();
    //第一次優化
    LiveData<List<Word>> getAllWordsLive();




}
