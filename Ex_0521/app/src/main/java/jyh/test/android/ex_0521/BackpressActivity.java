package jyh.test.android.ex_0521;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class BackpressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpress);
    }//onCreate()

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(
                BackpressActivity.this,
                "back button", Toast.LENGTH_SHORT ).show();
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //휴대폰 뒤로가기 버튼 클릭 감지
        if( keyCode == KeyEvent.KEYCODE_BACK ){

            Toast.makeText(BackpressActivity.this,
                    "back button", Toast.LENGTH_SHORT).show();

        }
        return false;
    }*/
}








































