package com.example.apiexample2;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    private  RetroBaseApiService apiService;
    public  static  String baseUrl = RetroBaseApiService.Base_URL;
    private static Context mContext;
    private static Retrofit retrofit;

    private static class SingletonHolder{
        private static  RetroClient INSTANCE = new RetroClient(mContext);
    }
    public static  RetroClient getInstance(Context context){
        if(context != null){
            mContext = context;
        }
        return SingletonHolder.INSTANCE;
    }
    private RetroClient(Context context){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    public RetroClient createBaseApi(){
        apiService = retrofit.create(RetroBaseApiService.class);
        return this;
    }

    public  <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }


    public void getFirst(String id,final RetroCallback callback){
        apiService.getFirst(id).enqueue(new Callback<ResponseGet>() {
            @Override
            public void onResponse(Call<ResponseGet> call, Response<ResponseGet> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.code(),response.body());
                }else{
                    callback.onFailure(response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseGet> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
