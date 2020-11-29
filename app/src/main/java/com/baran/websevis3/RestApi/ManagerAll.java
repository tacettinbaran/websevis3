package com.baran.websevis3.RestApi;

import com.baran.websevis3.Models.PhotosModel;
import retrofit2.Call;
import java.util.List;

public class ManagerAll extends BaseManager {


    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<List<PhotosModel>> getPhotos(){
        Call<List<PhotosModel>> call = getRestApiClient().photosGetir();
        return call;
    }
}
