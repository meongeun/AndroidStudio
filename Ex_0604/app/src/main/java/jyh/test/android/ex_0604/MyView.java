package jyh.test.android.ex_0604;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View{

    Paint paint = new Paint();

    //Path클래스는 여러가지 명령을 모아뒀다가 한번에 출력해주는 클래스
    Path path = new Path();
    int x, y;

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paint.setColor( Color.RED );

        paint.setStyle( Paint.Style.STROKE );

        paint.setStrokeWidth( 5 );

        //path가 기억하는 좌표를 화면에 그려준다.
        canvas.drawPath( path, paint );

    }//onDraw()

    //터치 이벤트 감지자
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        x = (int)event.getX();
        y = (int)event.getY();

        switch ( event.getAction() ){

            case MotionEvent.ACTION_DOWN:
                //화면이 터치되었을때의 x, y좌표를 기억
                path.moveTo( x, y );
                break;

            case MotionEvent.ACTION_MOVE:
                //손가락이 움직이면 변경된 좌표까지를 직선으로 연결
                x = (int)event.getX();
                y = (int)event.getY();

                path.lineTo( x, y );
                break;

        }//switch

        //onDraw()를 통해 변경된 좌표를 갱신
        invalidate(); //<- onDraw()메서드를 갱신하는 메서드

        return true;
    }
}
































































