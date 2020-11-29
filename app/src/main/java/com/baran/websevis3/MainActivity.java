package com.baran.websevis3;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.baran.websevis3.Adapters.PhotosAdapter;
import com.baran.websevis3.Models.PhotosModel;
import com.baran.websevis3.RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<PhotosModel> photosModelsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        photosGetir();
    }

    public void tanimla(){
        listView = findViewById(R.id.listview);
    }

    public void photosGetir(){
        Call<List<PhotosModel>> istek = ManagerAll.getInstance().getPhotos();
        photosModelsList = new ArrayList<>();
        Context context;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(" Bilgi Ekranı");
        progressDialog.setMessage("Lütfen Bekleyiniz");
        progressDialog.setCancelable(false);
        progressDialog.show();
        istek.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {
                if (response.isSuccessful()){
                    photosModelsList = response.body();
                    PhotosAdapter photosAdapter = new PhotosAdapter(photosModelsList,getApplicationContext());
                    listView.setAdapter(photosAdapter);
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {

            }
        });
    }
}