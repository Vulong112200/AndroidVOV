package com.example.vovmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vovmusic.R;
import com.example.vovmusic.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter <SongAdapter.ViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public SongAdapter(List _student, Context mContext) {
        this.mStutents = _student;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử sinh viên
        View studentView =
                inflater.inflate(R.layout.song_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = (Song) mStutents.get(position);

        holder.songname.setText(song.getmSongName());
        holder.singername.setText(song.getBirthYear()+"");


    }

    @Override
    public int getItemCount() {
        return mStutents.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView songname;
        public TextView singername;


        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            songname = itemView.findViewById(R.id.studentname);
            singername = itemView.findViewById(R.id.birthyear);
        }
    }


}