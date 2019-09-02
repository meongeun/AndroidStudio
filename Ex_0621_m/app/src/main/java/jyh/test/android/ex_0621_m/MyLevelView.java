package jyh.test.android.ex_0621_m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.text.DecimalFormat;

public class MyLevelView extends View {

    Bitmap moveImg, holdImg;
    int width, height;//뷰의 너비와 높이
    float centerX, centerY;//뷰의 중심좌표

    float pitch, roll;//경사도, 기울기

    //그림을 그릴페인트, 글을 쓸 페인트
    Paint paint, textPnt;

    public MyLevelView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //경사도와 기울기는 float형태로 넘어온다.
        //소수점 한자리에서 끊는다.
        DecimalFormat format = new DecimalFormat("#.#");
        String r = format.format( roll );
        String p = format.format( pitch );

        //센서의 경사도와 기울기가 -0.5 ~ 0.5일때 수평의 범위로 인정
        if( (roll < 0.5f && roll > -0.5f) &&
                ( pitch < 0.5f && pitch > -0.5f ) ){

            //수평일 때 배경을 초록색
            paint.setColor( Color.argb( 80, 0, 255, 0 ) );
            canvas.drawPaint( paint );

        }else{
            //수평이 아닐 때는 배경을 빨간색
            paint.setColor( Color.argb( 80, 255, 0, 0 ) );
            canvas.drawPaint( paint );
        }

        //holdImg
        canvas.drawBitmap(
                holdImg,
                centerX - moveImg.getWidth()/2,
                centerY - moveImg.getHeight()/2,
                null);

        //moveImg
        canvas.drawBitmap(
                moveImg,
                roll + ( centerX - moveImg.getWidth()/2 ),
                pitch + ( centerY - moveImg.getHeight()/2 ),
                null);

    }//onDraw()

    //현재 view(캔버스)의 사이즈를 얻어내는 메서드
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;//뷰의 너비
        height = h;//뷰의 높이

        //뷰의 중심
        centerX = width / 2;
        centerY = height / 2;

        //이미지 초기화 메서드
        init();
    }//onSizeChanged()

    private void init(){
        //이미지를 불러오고 페인트를 생성하는 메서드
        moveImg = BitmapFactory.decodeResource(
                            getResources(), R.mipmap.move_ball );

        //이미지 사이즈 변경
        moveImg = Bitmap.createScaledBitmap(
                        moveImg, width/6, height/8, false );

        holdImg = BitmapFactory.decodeResource(
                            getResources(), R.mipmap.hold_ball );
        holdImg = Bitmap.createScaledBitmap(
                        holdImg, width/6, height/8, false );

        paint = new Paint();
        textPnt = new Paint();

    }//init()

}



















































































