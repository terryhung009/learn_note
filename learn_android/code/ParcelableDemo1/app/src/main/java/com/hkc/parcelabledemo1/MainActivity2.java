package com.hkc.parcelabledemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.hkc.parcelabledemo1.databinding.ActivityMain2Binding;
import com.hkc.parcelabledemo1.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);

        Intent intent = getIntent();

        MyApplication myApplication = (MyApplication) getApplication();
        Student student = myApplication.student;

//        Bundle bundle = intent.getBundleExtra("data");
//        Student student = bundle.getParcelable("student");

        //數據放到textview
        binding.textViewName.setText(student.getName());
        binding.textViewAge.setText(String.valueOf(student.getAge()));
        binding.textViewMath.setText(String.valueOf(student.getScore().getMath()));
        binding.textViewEnglish.setText(String.valueOf(student.getScore().getEnglish()));


    }
}