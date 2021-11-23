package RecommendSong;

public class Song {
    private String title;
    private String singer;
    private String coverImage;
    private String imageSongURL;
    private String songName;

    public  Song(){}



    public Song (String title, String singer, String coverImage){
        this.title = title;
        this.coverImage = coverImage;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //get set image
    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    //get set singer
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
