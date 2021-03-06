package com.example.vovmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vovmusic.R;

public class Playmusic extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playmusic);

        ImageView back = (ImageView)  findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Playmusic.this, Home.class);
                startActivity(intent);
            }
        });

        ImageView pause = (ImageView)  findViewById(R.id.pause);


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Playmusic.this, Navigation.class);
                startActivity(intent);
            }
        });

    }
}
