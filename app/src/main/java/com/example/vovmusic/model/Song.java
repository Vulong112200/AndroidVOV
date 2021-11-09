package com.example.vovmusic.model;

public class Song {
    private String mSongName;
    private String birthYear;

    public void setmSongName(String mSongName) {
        this.mSongName = mSongName;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
    public Song(String mSongName, String birthYear) {
        this.mSongName = mSongName;
        this.birthYear = birthYear;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getBirthYear() {
        return birthYear;
    }
}