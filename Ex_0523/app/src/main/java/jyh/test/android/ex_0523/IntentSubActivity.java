package jyh.test.android.ex_0523;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentSubActivity extends AppCompatActivity {

    Button btn_pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sub);

        btn_pre = findViewById(R.id.btn_pre);
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent i = new Intent(
                        IntentSubActivity.this, IntentMainActivity.class );
                startActivity( i );*/
               finish();

            }
        });

    }//onCreate()

}

















































