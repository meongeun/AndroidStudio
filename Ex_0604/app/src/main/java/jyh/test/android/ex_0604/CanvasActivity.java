package jyh.test.android.ex_0604;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( new MyView( CanvasActivity.this ) );

        //디바이스의 회전을 감지하는 메서드
        Resources r = Resources.getSystem();
        Configuration config = r.getConfiguration();
        onConfigurationChanged( config );

    }//onCreate()

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //현재 디바이스의 방향을 체크
        switch ( newConfig.orientation ){

            case Configuration.ORIENTATION_LANDSCAPE://가로
                Toast.makeText(
                        getApplicationContext(),
                        "LANDSCAPE", Toast.LENGTH_SHORT).show();
                break;

            case Configuration.ORIENTATION_PORTRAIT://세로
                Toast.makeText(
                        getApplicationContext(),
                        "PORTRAIT", Toast.LENGTH_SHORT).show();
                break;

        }

    }//onConfigurationChanged
}

















































