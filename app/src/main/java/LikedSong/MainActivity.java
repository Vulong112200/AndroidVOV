package LikedSong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
    RecyclerView recyclerView;
    List<Song> songs;
    private static String JSON_URL = "https://vovmusic.herokuapp.com/liked-songs";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liked_song);

        recyclerView = findViewById(R.id.songsList);
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

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(gridLayoutManager);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(),songs);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse like song : " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }
}
