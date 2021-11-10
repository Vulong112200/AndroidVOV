package com.example.vovmusic;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity{


    Toolbar toolbar;
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        anhXa();
        actionToolBar();
    }
    private void actionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawerlayout.openDrawer(GravityCompat.START);

            }
        });
    }
    private void anhXa(){
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationview = (NavigationView) findViewById(R.id.navigation_view);
        listview = (ListView) findViewById(R.id.list_view);
    }
}