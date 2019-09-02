package jyh.test.android.ex_0515;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Event1Activity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        btn1 = findViewById( R.id.btn1 );
        btn2 = findViewById( R.id.btn2 );
        btn3 = findViewById( R.id.btn3 );
        txt = findViewById(R.id.txt);

        //버튼에 이벤트 감지자 등록
        btn1.setOnClickListener( click );
        btn2.setOnClickListener( click );
        btn3.setOnClickListener( click );

    }//onCreate()

    //버튼들이 감지할 이벤트 감지자
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String str = ((Button)v).getText().toString();
            txt.setText( str + " click" );
            /*switch( v.getId() ){//클릭된 객체의 id
                case R.id.btn1:
                    txt.setText("btn1 click");
                    break;

                case R.id.btn2:
                    txt.setText("btn2 click");
                    break;

                case R.id.btn3:
                    txt.setText("btn3 click");
                    break;
            }//switch*/

        }
    };

}




















































