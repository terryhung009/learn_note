package com.hkc.roombasicdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    WordDatabase wordDatabase;
//    WordDao wordDao;
    Button buttonInsert,buttonClear,buttonUpdate,buttonDelete;
    TextView textView;
//    LiveData<List<Word>>allWordsLive;

    WordViewModel wordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

//        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "wordDatabase")
//                .allowMainThreadQueries()
//                .build();
//        wordDao = wordDatabase.getWordDao();

//        allWordsLive = wordDao.getAllWordsLive();
        


        buttonInsert = findViewById(R.id.buttonInsert);
        buttonClear = findViewById(R.id.buttonClear);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
        textView = findViewById(R.id.textView);



        //加入Livedata
        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                String text = "";
                for(int i=0;i<words.size();i++){
                Word word = words.get(i);
                text += word.getId()+ ":" + word.getWord() + "=" +word.getChineseMeaning()+"\n";


        }
        textView.setText(text);
            }
        });


        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("Hello", "你好");
                Word word2 = new Word("World", "世界");
                wordViewModel.insertWords(word1,word2);

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordViewModel.deleteAllWords();

            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("HI", "你好啊");
                word.setId(20);
                wordViewModel.updateWords(word);

            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("HI", "你好啊");
                word.setId(20);
                wordViewModel.deleteWords(word);

            }
        });



    }



}