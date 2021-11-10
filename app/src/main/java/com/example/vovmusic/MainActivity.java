package com.example.vovmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//import com.example.vovmusic.adapter.searchSongAdapter;
//import com.example.vovmusic.model.searchSong;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import song.Song;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        rcvCategory= findViewById(R.id.recyclerview_category);
        categoryAdapter= new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);


//        //click search
//        ImageView btnSearch = (ImageView) findViewById(R.id.btn_search);
//        btnSearch.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                setContentView(R.layout.search);
//                //    FragmentManager
//                //khoi tao 1 fragment -> PizzaMenuFragment là file
//                listViewFragment firstFragment = new listViewFragment();
//                // Add Fragment to FrameLayout (flContainer), using FragmentManager
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
//                ft.add(R.id.flContainer, firstFragment);                                // add    Fragment
//                //xac nhanMain
//                ft.commit();
//
//                }
//
//        });


//        //search_song_item click
//        ImageView searchSongItemClick = (ImageView) findViewById(R.id.img_song_search);
//        searchSongItemClick.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                setContentView(R.layout.search_details);
//            }
//        });

    }

    private List<Category> getListCategory(){
        List<Category> listCategory= new ArrayList<>();

        List <Song> listSong = new ArrayList<>();

        listSong.add(new Song(R.drawable.recommend_music2,"Name Song","Name Singer"));
        listSong.add(new Song(R.drawable.recommend_music,"Name Song","Name Singer"));
        listSong.add(new Song(R.drawable.my_playlist_2,"Name Song","Name Singer"));
        listSong.add(new Song(R.drawable.myplaylist_1,"Name Song","Name Singer"));
        listSong.add(new Song(R.drawable.my_playlist_2,"Name Song","Name Singer"));
        listSong.add(new Song(R.drawable.recommend_music,"Name Song","Name Singer"));
        listSong.add(new Song(R.drawable.recommend_music2,"Name Song","Name Singer"));



        listCategory.add(new Category("Recommended for you",listSong));
        listCategory.add(new Category("My PLayList",listSong));
        listCategory.add(new Category("Lided Song",listSong));
        listCategory.add(new Category("Popular",listSong));
        listCategory.add(new Category("Category",listSong));
        return listCategory;
    };
}