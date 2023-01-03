package com.hkc.livedatatest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLivedata viewModelWithLivedata;
    TextView textView;
    ImageView imageButtonLike,imageButtonDisike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageButtonLike = findViewById(R.id.imageButtonLike);
        imageButtonDisike = findViewById(R.id.imageButtonDisike);

        viewModelWithLivedata = new ViewModelProvider(this).get(ViewModelWithLivedata.class);
        viewModelWithLivedata.getLikedNumber().observe(this,new Observer<Integer>(){

            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });

        imageButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLivedata.addLikedNumber(1);
            }
        });
        imageButtonDisike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModelWithLivedata.addLikedNumber(-1);
            }
        });


    }
}