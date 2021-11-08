package com.example.vovmusic.Resetpass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.vovmusic.Login;
import com.example.vovmusic.R;
import com.example.vovmusic.Resetpass.Reset2;
public class Create extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpass);

        ImageView back = (ImageView)  findViewById(R.id.back);
        Button reset = (Button) findViewById(R.id.reset);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create.this, Login.class);
                startActivity(intent);
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
