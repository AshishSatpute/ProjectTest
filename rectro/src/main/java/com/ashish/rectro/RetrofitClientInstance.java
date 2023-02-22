package com.ashish.rectro;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static final String BASE = "https://jsonplaceholder.typicode.com";
    public static Retrofit retrofit;


    public static Retrofit getRetrofitIntance() {
        if (retrofit == null) {
            retrofit = new  Retrofit.Builder()
                    .baseUrl(BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
