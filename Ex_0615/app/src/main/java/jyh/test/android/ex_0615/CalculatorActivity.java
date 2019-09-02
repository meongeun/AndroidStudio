package jyh.test.android.ex_0615;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

public class CalculatorActivity extends AppCompatActivity {

    //0 ~ 9사이의 버튼을 배열로 준비
    Button[] numbers;

    //+ - * / = c 버튼
    Button plus, sub, multi, div, equal, clear;

    String resultStr = "";//결과처리 변수
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txt_result = findViewById(R.id.txt_result);

        numbers = new Button[10];
        for( int i = 0; i < numbers.length; i++ ){

            try {
                numbers[i] = findViewById(
                        new R.id().getClass().getField( "btn" + i ).getInt(null) );

                //검색된 숫자버튼에 이벤트 감지자 등록
                numbers[i].setOnClickListener( numberClick );
            } catch (Exception e) {
                e.printStackTrace();

            }

        }//for

        plus = findViewById(R.id.btn10);
        sub = findViewById(R.id.btn11);
        multi = findViewById(R.id.btn12);
        div = findViewById(R.id.btn13);
        equal = findViewById(R.id.btn14);
        clear = findViewById(R.id.btn15);

        plus.setOnClickListener( signClick );
        sub.setOnClickListener( signClick );
        multi.setOnClickListener( signClick );
        div.setOnClickListener( signClick );
        equal.setOnClickListener( signClick );
        clear.setOnClickListener( signClick );

    }//onCreate()

    View.OnClickListener numberClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //클릭된 숫자버튼에 쓰여져 있는 텍스트
            resultStr += ((Button)v).getText().toString();
            txt_result.setText( resultStr );
        }
    };

    View.OnClickListener signClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if( v != equal ){

                resultStr += ((Button)v).getText().toString();
                txt_result.setText( resultStr );

                if( v == clear ){
                    resultStr = "";
                    txt_result.setText( resultStr );
                }

            }else{
                // = 버튼 클릭시 결과처리
                resultMethod();
            }

        }
    };

    //결과처리 메서드
    public void resultMethod(){

        JsEvaluator evaluator = new JsEvaluator( CalculatorActivity.this );

        //evaluate( 수식으로 전환한 문자열, 계산된 결과를 반환하는 콜백메서드 )
        evaluator.evaluate(resultStr, new JsCallback() {
            @Override
            public void onResult(String s) {

                //연산이 완료된 결과를 s를 통해 받는다.
                resultStr = s;
                txt_result.setText( resultStr );

            }
        });

    }//resultMethod()

}




















































