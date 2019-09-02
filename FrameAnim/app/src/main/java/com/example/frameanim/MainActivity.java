package com.example.frameanim;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable mAnimation;
    Button btn_start, btn_stop;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imgFrame);
        img.setBackgroundResource(R.drawable.frames);
        mAnimation = (AnimationDrawable)img.getBackground();

        btn_start=findViewById(R.id.btnStart);
        btn_stop=findViewById(R.id.btnStop);
        btn_start.setOnClickListener(click);
        btn_stop.setOnClickListener(click);

    }
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStart:
                    mAnimation.start();
                    break;
                case R.id.btnStop:
                    mAnimation.stop();
                    break;
            }
        }
    };
}
