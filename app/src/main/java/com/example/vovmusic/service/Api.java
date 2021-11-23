package com.example.vovmusic.service;

import com.example.vovmusic.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface Api {
    Gson gson =new GsonBuilder()
            .setDateFormat("yy-MM-đ HH:mm:ss")
            .create();
    Api api=new Retrofit.Builder()
            .baseUrl("https://vovmusic.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Api.class);

    @GET("user")
    Call<List<User>> allUser();
}
