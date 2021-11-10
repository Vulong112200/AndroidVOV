package com.example.vovmusic;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import song.Song;

public class Home extends AppCompatActivity {
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

        ImageView searchSongItemClick = (ImageView) findViewById(R.id.btn_search);
        searchSongItemClick.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Songsearch.class);
                startActivity(intent);
            }
            ;
        });

    ImageView menu = (ImageView) findViewById(R.id.btn_menu);
        menu.setOnClickListener(new Button.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(Home.this, Navigation.class);
            startActivity(intent);
        }
        ;
    });
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
        listCategory.add(new Category("Liked Song",listSong));
        listCategory.add(new Category("Popular",listSong));
        listCategory.add(new Category("Category",listSong));
        return listCategory;
    };

}
