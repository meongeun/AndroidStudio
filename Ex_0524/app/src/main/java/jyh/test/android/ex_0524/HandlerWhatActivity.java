package jyh.test.android.ex_0524;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HandlerWhatActivity extends AppCompatActivity {

    Button btn0, btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_what);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);

        btn0.setOnClickListener( click );
        btn1.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch( v.getId() ){

                case R.id.btn0:
                    handler.sendEmptyMessage(0);
                    break;

                case R.id.btn1:
                    handler.sendEmptyMessage(1);
                    break;

            }//switch

        }
    };

    //핸들러
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            switch ( msg.what ){
                case 0:
                    int num = 0;
                    Toast.makeText(
                            getApplicationContext(),
                            "" + num, Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    Toast.makeText(
                            HandlerWhatActivity.this,
                            "what 1", Toast.LENGTH_SHORT).show();
                    break;
            }//switch

        }
    };


}









































