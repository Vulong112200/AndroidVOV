package com.example.vovmusic;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vovmusic.adapter.SongAdapter;
import com.example.vovmusic.model.Song;

import java.util.ArrayList;

public class Likedsong extends AppCompatActivity {
    RecyclerView recyclerView;
    SongAdapter adapter;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songtlist);
        recyclerView = findViewById(R.id.studentsList);

        songs = new ArrayList<Song>();
        //Tự phát sinh 50 dữ liệu mẫu
        for (int i = 1; i <= 50; i++) {
            songs.add(new Song("Song Name"+i , "Ca sĩ" + (i % 2)));
        }

        adapter = new SongAdapter(songs, this);
        recyclerView.setAdapter(adapter);

        int spanCount = 2;//Số cột nếu thiết lập lưới đứng, số dòng nếu lưới ngang
        int orientation = GridLayoutManager.VERTICAL;//Lưới ngang
        //int orientation = GridLayoutManager.HORIZONTAL;//Lưới đứng

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        ImageView back = (ImageView)  findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Likedsong.this, Home.class);
                startActivity(intent);
            }
        });

    }
}
