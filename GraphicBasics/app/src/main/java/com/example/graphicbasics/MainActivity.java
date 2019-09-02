package com.example.graphicbasics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    private static class MyView extends View {
        private Paint mPaint;

        public MyView(Context context){
            super(context);
            mPaint = new Paint();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(100,100,80,mPaint);

            Path path = new Path();
            path.moveTo(50,300);
            path.lineTo(90,310);
            path.lineTo(110,290);
            path.quadTo(110,290,130,330);
            canvas.drawPath(path, mPaint);
            mPaint.setColor(Color.GREEN);
            path.addCircle(300,200,10,Path.Direction.CW);
            canvas.drawPath(path, mPaint);
            canvas.drawTextOnPath("string",path,0,0,mPaint);

        }
    }
}
