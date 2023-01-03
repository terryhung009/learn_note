package com.hkc.roombasicdemo1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


//singleton
@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract  class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTANCE;
    public synchronized static WordDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordDatabase.class, "wordDatabase")
//                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public abstract WordDao getWordDao();
}
