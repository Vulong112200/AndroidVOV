package com.example.vovmusic.model;

public class User {
    private String id;
    private String name;
    private String Anh;
    private String email;
    private String ngaysinh;
    private String username;
    private String pass;

    public User(String id, String hoten, String anh, String mail, String ngaysinh) {
        this.id = id;
        this.name = hoten;
        this.Anh = anh;
        this.email = mail;
        this.ngaysinh = ngaysinh;
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

    public String getNgaysinh() {
        return ngaysinh;
    }
}
