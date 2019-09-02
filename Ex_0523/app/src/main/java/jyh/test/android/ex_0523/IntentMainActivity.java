package jyh.test.android.ex_0523;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentMainActivity extends AppCompatActivity {

    Button btn_link, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(
                        IntentMainActivity.this, IntentSubActivity.class );
                //i.setClass( IntentMainActivity.this, IntentSubActivity.class);
                startActivity( i );

            }
        });

        btn_link = findViewById(R.id.btn_link);
        btn_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent클래스는 안드로이드 화면간의 이동에 사용되는 클래스
                Intent i = new Intent( Intent.ACTION_VIEW );

                //intent를 통해 웹사이트로 화면전환을 하기 위한 준비
                i.setData( Uri.parse("http://www.naver.com") );

                //화면 전환
                startActivity( i );
            }
        });

    }//onCreate()
}


















































