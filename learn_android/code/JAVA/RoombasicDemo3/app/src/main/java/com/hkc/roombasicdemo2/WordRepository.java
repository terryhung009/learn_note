package com.hkc.roombasicdemo2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private LiveData<List<Word>>allWordsLive;
    WordDao wordDao;


    public WordRepository(Context context) {
        WordDatabase wordDatabase = WordDatabase.getDatabase(context.getApplicationContext());
//        WordDatabase wordDatabase = WordDatabase.getDatabase(context);
        //寫錯了要記住
//        WordDao wordDao = wordDatabase.getWordDao();

        wordDao = wordDatabase.getWordDao();
        allWordsLive = wordDao.getAllWordsLive();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    void insertWords(Word...words){
        new InsertAsyncTask(wordDao).execute(words);
    }
    void updateWords(Word...words){
        new UpdateAsyncTask(wordDao).execute(words);
    }
    void deleteWords(Word...words){
        new DeleteAsyncTask(wordDao).execute(words);
    }
    void deleteAllWords(Void...voids){
        new DeleteAllAsyncTask(wordDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Word,Void,Void> {
        WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;

        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;

        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
    static class UpdateAsyncTask extends AsyncTask<Word,Void,Void> {
        WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;

        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;

        }
    }
    static class DeleteAsyncTask extends AsyncTask<Word,Void,Void> {
        WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;

        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;

        }
    }
    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void> {
        WordDao wordDao;

        public DeleteAllAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;

        }
        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;

        }
    }



}
