package jyh.test.android.ex_0528;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);

        //MainActivity에서 전달한 intent를 SubActivity에서 받는다.
        Intent i = getIntent();
        Bundle bundle = i.getExtras();

        String name = bundle.getString("m_name");
        String age = bundle.getString("m_age");
        String phone = bundle.getString("m_phone");
        String birth = bundle.getString("m_birth");

//        String name = i.getStringExtra("my_name");
//        String age = i.getStringExtra("my_age");
//        String phone = i.getStringExtra("my_phone");

        txt1.setText( name );
        txt2.setText( age );
        txt3.setText( phone );
        txt4.setText( birth );

    }//onCreate()
}














