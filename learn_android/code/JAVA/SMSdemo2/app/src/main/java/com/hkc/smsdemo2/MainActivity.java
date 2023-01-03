package com.hkc.smsdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText et_message,et_phone;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.sendButton);
        et_message = findViewById(R.id.et_message);
        et_phone = findViewById(R.id.et_phone);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_message != null && et_phone != null) {
                    text = String.valueOf(et_message.getText());
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "0908123456", null));
                intent.putExtra("sms_body", text);
                startActivity(intent);
            }


        });
    }


}