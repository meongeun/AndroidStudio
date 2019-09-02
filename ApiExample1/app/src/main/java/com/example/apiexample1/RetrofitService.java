package com.example.apiexample1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("movie/readMovieList?type=1")
    Call<RetrofitRepo> getIndex(

    );
}
