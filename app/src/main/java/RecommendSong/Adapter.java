package RecommendSong;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vovmusic.R;
import com.squareup.picasso.Picasso;



import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Song> songs;

    public Adapter(Context ctx, List<Song> songs){
        this.inflater = LayoutInflater.from(ctx);
        this.songs = songs;
    }
    public void setData(List<Song> list) {
        this.songs = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.song_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.songTitle.setText(songs.get(position).getTitle());
        holder.singer.setText(songs.get(position).getSinger());
        Picasso.get().load(songs.get(position).getCoverImage()).into(holder.songCoverImage);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView songTitle;
        TextView singer;
        ImageView songCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            songTitle = itemView.findViewById(R.id.songTitle);
            singer = itemView.findViewById(R.id.singer);
            songCoverImage = itemView.findViewById(R.id.coverImage);


            // handle onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
