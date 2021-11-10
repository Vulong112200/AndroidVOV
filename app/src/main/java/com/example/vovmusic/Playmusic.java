package com.example.vovmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
