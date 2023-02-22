package com.ashish.rectro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Servic {
    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
