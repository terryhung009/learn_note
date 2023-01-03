package com.hkc.botanicalgardendemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;

    private ListView lstPrefer;
    String[] Balls = new String[]{"籃球","足球","棒球","其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult=(TextView)findViewById(R.id.textResult);
        lstPrefer=(ListView)findViewById(R.id.lstPrefer);


        //建立ArrayAdapter
        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                Balls);

        //這定ListView的資料來源
        lstPrefer.setAdapter(adapterBalls);
        ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //顯示listView的選項內容
                String sel=parent.getItemAtPosition(position).toString();
                txtResult.setText("我最喜歡的球類運動是 ；" + sel);
            }
        };

        //設定lstOrefer元件ItemClick 事件的 listener為 lstPreferListener
        lstPrefer.setOnItemClickListener(lstPreferListener);


    }
        //定義Onclick方法

    private ListView.OnItemClickListener lstPreferListener;

}
