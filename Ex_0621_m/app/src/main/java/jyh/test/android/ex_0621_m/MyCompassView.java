package jyh.test.android.ex_0621_m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class MyCompassView extends View {

    Bitmap bitmap;
    int width, height;
    float centerX, centerY;
    float heading;//방위값

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;

        centerX = width/2;
        centerY = height/2;

        init();
    }

    private void init(){
        bitmap = BitmapFactory.decodeResource( getResources(), R.mipmap.compass );

        //나침반은 가로와 세로의 길이가 같아야 하므로
        //더 짧은 쪽인 width를 기준으로 사이즈를 변경
        bitmap = Bitmap.createScaledBitmap( bitmap, width, width, false );
    }//init()

    public MyCompassView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //캔버스의 배경색을 변경
        canvas.drawColor(Color.BLACK);

        //heading을 통해 방위를 얻어내는 공식
        canvas.rotate( -heading*360/(2*3.14159f), centerX, centerY );

        //화면 중심에 나침반 이미지 그리기
        canvas.drawBitmap( bitmap, 0, (height/2)-(bitmap.getHeight()/2), null );
    }//onDraw()
}


















































