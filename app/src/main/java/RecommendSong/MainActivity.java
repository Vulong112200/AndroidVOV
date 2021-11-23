package RecommendSong;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.vovmusic.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    RecyclerView recyclerView2; RecyclerView recyclerView3;


    List<Song> songs;
    private static String JSON_URL = "https://vovmusic.herokuapp.com/liked-songs";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);

//        ==========================================

//        =========================================

          recyclerView3= findViewById(R.id.recyclerview_category3);
         recyclerView1 = findViewById(R.id.recyclerview_category1);
         recyclerView2 = findViewById(R.id.recyclerview_category2);
        songs = new ArrayList<>();
        extractSongs();
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
                        Log.d("tag", "Response: ");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getApplicationContext(),1 );
                GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getApplicationContext(),1 );
                GridLayoutManager gridLayoutManager3 = new GridLayoutManager(getApplicationContext(),1 );

                gridLayoutManager1.setOrientation(GridLayoutManager.HORIZONTAL);
                gridLayoutManager2.setOrientation(GridLayoutManager.HORIZONTAL);
                gridLayoutManager3.setOrientation(GridLayoutManager.HORIZONTAL);


                recyclerView1.setLayoutManager(gridLayoutManager1);
                recyclerView2.setLayoutManager(gridLayoutManager2);
                recyclerView3.setLayoutManager(gridLayoutManager3);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(),songs);
                recyclerView1.setAdapter(adapter);
                recyclerView2.setAdapter(adapter);
                recyclerView3.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: recommend " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }
}
