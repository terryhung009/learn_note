package com.hkc.serializedemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hkc.serializedemo1.databinding.ActivityMainBinding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
//    EditText editTextName,editTextAge,editTextMath,editTextEnglish,editTextChinese;
//    TextView textViewGrade;
//    Button buttonSave,buttonLoad;
    ActivityMainBinding binding;
    private static final String FILE_NAME = "myfile.data";
    private static final String TAG = "mytag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int math = Integer.valueOf(binding.editTextMath.getText().toString());
                int english = Integer.valueOf(binding.editTextEnglish.getText().toString());
                int chinese = Integer.valueOf(binding.editTextChinese.getText().toString());
                Score score = new Score(math, english, chinese);
                String name = binding.editTextName.getText().toString();
                int age = Integer.valueOf(binding.editTextAge.getText().toString());
                Student student = new Student(name, age, score);

                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput(FILE_NAME, MODE_PRIVATE));
                    objectOutputStream.writeObject(student);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    Toast.makeText(MainActivity.this,"data_saved", Toast.LENGTH_LONG).show();
                    binding.editTextMath.getText().clear();
                    binding.editTextEnglish.getText().clear();
                    binding.editTextChinese.getText().clear();
                    binding.editTextAge.getText().clear();
                    binding.textViewGrade.setText("-");


                }catch (IOException e){
                    Log.e(TAG, "onclick",e);
                }

            }
        });

        binding.buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput(FILE_NAME));
                    Student student = (Student) objectInputStream.readObject();
                    binding.editTextName.setText( student.getName() );
                    binding.editTextAge.setText(String.valueOf(student.getAge()));
                    binding.editTextMath.setText(String.valueOf(student.getScore().getMath()));
                    binding.editTextEnglish.setText(String.valueOf(student.getScore().getEnglish()));
                    binding.editTextChinese.setText(String.valueOf(student.getScore().getChinese()));
                    binding.textViewGrade.setText(student.getScore().getGrade());







                }catch(IOException e){
                    Log.e(TAG, "OnClick: " + e);

                }catch (ClassNotFoundException e ){
                    Log.d(TAG,"OnClick: " + e);

                }
            }
        });

    }
}