package com.hkc.roombasicdemo1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordDao wordDao;
    private LiveData<List<Word>> allWordsLive;

    private WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);

//        WordDatabase wordDatabase = WordDatabase.getDatabase(application);
//        wordDao =wordDatabase.getWordDao();
//        allWordsLive = wordDao.getAllWordsLive();



    }

    public LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }

    public void setAllWordsLive(LiveData<List<Word>> allWordsLive) {
        this.allWordsLive = allWordsLive;
    }


    public void insertWords(Word...words){
        wordRepository.insertWords(words);
    }
    public void updateWords(Word...words){
        wordRepository.updateWords(words);
//        new UpdateAsyncTask(wordDao).execute(words);
    }
    public void deleteWords(Word...words){
        wordRepository.deleteWords(words);
//        new DeleteAsyncTask(wordDao).execute(words);
    }
    public void deleteAllWords(Word...words){
        wordRepository.deleteAllWords();
//        new DeleteAllAsyncTask(wordDao).execute();
    }



}
