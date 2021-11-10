//package com.example.vovmusic;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.ListView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.vovmusic.adapter.searchSongAdapter;
//import com.example.vovmusic.model.searchSong;
//
//import java.util.ArrayList;
//
//
//public class SearchDisplay extends Activity {
//
////    // Array of strings...
////    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
////            "WebOS","Ubuntu","Windows7","Max OS X"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Log.d("oanh", "onClick: item click");
//
////        setContentView(R.layout.list_item_fragment);
//        RecyclerView recyclerView;
//        ArrayList<searchSong> listSanPham;
//        searchSongAdapter searchSongAdapter;
//        recyclerView=findViewById(R.id.recyclerview);
//
//        listSanPham=new ArrayList<>();
//        listSanPham.add(new searchSong("Xiaomi Mi 10",12000000,R.drawable.my_playlist_2));
////                    listSanPham.add(new SanPham("Iphone X",19000000,R.drawable.iphonex));
////                    listSanPham.add(new SanPham("Iphone 11",23000000,R.drawable.iphone_11));
////                    listSanPham.add(new SanPham("Xiaomi black shark 3",14000000,R.drawable.black_sharp3));
////                    listSanPham.add(new SanPham("Samsung galaxy s10",14000000,R.drawable.galaxy_s10));
////                    listSanPham.add(new SanPham("Oppo reno 3",10000000,R.drawable.oppo));
////                    listSanPham.add(new SanPham("Samsung note 10",14000000,R.drawable.samsungnote10));
////                    listSanPham.add(new SanPham("Iphone 8",17000000,R.drawable.iphone8));
//        searchSongAdapter=new searchSongAdapter(getApplicationContext(),listSanPham);
//        recyclerView.setAdapter(searchSongAdapter);
//
//
//
//
//
//
//
//    }
//}
