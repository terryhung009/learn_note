package com.hkc.jsondemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();

//        Student student1 = new Student("Mike",20,new Score(90,87,67));
//        Student student2 = new Student("Lisa",20,new Score(80,87,67));
        List<Student>studentList = new ArrayList<>();
//        studentList.add(student1);
//        studentList.add(student2);
        String jsonStudents = "[\n" +
                "  {\n" +
                "    \"age\": 20,\n" +
                "    \"name\": \"Mike\",\n" +
                "    \"score\": {\n" +
                "      \"chinese\": 67,\n" +
                "      \"english\": 87,\n" +
                "      \"math\": 90\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"age\": 20,\n" +
                "    \"name\": \"Lisa\",\n" +
                "    \"score\": {\n" +
                "      \"chinese\": 67,\n" +
                "      \"english\": 87,\n" +
                "      \"math\": 80\n" +
                "    }\n" +
                "  }\n" +
                "]";
//        studentList = gson.fromJson(jsonStudents,)
        Type typeStudents = new TypeToken<List<Student>>(){}.getType();
        studentList = gson.fromJson(jsonStudents,typeStudents);

        Student student3 = new Student("Rose",20,new Score(90,90,90));
        String jsonStudent3 = gson.toJson(student3);

    }


}



