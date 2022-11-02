package com.example.cartoonapi.retrofit;

import com.example.cartoonapi.ApiCalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL="https://rickandmortyapi.com/api/";
    //using singelton design pattern

    private  static ApiCalls instance;
    public  static ApiCalls getInstance() {
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(ApiCalls.class);
        }
        return instance;

    }

}
