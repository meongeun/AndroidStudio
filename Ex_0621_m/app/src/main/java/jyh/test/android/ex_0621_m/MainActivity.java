package jyh.test.android.ex_0621_m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button levelBtn, compassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        levelBtn = findViewById(R.id.levelBtn);
        compassBtn = findViewById(R.id.compass);

        levelBtn.setOnClickListener( click );
        compassBtn.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.levelBtn:
                    Intent i = new Intent(
                            MainActivity.this, LevelActivity.class );
                    startActivity(i);
                    break;

                case R.id.compass:
                    i = new Intent(
                            MainActivity.this, CompassActivity.class );
                    startActivity(i);
                    break;

            }//switch

        }
    };

}















































































