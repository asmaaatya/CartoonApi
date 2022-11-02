package com.example.cartoonapi;

import com.example.cartoonapi.pojo.CharachtersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCalls {
    @GET("character")
    Call<CharachtersResponse> getCharachters(@Query("page") int page);

}
