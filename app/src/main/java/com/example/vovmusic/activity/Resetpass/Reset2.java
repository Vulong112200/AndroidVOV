package com.example.vovmusic.activity.Resetpass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vovmusic.activity.Login;
import com.example.vovmusic.R;

public class Reset2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpass2);
        
        ImageView back = (ImageView) findViewById(R.id.back);
        Button open = (Button) findViewById(R.id.open);
        TextView skip = (TextView) findViewById(R.id.skip);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reset2.this, Reset.class);
                startActivity(intent);
            }
        });


        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reset2.this, Create.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reset2.this, Login.class);
                startActivity(intent);
            }
        });
    }
}