package com.example.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
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

        private static final int WIDTH = 240;
        private static final int HEIGHT =240;
        private Paint mPaint;
        private Bitmap mBitmapDst;
        private Bitmap mBitmapSrc;

        public MyView(Context context) {
            super(context);
            setBackgroundResource(R.drawable.ora);
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

            mBitmapDst = Bitmap.createBitmap(WIDTH,HEIGHT,Bitmap.Config.ARGB_8888);
            Canvas canvasDst = new Canvas(mBitmapDst);
            mPaint.setColor(Color.argb(255,255,0,0));
            canvasDst.drawOval(new RectF(0,0,WIDTH*3/4,HEIGHT*3/4),mPaint);
            //source 비트맴
            mBitmapSrc = Bitmap.createBitmap(WIDTH,HEIGHT,Bitmap.Config.ARGB_8888);
            Canvas canvasSrc = new Canvas(mBitmapSrc);
            mPaint.setColor(Color.argb(255,0,255,0));
            canvasSrc.drawRect(WIDTH/3,HEIGHT/3,WIDTH,HEIGHT,mPaint);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));

            Canvas canvasDst = new Canvas(mBitmapDst);
            canvasDst.drawBitmap(mBitmapSrc,0,0,mPaint);

            mPaint.setXfermode(null);
            canvas.drawBitmap(mBitmapDst,0,0,mPaint);
        }
    }
}
