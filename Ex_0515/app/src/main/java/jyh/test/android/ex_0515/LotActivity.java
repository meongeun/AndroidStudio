package jyh.test.android.ex_0515;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LotActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn_re;
    TextView txt_result;
    int n;//난수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn_re = findViewById(R.id.btn_re);
        txt_result = findViewById(R.id.txt_result);

        btn1.setOnClickListener( click );
        btn2.setOnClickListener( click );
        btn3.setOnClickListener( click );
        btn4.setOnClickListener( click );
        btn_re.setOnClickListener( click );

        setRandom();

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn1:
                case R.id.btn2:
                case R.id.btn3:
                case R.id.btn4:

                    int user = Integer.parseInt( ((Button)v).getText().toString() );
                    if( user == n ){
                        txt_result.setText("congratulation");
                    }else{
                        txt_result.setText("fail");
                    }

                    break;

                case R.id.btn_re:
                    setRandom();
                    txt_result.setText( "result" );
                    break;

            }//switch

        }
    };

    //난수발생 메서드
    public void setRandom(){
        n = new Random().nextInt(4) + 1;
    }

}










































