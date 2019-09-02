package com.example.apiexample2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetroBaseApiService {
    final String Base_URL="http://jsonplaceholder.typicode.com";
    @GET("/posts/{userId}")
    Call<ResponseGet> getFirst(@Path("userId") String id);

}
