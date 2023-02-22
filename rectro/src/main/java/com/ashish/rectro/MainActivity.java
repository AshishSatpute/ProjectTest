package com.ashish.rectro;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getList();

    }


    public void getList() {

        Servic servic = RetrofitClientInstance.getRetrofitIntance().create(Servic.class);
        Call<List<RetroPhoto>> call = servic.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                Toast.makeText(MainActivity.this, "" + response.body().get(0).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {

            }
        });
    }
}