package com.example.vovmusic;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class listViewFragment extends Fragment {

//    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
//            "WebOS","Ubuntu","Windows7","Max OS X"};
//    ArrayAdapter<String> itemsAdapter;
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        Log.d("oanh","onCreateView menu A  ");

        // Inflate the xml file for the fragment
        return inflater.inflate(R.layout.list_item_fragment, parent, false);


    }



//    //search_song_item click
//    ImageView searchSongItemClick = (ImageView) findViewById(R.id.img_song_search);
//        searchSongItemClick.setOnClickListener(new Button.OnClickListener() {
//        public void onClick(View v) {
//            setContentView(R.layout.search_details);
//        }
//
//
//    });

}
