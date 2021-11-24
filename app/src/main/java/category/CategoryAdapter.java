package category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vovmusic.R;

import java.util.List;

import RecommendSong.Adapter;
import RecommendSong.Song;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> mListCategory;
    List<Song> songs;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Category> list) {
        this.mListCategory = list;
        //hamf load gan du lieu len songAdapter
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // gán view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_category, parent, false);
        return new CategoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCategory.get(position);
        if(category == null) {
            return;
        };

        holder.tvNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.rcvSong.setLayoutManager(linearLayoutManager);

        Adapter songAdapter= new Adapter(context,songs);
        songAdapter.setData(category.getSongs());
        holder.rcvSong.setAdapter(songAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListCategory!=null){
            return mListCategory.size();

        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNameCategory;
        private RecyclerView rcvSong;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameCategory =itemView.findViewById(R.id.tv_recommended);
            rcvSong = itemView.findViewById(R.id.recyclerview_recommend);

        }
    }
}