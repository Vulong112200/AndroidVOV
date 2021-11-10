//package com.example.vovmusic.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.vovmusic.R;
//import com.example.vovmusic.SearchDetail;
//import com.example.vovmusic.model.searchSong;
//
//import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.Locale;
//
//public class searchSongAdapter  extends RecyclerView.Adapter<searchSongAdapter.ViewHolder> {
//    Context context;
//    ArrayList<searchSong> listSanPham;
//
//
//    //contructor
//    public searchSongAdapter(Context context, ArrayList<searchSong> listSanPham) {
//        this.context = context;
//        this.listSanPham = listSanPham;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // gán view
//        View view = LayoutInflater.from(context).inflate(R.layout.list_item_fragment, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        // Gán dữ liêu
//        final searchSong sanPham = listSanPham.get(position);
//        if(sanPham==null) return;
//        holder.txtTenSanPham.setText(sanPham.getTenSanPham());
//        Locale locale = new Locale("vn", "VN");
//        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
//        holder.txtGiaSanPham.setText(currencyFormatter.format(sanPham.getGiaSanPham()));
//        holder.imgAvatar.setImageResource(sanPham.getHinhSanPham());
//
//
//        holder.searchSongItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onClickGoToDetails(sanPham);
//            }
//        });
//
//
//    }
//    //go to datail song
//    private void onClickGoToDetails(searchSong sanPham){
//    Intent intent= new Intent(context, SearchDetail.class);
//        Bundle bundle= new Bundle();
//        bundle.putSerializable("key","onject value");
//        intent.putExtras(bundle);
//        context.startActivity(intent);
//    }
//
//    @Override
//    public int getItemCount() {
//        if(listSanPham!=null){
//            return listSanPham.size(); // trả item tại vị trí postion
//        }
//        return 0;
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//
//        private RelativeLayout  searchSongItem;
//        ImageView imgAvatar;
//        TextView txtTenSanPham, txtGiaSanPham;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            // Ánh xạ view
//            searchSongItem = itemView.findViewById(R.id.search_song_item);
//
//
//            imgAvatar = itemView.findViewById(R.id.img_song_search);
//            txtGiaSanPham = itemView.findViewById(R.id.song_name);
//            txtTenSanPham = itemView.findViewById(R.id.singer);
//
//        }
//    }
//}