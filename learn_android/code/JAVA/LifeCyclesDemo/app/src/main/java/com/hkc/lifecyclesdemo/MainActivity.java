package com.hkc.lifecyclesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
//    Chronometer chronometer;
    MyChronometer chronometer;
//    private long elapsedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer =  findViewById(R.id.meter);
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        chronometer.start();
        getLifecycle().addObserver(chronometer);


    }

    @Override
    protected void onPause() {
        super.onPause();

//        elapsedTime = SystemClock.elapsedRealtime()-chronometer.getBase();
//        chronometer.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();

//        chronometer.setBase(SystemClock.elapsedRealtime()-elapsedTime);
//        chronometer.start();
    }
}