package jyh.test.android.ex_memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( new MyGameView( MemoryActivity.this ) );
    }
}
