package jyh.test.android.ex_0514;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonEventActivity extends AppCompatActivity {

    Button btn_red, btn_blue, btn_toast;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_event);

        //이벤트에 사용할 객체 검색
        btn_toast = findViewById(R.id.btn_toast);
        btn_red = findViewById( R.id.btn1 );
        btn_blue = findViewById( R.id.btn2 );
        txt = findViewById( R.id.txt );

        //btn_red에 이벤트 감지자 등록
        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btn_red클릭시 이벤트 처리를 수행하는 영역
                txt.setBackgroundColor( Color.RED );
                txt.setText( "RED" );
            }
        });

        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt.setBackgroundColor( Color.BLUE );
                txt.setText( "BLUE" );

            }
        });

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //makeText( Context, msg, delay );
                //Context : 화면 제어권자
                Toast.makeText( ButtonEventActivity.this,
                                "show toast", Toast.LENGTH_SHORT ).show();

            }
        });

    }//onCrate()

}


















