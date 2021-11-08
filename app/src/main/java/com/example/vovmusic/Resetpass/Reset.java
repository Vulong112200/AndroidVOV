package com.example.vovmusic.Resetpass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vovmusic.Login;
import com.example.vovmusic.MainActivity;
import com.example.vovmusic.R;
import com.example.vovmusic.Resetpass.Reset2;

public class Reset extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpass);

        ImageView back = (ImageView)  findViewById(R.id.back);
        Button send = (Button) findViewById(R.id.send);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reset.this, Login.class);
                startActivity(intent);
                Log.d("Login", "onRestart - Màn hình chính được khởi tạo lại.");
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Reset.this, Reset2.class);
                startActivity(intent);
            }
        });
    }
}
