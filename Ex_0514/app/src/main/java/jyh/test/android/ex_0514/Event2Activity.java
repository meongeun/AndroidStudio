package jyh.test.android.ex_0514;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Event2Activity extends AppCompatActivity {

    EditText et1, et2, et_result;
    Button btn_plus, btn_minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event2);

        //이벤트에 사용할 객체 검색
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et_result = findViewById(R.id.et_result);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);

        //int num1 = Integer.parseInt( et1.getText().toString() ) -> 에딧텍스트에 쓰여진 결과값
        //et_result.setText( "" + num1 ); -> 에딧텍스트에 내용 추가

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1 = Integer.parseInt( et1.getText().toString() );
                int num2 = Integer.parseInt( et2.getText().toString() );

                //et_result.setText( "" + (num1 + num2) );
                et_result.setText( String.valueOf((num1 + num2)) );
            }
        });

    }//onCreate()

}











