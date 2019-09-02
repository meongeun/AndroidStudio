package jyh.test.android.ex_0530;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferenceActivity extends AppCompatActivity {

    TextView value;
    Button btn_up, btn_down, btn_reset;
    int n = 0;

    //값을 저장하기 위한 객체
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        pref = PreferenceManager.getDefaultSharedPreferences(
                                    SharedPreferenceActivity.this );

        //저장된 값이 있다면 로드
        n = pref.getInt("number", 0);

        value = findViewById(R.id.value);
        value.setText( "" + n );

        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);
        btn_reset = findViewById(R.id.btn_reset);

        btn_up.setOnClickListener(click);
        btn_down.setOnClickListener(click);
        btn_reset.setOnClickListener(click);

    }//onCreate()

    //앱이 정지/종료되는 시점에서 n값을 저장
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("number", n);
        edit.commit();//저장하고자 하는 데이터를 물리적으로 기록

    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_up:
                    n++;
                    break;

                case R.id.btn_down:
                    n--;
                    break;

                case R.id.btn_reset:
                    n = 0;
                    break;

            }//switch

            value.setText( "" + n );

        }
    };

}

















































