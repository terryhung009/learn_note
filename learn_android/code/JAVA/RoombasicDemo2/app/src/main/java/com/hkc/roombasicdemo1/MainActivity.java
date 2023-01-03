package com.hkc.roombasicdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import androidx.room.Update;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //改使用ViewModel 分離 處理data邏輯 codes
    //WordDatabase wordDatabase;
    //WordDao wordDao;
    Button insertBtn,updateBtn,deleteBtn,clearBtn;
    TextView textView;

    //第一次優化    //改使用ViewModel
//    LiveData<List<Word>>allWordsLive;
    //
    //ViewModel分離 處理data邏輯 codes
    WordViewModel wordViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建立ViewModel實例
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        insertBtn = findViewById(R.id.insertBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        clearBtn = findViewById(R.id.clearBtn);
        textView = findViewById(R.id.textView);

        //改使用ViewModel
//        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word database")
//                .allowMainThreadQueries()
//                .build();
//        wordDao = wordDatabase.getWordDao();


        //第一次優化加入
//        allWordsLive = wordDao.getAllWordsLive();

        //第一次優化刪除
//        updateView();

//        allWordsLive.observe(this, new Observer<List<Word>>() {
        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for(int i=0;i<words.size();i++){
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");


                }
                textView.setText(text.toString());
            }
        });



        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("Hello", "你好");
                Word word2 = new Word("World", "世界");
                wordViewModel.insertWords(word1,word2);


                //第二次優化刪除
//                new InsertAsyncTask(wordDao).execute(word1,word2);

                //第一次優化刪除
//                wordDao.insertWords(word1,word2);
//                updateView();

            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordViewModel.deleteAllWords();
                //第二次優化刪除
//                new DeleteAllAsyncTask(wordDao).execute();
                //
//                wordDao.deleteAllWords();
//                updateView();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("Hi", "你好阿");
                word.setId(30);
                wordViewModel.updateWords(word);

//                new UpdateAsyncTask(wordDao).execute(word);

//                wordDao.updateWords(word);
//                updateView();

            }

        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("","");
                word.setId(29);
                //
                wordViewModel.deleteWords(word);

                //第二次優化刪除
//                new DeleteAsyncTask(wordDao).execute(word);
                //第一次優化刪除
//                wordDao.deleteWords(word);
//                updateView();
            }
        });

    }

//    void updateView(){
//        List<Word> list = wordDao.getAllWords();
//        String text = "";
//        for(int i=0;i<list.size();i++){
//            Word word = list.get(i);
//            text += word.getId() + ":" + word.getWord() + "=" + word.getChineseMeaning() + "\n";
//
//
//        }
//        textView.setText(text);
//
//    }

}