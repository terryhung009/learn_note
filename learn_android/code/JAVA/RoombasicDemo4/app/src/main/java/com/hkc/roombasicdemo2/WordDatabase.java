package com.hkc.roombasicdemo2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

//SINGLETON
@Database(entities = {Word.class},version = 3,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    private static WordDatabase INSTANCE;
    static synchronized WordDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word database")
//                    .addMigrations(MIGRATION_2_3)
//                      .addMigrations(MIGRATION_3_4)
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return INSTANCE;
    }
    public abstract WordDao getWordDao();


    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1");
            database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1");
    database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1");

        }
    };

//    static final Migration MIGRATION_3_4 = new Migration(3,4) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL , english_word TEXT,chinese_meaning)");
//            database.execSQL("INSERT INTO word_temp (id,english_word,chinese_meaning) SELECT id,english_word,chinese_meaning FROM word");
//            database.execSQL("DROP TABLE word");
//            database.execSQL("ALTER TABLE word_temp RENAME to word");
//
//        }
//    };

}
