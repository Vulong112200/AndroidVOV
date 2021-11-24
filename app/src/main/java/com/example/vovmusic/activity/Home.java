package com.example.vovmusic.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vovmusic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import song.Song;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //bỏ
    static boolean chk = false;
    private BottomNavigationView nav_bottom;
    private ViewPager main_viewpager;
    private Toolbar toolbar;
    private DrawerLayout main_drawerlayout;
    private NavigationView main_menu;
    private long backpresstime;
    String userid;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mainintent = this.getIntent();
        userid = mainintent.getStringExtra("id");

        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        main_drawerlayout = findViewById(R.id.main_draw);
        toolbar = findViewById(R.id.main_toolbar);
        main_menu = findViewById(R.id.nav_main_view);

        rcvCategory= findViewById(R.id.recyclerview_category);
        categoryAdapter= new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);

//        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

        if (userid != null) {
            Menu menu_user = toolbar.getMenu();
            menu_user.setGroupVisible(R.id.da_dnhap, true);
            menu_user.findItem(R.id.dnhap_btn).setVisible(false);
            toolbar.setTitle(R.string.app_name);
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.search_btn) {
                        Intent intent = new Intent(Home.this, Songsearch.class);
                        intent.putExtra("UserID",userid);
                        startActivity(intent);
                        Log.i("chkmain", "search");
                    } else if (id == R.id.user_dangxuat) {
                        Intent intent = new Intent(Home.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (id == R.id.user_thongtin) {
                        Intent intent=new Intent(Home.this,Playmusic.class);
                        intent.putExtra("UserID",userid);
                        startActivity(intent);
                        Log.i("chkmain", "user thong tin");
                    }
                    return true;
                }
            });
            Menu menu_onlyforuser = main_menu.getMenu();
            menu_onlyforuser.setGroupVisible(R.id.only_user_menu, true);
        } else {
            setSupportActionBar(toolbar); // lay cac cai dat mac dinh da override ban dau
        }

        main_menu.bringToFront();
        ActionBarDrawerToggle main_toggle = new ActionBarDrawerToggle(this, main_drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        main_drawerlayout.addDrawerListener(main_toggle);
        main_toggle.syncState();
        main_menu.setNavigationItemSelectedListener(this);

    }

    //xu ly nut back
    @Override
    public void onBackPressed() {
        if (main_drawerlayout.isDrawerOpen(GravityCompat.START)) {
            main_drawerlayout.closeDrawer(GravityCompat.START);
            return;
        } else if(main_viewpager.getCurrentItem()!=0){
            nav_bottom.getMenu().findItem(R.id.action_home).setChecked(true);
            main_viewpager.setCurrentItem(0);
        }else if (backpresstime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            System.exit(0);
            return;
        } else {
            Toast.makeText(Home.this, "Nhấn back lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
        backpresstime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navbar_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_btn) {
            Intent intent = new Intent(Home.this, Songsearch.class);
            startActivity(intent);
            Log.i("btnchk", "search");
        } else if (id == R.id.dnhap_btn) {
            Intent intent = new Intent(Home.this, Login.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chaosup:
                Intent monanyeuthich=new Intent(Home.this,Playmusic.class);
                monanyeuthich.putExtra("UserID",""+userid);
                startActivity(monanyeuthich);
                Log.i("chk", "mon an yeu thich");
                break;
           // case R.id.monxao:
              //  Intent setting=new Intent(Home.this,Playmusic.class);
             //   setting.putExtra("UserID",""+userid);
             //   startActivity(setting);
              //  Log.i("chk", "mon an yeu thich");
              //  break;
            case R.id.monan_thuongngay:
                Intent intent1 = new Intent(Home.this, Likedsong.class);
                intent1.putExtra("TenLoaiMon", "Bữa ăn thường ngày");
                intent1.putExtra("UserID",""+userid);
                startActivity(intent1);
                break;
            case R.id.gioithieu:
                Intent intentgioithieu = new Intent(Home.this, GioiThieu.class);
                startActivity(intentgioithieu);
                break;
            case R.id.chinhsach:
                Log.i("menu", "chinh sach");
                Intent intentchinhsach = new Intent(Home.this, ChinhSach.class);
                startActivity(intentchinhsach);
                break;

        }
        return false;
    }




//    private List<Category> getListCategory(){
//        List<Category> listCategory= new ArrayList<>();
//
//        List <Song> listSong = new ArrayList<>();
//
//        listSong.add(new Song(R.drawable.recommend_music2,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.recommend_music,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.img_song1,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.myplaylist_1,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.my_playlist_2,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.img_song3,"Name Song","Name Singer"));
//        listSong.add(new Song(R.drawable.recommend_music2,"Name Song","Name Singer"));
//
//        listCategory.add(new Category("Recommended for you",listSong));
//        listCategory.add(new Category("My PLayList",listSong));
//        listCategory.add(new Category("Liked Song",listSong));
//        listCategory.add(new Category("Popular",listSong));
//        listCategory.add(new Category("Category",listSong));
//        return listCategory;
//    };

}
