package com.hkc.sharepreferencestest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyData myData = new MyData(getApplicationContext());

//        String a = getString(R.string.MY_DATA);
        myData.number = 1000;
        myData.save();
        int y = myData.load();
        Log.d("Mylog","onCreate " + y);


//        SharedPreferences shp = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences shp = getSharedPreferences("MyData",Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = shp.edit();
//        editor.putInt("NUMBER",100);
//        editor.apply();
//
//        number = shp.getInt("NUMBER",0);
//        String TAG = "MyLog";
//        Log.d(TAG,"on create :" + number);

    }
}