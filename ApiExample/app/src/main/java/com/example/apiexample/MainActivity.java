package com.example.apiexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    private Retrofit retrofit;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private final String BASE_URL="https://boostcourse-appapi.connect.or.kr:10000/movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        GitHub gitHub = retrofit.create(GitHub.class);

        Call<List<Contributor>> call = ((GitHub) gitHub).contributors();
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                List<Contributor> contributors = response.body();

                for (Contributor contributor : contributors){
                    textView1.append(contributor.title);
                    textView2.append(contributor.reservation_rate);
                    textView3.append(contributor.grade);
                }
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "정보받아오기 실패", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void init(){
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
