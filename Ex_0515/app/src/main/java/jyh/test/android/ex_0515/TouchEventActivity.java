package jyh.test.android.ex_0515;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TouchEventActivity extends AppCompatActivity {

    Button btn_event;
    TextView box, txt_view;
    boolean isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        btn_event = findViewById(R.id.btn_event);
        box = findViewById(R.id.box);
        txt_view = findViewById(R.id.txt_view);

        btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isCheck = !isCheck;

            }
        });

        //빨간색 상자 터치 감지
        box.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String str = "";
                int x = 0;
                int y = 0;

                switch ( event.getAction() ){

                    case MotionEvent.ACTION_DOWN:
                        str = "result : action down";
                        break;

                    case MotionEvent.ACTION_UP:
                        str = "result : action up";
                        break;

                    case MotionEvent.ACTION_MOVE:
                        x = (int)event.getX();
                        y = (int)event.getY();
                        str = "x : " + x + ", y : " + y;
                        break;

                }//switch

                txt_view.setText( str );

                //return값이 true면 이벤트 처리가 완료되었다고 판단하여 화면이 갱신
                //          false면 아직 이벤트 처리가 남았다고 판단하여 화면 갱신 X
                return isCheck;
            }
        });

    }//onCreate()
}




















































