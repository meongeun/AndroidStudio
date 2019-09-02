package com.example.apiexample3;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    public static final String API_URL=
            "https://boostcourse-appapi.connect.or.kr:10000/";
    @GET("movie/readMovieList")
    Call<List<RetrofitRepo>> getreadMovieList(@Query("type") int type);

}
