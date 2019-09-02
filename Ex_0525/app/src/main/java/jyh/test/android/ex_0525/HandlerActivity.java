package jyh.test.android.ex_0525;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {

    TextView txt_count;
    int num = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        txt_count = findViewById(R.id.txt_count);

    }//onCreate()

    //뒤로가기 버튼 클릭 감지
    @Override
    public void onBackPressed() {

        if( num != 3 ){
            finish();

        }else{
            Toast.makeText(getApplicationContext(),
                        "back once more to exit", Toast.LENGTH_SHORT).show();
            //카운팅 핸들러 호출
            mHandler.sendEmptyMessage(0);
        }

    }//onBackPressed()

    Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            //1초 간격으로 핸들러 자신을 반복
            mHandler.sendEmptyMessageDelayed(0, 1000);

            if( num > 0 ) {
                --num;
            }else{
                num = 3;
                mHandler.removeMessages(0);
            }

            txt_count.setText( "" + num );

        }
    };

}









