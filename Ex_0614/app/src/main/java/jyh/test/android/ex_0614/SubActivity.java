package jyh.test.android.ex_0614;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    Button btn_red, btn_green, btn_blue;

    //현재 액티비티의 내용을 메인으로 돌려보내기 위해
    //Bundle과 Intent객체를 준비
    Bundle bundleColor;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        btn_red = findViewById(R.id.btn_red);
        btn_green = findViewById(R.id.btn_green);
        btn_blue = findViewById(R.id.btn_blue);

        btn_red.setOnClickListener( click );
        btn_green.setOnClickListener( click );
        btn_blue.setOnClickListener( click );

        bundleColor = new Bundle();
        intent = new Intent();

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_red:
                    //빨간색버튼 클릭시 메인액티비티로 돌려보내줄 정보를 Bundle에 저장
                    bundleColor.putInt("selectColor", Color.RED);
                    bundleColor.putString("selectColorTxt", "RED");
                    break;

                case R.id.btn_green:
                    bundleColor.putInt("selectColor", Color.GREEN);
                    bundleColor.putString("selectColorTxt", "GREEN");
                    break;

                case R.id.btn_blue:
                    break;

            }//switch

            //bundle을 intent에 저장
            intent.putExtras( bundleColor );
            setResult( RESULT_OK, intent );
            finish();

        }
    };

}









































































