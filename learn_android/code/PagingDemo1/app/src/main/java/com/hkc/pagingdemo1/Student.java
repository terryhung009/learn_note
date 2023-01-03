package com.hkc.pagingdemo1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.jar.Attributes;

@Entity(tableName = "student_table")
public class Student {
    @PrimaryKey(autoGenerate = true)private int id;
    @ColumnInfo(name = "student_number")private int student_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }
}
