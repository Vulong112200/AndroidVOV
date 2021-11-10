//package com.example.vovmusic;
//
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.vovmusic.model.searchSong;
//
//public class SearchDetail extends AppCompatActivity {
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.search_details_fragment);
//
//        Bundle bundle=getIntent().getExtras();
//        if(bundle==null) return;
//        searchSong song = (searchSong) bundle.get("key");
//
//        TextView tvSongName =findViewById(R.id.song_name);
//        tvSongName.setText("oanh ne");
//
//    }
//}
