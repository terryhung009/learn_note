package com.hkc.lifecycletest2;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class Step2Activity extends AppCompatActivity {

    private MyChronometer chronometer;
    private long elapsedtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = this.findViewById(R.id.textview1);
        getLifecycle().addObserver(chronometer);


    }


}