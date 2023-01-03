package com.hkc.lifecycletest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class Step1Activity extends AppCompatActivity {

    private Chronometer chronometer;
    private long elapsedtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = this.findViewById(R.id.textview1);



    }

    @Override
    protected void onResume() {
        super.onResume();
        chronometer.setBase(SystemClock.elapsedRealtime() - elapsedtime);
        chronometer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        elapsedtime = SystemClock.elapsedRealtime() - chronometer.getBase();
        chronometer.stop();
    }
}