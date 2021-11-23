package com.example.vovmusic.model;

public class User {
    private String id;
    private String name;
    private String Anh;
    private String email;
    private String password;

    public User(String id, String hoten, String anh, String mail,String pass) {
        this.id = id;
        this.name = hoten;
        this.Anh = anh;
        this.email = mail;
        this.password =pass;
    }

    public String getId() {
        return id;
    }

    public String getHoten() {
        return name;
    }

    public String getAnh() {
        return Anh;
    }

    public String getMail() {
        return email;
    }



}
