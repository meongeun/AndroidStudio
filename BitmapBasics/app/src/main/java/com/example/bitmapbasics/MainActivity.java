package com.example.bitmapbasics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyView(this));
    }
    private static class  MyView extends View {
        private Paint mPaint;
        private Bitmap mBitmap1;
        private Canvas mCanvas1;
        private Bitmap mBitmap2;
        private Canvas mCanvas2;

        public MyView(Context context){
            super(context);
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(1);

            mBitmap1=Bitmap.createBitmap(400,300,Bitmap.Config.ARGB_8888);
            mCanvas1= new Canvas(mBitmap1);
            mCanvas1.drawRect(0,0,400,300,mPaint);
            mCanvas1.drawCircle(150,100,50,mPaint);
            mBitmap2= BitmapFactory.decodeResource(getResources(),R.drawable.watermelon);
            mBitmap2= mBitmap2.copy(mBitmap2.getConfig(),true);
            mCanvas2 = new Canvas(mBitmap2);
            mPaint.setColor(Color.RED);
            mPaint.setStrokeWidth(10);
            mCanvas2.drawLine(0,0,mBitmap2.getWidth(),mBitmap2.getHeight(),mPaint);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.YELLOW);
            canvas.translate(10,10);
            canvas.drawBitmap(mBitmap1,0,0,null);
            canvas.translate(0,mBitmap1.getHeight()+10);
            canvas.drawBitmap(mBitmap2,null,new Rect(0,0,400,300),null);
        }
    }
}
