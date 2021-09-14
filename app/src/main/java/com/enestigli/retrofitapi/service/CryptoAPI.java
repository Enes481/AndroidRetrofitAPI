package com.enestigli.retrofitapi.service;

import com.enestigli.retrofitapi.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    @GET("default?apiKey=8f7b2190-ce69-4310-9bf5-c657bd2a9f61")
    Call<List<Model>> getData();


}
