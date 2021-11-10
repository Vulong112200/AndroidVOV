package song;

public class Song {

    private int resouceId;
    private String songName;
    private String singerName;

    public Song(int resouceId, String songName, String singerName) {
        this.resouceId = resouceId;
        this.songName = songName;
        this.singerName = singerName;
    }

    public int getResouceId() {
        return resouceId;
    }

    public void setResouceId(int resouceId) {
        this.resouceId = resouceId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
