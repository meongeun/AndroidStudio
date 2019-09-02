package jyh.test.android.ex_0614;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView color_txt, color_view;
    Button select_btn;

    final int SELECT = 1;//리퀘스트 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        color_txt = findViewById(R.id.color_txt);
        color_view = findViewById(R.id.color_view);
        select_btn = findViewById(R.id.select_btn);

        select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( ResultActivity.this, SubActivity.class );
                startActivityForResult(intent, SELECT);

            }
        });

    }//onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if( resultCode == RESULT_OK ){

            if( requestCode == SELECT ){

                Bundle bundle = data.getExtras();
                int color = bundle.getInt("selectColor");
                String txt_color = bundle.getString("selectColorTxt");

                color_view.setBackgroundColor( color );
                color_txt.setText( txt_color );

            }

        }

    }
}








































