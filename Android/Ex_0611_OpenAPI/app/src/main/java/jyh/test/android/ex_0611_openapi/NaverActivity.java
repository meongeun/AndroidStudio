package jyh.test.android.ex_0611_openapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class NaverActivity extends AppCompatActivity {

    public static EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver);

        search = findViewById(R.id.search);

    }//onCreate()
}
