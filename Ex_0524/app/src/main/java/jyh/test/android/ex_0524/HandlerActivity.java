package jyh.test.android.ex_0524;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {

    TextView txt_count;
    Button btn_start, btn_stop;
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        txt_count = findViewById(R.id.txt_count);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener( click );
        btn_stop.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_start:
                    //핸들러 호출
                    handler.sendEmptyMessage(0);

                    //start버튼 비활성화
                    btn_start.setEnabled( false );
                    break;

                case R.id.btn_stop:
                    //핸들러 정지
                    handler.removeMessages(0);

                    //start버튼 활성화
                    btn_start.setEnabled( true );
                    break;

            }//switch

        }
    };

    //핸들러
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            //1초 간격으로 핸들러를 반복 호출
            handler.sendEmptyMessageDelayed(0, 1000);

            num++;
            txt_count.setText( String.valueOf(num) );

        }
    };

}







































