package com.example.vovmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vovmusic.R;

public class Songsearch_result extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlist_result);

        TextView back = (TextView)  findViewById(R.id.huy);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Songsearch_result.this, Home.class);
                startActivity(intent);
            }
        });

        TextView baihat = (TextView) findViewById(R.id.song_2);
        baihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Songsearch_result.this, Playmusic.class);
                startActivity(intent);
            }
        });
    }
}
