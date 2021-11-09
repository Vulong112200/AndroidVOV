package com.example.vovmusic;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vovmusic.R;
import com.example.vovmusic.adapter.StudentAdapter;
import com.example.vovmusic.model.Student;

import java.util.ArrayList;
import java.util.List;
public class Likedsong extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentAdapter adapter;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentlist);
        recyclerView = findViewById(R.id.studentsList);

        students = new ArrayList<Student>();
        //Tự phát sinh 50 dữ liệu mẫu
        for (int i = 1; i <= 50; i++) {
            students.add(new Student("Student Name"+i , 1995 + (i % 2)));
        }

        adapter = new StudentAdapter(students, this) {
            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }
        };

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}
