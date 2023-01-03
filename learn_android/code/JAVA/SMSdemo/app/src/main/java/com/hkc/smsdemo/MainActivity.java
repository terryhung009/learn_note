package com.hkc.smsdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    final int SEND_SMS_CODE = 100;
    Button sendButton;
    EditText et_message,et_phone;

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
            int permission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS);
            if ( permission == PackageManager.PERMISSION_GRANTED ){
                sendMseeage();
            }else{
                requestPermissions();

            }

        }


    });

    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_CODE);

    }

    private void sendMseeage() {
        //
        String sPhone = et_phone.getText().toString().trim();
        String sMessage = et_message.getText().toString().trim();
        //
        if(!sPhone.equals("")  && !sMessage.equals("")){
            //
            //
            SmsManager smsManager = SmsManager.getDefault();
            //Send Text Message
            smsManager.sendTextMessage(sPhone,null,sMessage,null,null);
            //
            Toast.makeText(getApplicationContext(),"SMS send Successful!",Toast.LENGTH_LONG).show();

        }else{
            //
            Toast.makeText(getApplicationContext(),"Enter value first",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //
        if (requestCode == SEND_SMS_CODE && grantResults.length> 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            sendMseeage();
        }else{
//            requestPermissions();
            Toast.makeText(getApplicationContext(), "Permission Denied!", Toast.LENGTH_LONG).show();
        
        }
    }
}