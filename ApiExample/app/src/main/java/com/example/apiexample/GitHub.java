package com.example.apiexample;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHub {

/*    https://api.github.com/repos/square/retrofit/contributors
    http://boostcourse-appapi.connect.or.kr:10000/movie/readMovieList
    http://boostcourse-appapi.connect.or.kr:10000/movie/readMovieList?type=1*/

    @GET("/readMovieList?type=1")
    Call<JsonObject> getMovieList(@Query("type") int type);
}
