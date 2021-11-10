package category;

import java.util.List;

import song.Song;

public class Category {
    private  String nameCategory;
    private List<Song> songs;

    public Category(String nameCategory, List<Song> songs) {
        this.nameCategory = nameCategory;
        this.songs = songs;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
