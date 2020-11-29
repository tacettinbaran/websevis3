package com.baran.websevis3.RestApi;

import com.baran.websevis3.Models.PhotosModel;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RestApi {

    //https://jsonplaceholder.typicode.com/photos

    @GET("/photos")
    Call<List<PhotosModel>> photosGetir();
}

