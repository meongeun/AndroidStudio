package com.example.apiexample3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    ApiService apiService;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.text);
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService  =retrofit.create(ApiService.class)
;        Call<List<RetrofitRepo>> call = apiService.getreadMovieList(1);
        call.enqueue(new Callback<List<RetrofitRepo>>() {
            @Override
            public void onResponse(Call<List<RetrofitRepo>> call, Response<List<RetrofitRepo>> response) {
                List<RetrofitRepo> repo =response.body();
                for (RetrofitRepo repo1 : repo){
                    text.append(repo1.title);
                }

            }

            @Override
            public void onFailure(Call<List<RetrofitRepo>> call, Throwable t) {

            }
        });
    }

}
