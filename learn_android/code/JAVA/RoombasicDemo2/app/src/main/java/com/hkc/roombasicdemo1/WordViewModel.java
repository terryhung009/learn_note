package com.hkc.roombasicdemo1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {


    private WordRepository wordRepository;

    //第三次修改  放到Repository
//    private LiveData<List<Word>>allWordsLive;
    private WordDao wordDao;

    public WordViewModel(@NonNull Application application) {
        super(application);

        //第三次修改  放到Repository
//        WordDatabase wordDatabase = WordDatabase.getDatabase(application);
//        wordDao = wordDatabase.getWordDao();
//        allWordsLive = wordDao.getAllWordsLive();
        //
        wordRepository = new WordRepository(application);



    }

    public LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();

        //第三次修改
//        return allWordsLive;
    }

    void insertWords(Word...words){
        wordRepository.insertWords(words);

//        new InsertAsyncTask(wordDao).execute(words);
    }
    void updateWords(Word...words){
        wordRepository.updateWords(words);
//        new UpdateAsyncTask(wordDao).execute(words);
    }
    void deleteWords(Word...words){
        wordRepository.deleteWords(words);
//        new DeleteAsyncTask(wordDao).execute(words);
    }
    void deleteAllWords(){
        wordRepository.deleteAllWords();

//        new DeleteAllAsyncTask(wordDao).execute();
    }
        //第三次修改  放到Repository
//    static class InsertAsyncTask extends AsyncTask<Word,Void,Void> {
//        WordDao wordDao;
//
//        public InsertAsyncTask(WordDao wordDao) {
//            this.wordDao = wordDao;
//
//        }
//
//        @Override
//        protected Void doInBackground(Word... words) {
//            wordDao.insertWords(words);
//            return null;
//
//        }
//
//        @Override
//        protected void onPostExecute(Void unused) {
//            super.onPostExecute(unused);
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//    }
//    static class UpdateAsyncTask extends AsyncTask<Word,Void,Void> {
//        WordDao wordDao;
//
//        public UpdateAsyncTask(WordDao wordDao) {
//            this.wordDao = wordDao;
//
//        }
//        @Override
//        protected Void doInBackground(Word... words) {
//            wordDao.updateWords(words);
//            return null;
//
//        }
//    }
//    static class DeleteAsyncTask extends AsyncTask<Word,Void,Void> {
//        WordDao wordDao;
//
//        public DeleteAsyncTask(WordDao wordDao) {
//            this.wordDao = wordDao;
//
//        }
//        @Override
//        protected Void doInBackground(Word... words) {
//            wordDao.deleteWords(words);
//            return null;
//
//        }
//    }
//    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void> {
//        WordDao wordDao;
//
//        public DeleteAllAsyncTask(WordDao wordDao) {
//            this.wordDao = wordDao;
//
//        }
//        @Override
//        protected Void doInBackground(Void... voids) {
//            wordDao.deleteAllWords();
//            return null;
//
//        }
//    }


}
