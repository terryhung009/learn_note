package com.hkc.roombasicdemo1;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    public void insertWord(Word...words);

    @Update
    public void updateWord(Word...words);

    @Delete
    public void deleteWord(Word...words);

    @Query("DELETE FROM WORD")
    public void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
//    List<Word> getAllWords();
    LiveData<List<Word>>getAllWordsLive();
}
