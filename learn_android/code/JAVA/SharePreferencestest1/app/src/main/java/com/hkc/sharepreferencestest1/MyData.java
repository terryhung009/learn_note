package com.hkc.sharepreferencestest1;

import android.content.Context;
import android.content.SharedPreferences;

public class MyData {

    public int number;
    private Context context;
    public MyData(Context context){
        this.context = context;
    };

    public void save(){
        String name = context.getResources().getString(R.string.MY_DATA);
        SharedPreferences shp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        String Key = context.getResources().getString(R.string.MY_KEY);
        editor.putInt(Key,number);
        editor.apply();

    };

    public int load(){
        String name = context.getResources().getString(R.string.MY_DATA);
        SharedPreferences shp = context.getSharedPreferences(name,Context.MODE_PRIVATE);
        String Key = context.getResources().getString(R.string.MY_KEY);
        int defvalue = context.getResources().getInteger(R.integer.defValue);
        int x = shp.getInt(Key,defvalue);
        number = x;
        return x;




    };

}
