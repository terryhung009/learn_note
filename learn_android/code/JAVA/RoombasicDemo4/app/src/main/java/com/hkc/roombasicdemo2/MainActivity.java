package com.hkc.roombasicdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button insertBtn,updateBtn,deleteBtn,clearBtn;
    Switch aSwitch;

    WordViewModel wordViewModel;
//    MyAdaper myAdaper;
    RecyclerView recyclerView;
    MyAdaper myAdaper1,myAdaper2;

    //textView 改用 recyclerView
    //    TextView textView;


//第一次優化  //改使用ViewModel 分離 處理data邏輯 codes
    //WordDatabase wordDatabase;
    //WordDao wordDao;

    //第一次優化    //改使用ViewModel
    //LiveData<List<Word>>allWordsLive;
    //





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



        //recyclerView所需資料
        recyclerView = findViewById(R.id.recyclerView);
        myAdaper1 = new MyAdaper(false);
        myAdaper2 = new MyAdaper(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdaper1);
        aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    recyclerView.setAdapter(myAdaper2);
                }else{
                    recyclerView.setAdapter(myAdaper1);
                }
            }
        });

//        textView = findViewById(R.id.textView);

        //改使用ViewModel
//        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "word database")
//                .allowMainThreadQueries()
//                .build();
//        wordDao = wordDatabase.getWordDao();


        //第一次優化加入
//        allWordsLive = wordDao.getAllWordsLive();

        //第一次優化刪除
//        updateView();

        //LiveData observer 改到ViewModel
//        allWordsLive.observe(this, new Observer<List<Word>>() {
        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                myAdaper1.setAllWords(words);
                myAdaper2.setAllWords(words);
                myAdaper1.notifyDataSetChanged();
                myAdaper2.notifyDataSetChanged();
            }

            //改用recyclerView
//            @Override
//            public void onChanged(List<Word> words) {
//                StringBuilder text = new StringBuilder();
//                for(int i=0;i<words.size();i++){
//                    Word word = words.get(i);
//                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
//
//
//                }
//                textView.setText(text.toString());
//            }
        });



        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] english = {
                        "Hello",
                        "World",
                        "Android",
                        "Google",

                };
                String[] chinese = {
                  "你好",
                  "世界",
                  "安卓系統",
                  "谷歌公司",

                };
                for(int i=0;i<english.length;i++){
                    wordViewModel.insertWords(new Word(english[i],chinese[i]));
                }


//                Word word1 = new Word("Hello", "你好");
//                Word word2 = new Word("World", "世界");
//                wordViewModel.insertWords(word1,word2);


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