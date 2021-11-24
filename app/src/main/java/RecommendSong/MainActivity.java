package RecommendSong;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.vovmusic.R;
import com.example.vovmusic.activity.Login;
import com.example.vovmusic.activity.Register;
import com.example.vovmusic.activity.Songsearch;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    RecyclerView recyclerView2; RecyclerView recyclerView3;

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    List<Song> songs;
    private static String JSON_URL = "https://vovmusic.herokuapp.com/liked-songs";
    Adapter adapter;
    private TextView likedsong;
    private ImageView btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);

//        ==========================================

//        =========================================
        songs = new ArrayList<>();
        extractSongs();
//          recyclerView3= findViewById(R.id.recyclerview_category3);
        recyclerView1 = findViewById(R.id.recyclerview_category1);
        likedsong=(TextView) findViewById(R.id.likedsong);
        btn_search =(ImageView) findViewById(R.id.btn_search);
        likedsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LikedSong.MainActivity.class);
                startActivity(intent);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Songsearch.class);
                startActivity(intent);
            }
        });
//        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);

//        recyclerView1.setLayoutManager(linearLayoutManager);

//        categoryAdapter.setData(getListCategory());
//          recyclerView1.setAdapter(categoryAdapter);
//         recyclerView2 = findViewById(R.id.recyclerview_category2);

        categoryAdapter= new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);

        recyclerView1.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        recyclerView1.setAdapter(categoryAdapter);
        Log.v("TAG", "getListCategory: "+songs);

    }

    private void extractSongs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject songObject = response.getJSONObject(i);

                        Song song = new Song();
                        song.setTitle(songObject.getString("songName").toString());
                        song.setSinger(songObject.getString("singer ").toString());

                        song.setCoverImage(songObject.getString("imageSongURL"));
//                      song.setSongURL(songObject.getString("url"));imageSongURL
                        songs.add(song);
                        Log.d("tag", "Response: "+songs);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    List<Category> listCategory= new ArrayList<>();
                    listCategory.add(new Category("Recommended for you",songs));
                    listCategory.add(new Category("Popular Artist",songs));
                    listCategory.add(new Category("Favorite Artist",songs));


                    listCategory.add(new Category("My PLayList",songs));
                    listCategory.add(new Category("Liked Song",songs));

                    categoryAdapter.setData(listCategory);
                    recyclerView1.setAdapter(categoryAdapter);
//        listCategory.add(new Category("Popular",songs));
//        listCategory.add(new Category("Category",songs));
                    Log.v("TAG", "getListCategory: "+songs);

                }
//                LinearLayoutManager linearLayoutManager4= new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
//
//
//
//                categoryAdapter.setData(getListCategory());
//                recyclerView1.setAdapter(categoryAdapter);
//                LinearLayoutManager linearLayoutManager1= new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
//                LinearLayoutManager linearLayoutManager2= new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
//                LinearLayoutManager linearLayoutManager3= new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL,false);
//                LinearLayoutManager linearLayoutManager4= new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);

//                recyclerView1.setLayoutManager(linearLayoutManager1);
//                recyclerView2.setLayoutManager(linearLayoutManager2);
//                recyclerView3.setLayoutManager(linearLayoutManager3);


//                GRIDLAYOUT

//                GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getApplicationContext(),1 );
//                GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getApplicationContext(),1 );
//                GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getApplicationContext(),1 );
//
//                gridLayoutManager1.setOrientation(GridLayoutManager.HORIZONTAL);
//                gridLayoutManager2.setOrientation(GridLayoutManager.HORIZONTAL);
//                gridLayoutManager3.setOrientation(GridLayoutManager.HORIZONTAL);

//
//                recyclerView1.setLayoutManager(gridLayoutManager1);
//                recyclerView2.setLayoutManager(gridLayoutManager2);
//                recyclerView3.setLayoutManager(gridLayoutManager3);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

//                adapter = new Adapter(getApplicationContext(),songs);
//                recyclerView1.setAdapter(adapter);
//                recyclerView2.setAdapter(adapter);
//                recyclerView3.setAdapter(adapter);




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: recommend " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }

    private List<Category> getListCategory(){
        List<Category> listCategory= new ArrayList<>();

        List <Song> listSong = new ArrayList<>();
//
//        listSong.add(new Song(R.drawable.recommend_music2,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.recommend_music,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.my_playlist_2,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.myplaylist_1,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.my_playlist_2,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.recommend_music,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.recommend_music2,"Name Song","Name Singer"));



        listCategory.add(new Category("Recommended for you",listSong));
        listCategory.add(new Category("My PLayList",listSong));
        listCategory.add(new Category("Lided Song",listSong));
//        listCategory.add(new Category("Popular",songs));
//        listCategory.add(new Category("Category",songs));
        Log.v("TAG", "getListCategory: "+listSong);
        return listCategory;

    };

}
