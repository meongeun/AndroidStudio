package jyh.test.android.ex_0622_m;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    ImageView img;
    AnimationDrawable ani;

    Button btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        img = findViewById(R.id.img);
        img.setBackgroundResource( R.drawable.animation );

        ani = (AnimationDrawable)img.getBackground();

        btn_start.setOnClickListener( click );
        btn_stop.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_start:
                    //애니메이션 시작
                    ani.start();
                    break;

                case R.id.btn_stop:
                    //애니메이션 정지
                    ani.stop();
                    break;

            }//switch

        }
    };

}











































