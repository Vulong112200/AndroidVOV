package song;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vovmusic.R;
//import com.example.vovmusic.adapter.searchSongAdapter;
//import com.example.vovmusic.model.searchSong;

import java.util.List;

public class songAdapter extends RecyclerView.Adapter<songAdapter.SongViewHolder> {
    private List<Song> mSong;

    public void setData(List<Song> list) {
        this.mSong = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // gán view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        final Song song = mSong.get(position);
        if(song == null) {
            return;
        };
        holder.imgSong.setImageResource(song.getResouceId());
        holder.songName.setText(song.getSongName());
        holder.singerName.setText(song.getSingerName());




    }

    @Override
    public int getItemCount() {
        if(mSong!=null){
            return mSong.size();

        }
        return 0;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgSong;
        private TextView songName;
        private TextView singerName;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            // anh xa view
            imgSong =itemView.findViewById(R.id.img_song);
            songName =itemView.findViewById(R.id.song_name);
            singerName =itemView.findViewById(R.id.singer_name);


        }
    }

}
