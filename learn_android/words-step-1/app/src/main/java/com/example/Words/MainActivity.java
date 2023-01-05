package com.example.Words;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    Button buttonInsert,buttonClear;
//    WordViewModel wordViewModel;
//    RecyclerView recyclerView;
//    Switch aSwitch;
//    MyAdapter myAdapter1,myAdapter2;
//    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        navController = Navigation.findNavController(this,R.id.fragmentContainerView);
//        navController = Navigation.findNavController(findViewById(R.id.fragmentContainerView));
//        NavigationUI.setupActionBarWithNavController(this,navController);


//        wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
//        recyclerView = findViewById(R.id.recyclerView);
//        myAdapter1 = new MyAdapter(false,wordViewModel);
//        myAdapter2 = new MyAdapter(true,wordViewModel);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(myAdapter1);
//        aSwitch = findViewById(R.id.switch1);
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    recyclerView.setAdapter(myAdapter2);
//                } else {
//                    recyclerView.setAdapter(myAdapter1);
//                }
//            }
//        });
//
//        wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
//
//        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
//            @Override
//            public void onChanged(List<Word> words) {
//                int temp = myAdapter1.getItemCount();
//                myAdapter1.setAllWords(words);
//                myAdapter2.setAllWords(words);
//                if(temp!=words.size()){
//                    myAdapter1.notifyDataSetChanged();
//                    myAdapter2.notifyDataSetChanged();
//                }
//
//            }
//        });
//
//        buttonInsert = findViewById(R.id.buttonInsert);
//        buttonClear = findViewById(R.id.buttonClear);
//
//        buttonInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String[] english = {
//                        "Hello",
//                        "World",
//                        "Android",
//                        "Google",
//                        "Studio",
//                        "Project",
//                        "Database",
//                        "Recycler",
//                        "View",
//                        "String",
//                        "Value",
//                        "Integer"
//                };
//                String[] chinese = {
//                        "你好",
//                        "世界",
//                        "安卓系统",
//                        "谷歌公司",
//                        "工作室",
//                        "项目",
//                        "数据库",
//                        "回收站",
//                        "视图",
//                        "字符串",
//                        "价值",
//                        "整数类型"
//                };
//                for(int i = 0;i<english.length;i++) {
//                    wordViewModel.insertWords(new Word(english[i],chinese[i]));
//                }
//            }
//        });
//        buttonClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                wordViewModel.deleteAllWords();
//            }
//        });
//

    }


}
