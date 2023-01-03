package com.hkc.parcelabledemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hkc.parcelabledemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextName.getText().toString();
                int age = Integer.valueOf(binding.editTextAge.getText().toString());
                int Math =  Integer.valueOf(binding.editTextMath.getText().toString());
                int English = Integer.valueOf(binding.editTextEnglish.getText().toString());
                Student student = new Student(name,age,new Score(Math,English));

                MyApplication myApplication = (MyApplication) getApplication();
                myApplication.student = student;

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                //直接放入
//                intent.putExtra("student",student);
                //先打包成Bundle
//                Bundle bundle = new Bundle();
//                bundle.putParcelable("student",student);
//                intent.putExtra("data",bundle);
                startActivity(intent);

            }
        });




    }
}