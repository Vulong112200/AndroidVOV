package com.example.vovmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.vovmusic.adapter.searchSongAdapter;
import com.example.vovmusic.model.searchSong;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        ImageView btnSearch = (ImageView) findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.search);
                //    FragmentManager
                //khoi tao 1 fragment -> PizzaMenuFragment là file
                listViewFragment firstFragment = new listViewFragment();
                // Add Fragment to FrameLayout (flContainer), using FragmentManager
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
                ft.add(R.id.flContainer, firstFragment);                                // add    Fragment
                //xac nhanMain
                ft.commit();

                //


                }

        });


//        //search_song_item click
//        ImageView searchSongItemClick = (ImageView) findViewById(R.id.img_song_search);
//        searchSongItemClick.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                setContentView(R.layout.search_details);
//            }
//        });
//


    }
}