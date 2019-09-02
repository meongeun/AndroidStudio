package com.example.graphicbasics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    private static class MyView extends View{
        private Paint mPaint;

        public MyView(Context context){
            super(context);
            mPaint= new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.RED);
        }

        protected void onDraw(Canvas canvas){
            canvas.drawColor(Color.GREEN);
            canvas.drawCircle(100,100,80,mPaint);
        }
    }
}
