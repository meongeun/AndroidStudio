package jyh.test.android.ex_memorygame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MyGameView extends View {

    final static int BLANK = 0;//대기상태
    final static int PLAY = 1;//게임진행중
    final static int DELAY = 1500;//다음단계로 넘어가는 대기시간

    int status;//현재상태

    //도형들을 저장할 ArrayList
    ArrayList<Shape> arShape = new ArrayList<>();
    Random rnd = new Random();
    Activity mParent;

    public MyGameView(Context context) {
        super(context);

        mParent = (Activity)context;
        status = BLANK;
        handler.sendEmptyMessageDelayed(0, DELAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //캔버스 배경을 검정색으로
        canvas.drawColor( Color.BLACK );

        if( status == BLANK ){
            return;
        }

        for( int idx = 0; idx < arShape.size(); idx++ ){

            Paint pnt = new Paint();
            pnt.setColor( arShape.get(idx).color );
            Rect rt = arShape.get(idx).rt;

            switch ( arShape.get(idx).what ){

                case Shape.RECT://0
                    canvas.drawRect( rt, pnt );
                    break;

                case Shape.CIRCLE://1
                    canvas.drawCircle(
                            rt.left + rt.width() / 2,
                            rt.top + rt.height() / 2,
                            rt.width() / 2,
                            pnt);
                    break;

                case Shape.TRIANGLE://2
                    Path path = new Path();
                    path.moveTo( rt.left + rt.width() / 2, rt.top );
                    path.lineTo( rt.left, rt.bottom );
                    path.lineTo( rt.right, rt.bottom );
                    canvas.drawPath( path, pnt );
                    break;

            }//switch

        }//for

    }//onDraw()

    //일정간격으로 도형을 생성하기 위한 핸들러
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            //새로운 도형 추가
            addNewShape();
            status = PLAY;
            invalidate();//onDraw()갱신

            String title = "stage - " + arShape.size();
            mParent.setTitle( title );
        }
    };

    //새로운 도형을 추가하는 메서드
    private void addNewShape(){

        Shape shape = new Shape();
        boolean bFindIntersect;//도형이 중복되는지 판단
        Rect rt = new Rect();

        while( true ){
            //랜덤으로 도형사이즈 생성
            //50 ~ 150사이의 난수
            // 2 ~ 5
            //rnd.nextInt( 5 - 2 + 1 ) + 2;
            int size = rnd.nextInt( 150 - 50 + 1 ) + 50;

            //사각형의 범위
            rt.left = rnd.nextInt( getWidth() );//getWidth() : 캔버스의 너비
            rt.top = rnd.nextInt( getHeight() );//getHeight() : 캔버스의 높이
            rt.right = rt.left + size;
            rt.bottom = rt.top + size;

            //도형이 화면을 벗어나면 새로 그린다.
            if( rt.right > getWidth() || rt.bottom > getHeight() ){
                continue;
            }

            bFindIntersect = false;
            //도형이 겹치는지 판단
            for( int idx = 0; idx < arShape.size(); idx++ ){

                if( rt.intersect( arShape.get(idx).rt ) ){
                    bFindIntersect = true;
                }

            }//for

            //위의 과정에서 문제가 없을 경우( 화면벗어남X, 겹치지X)
            if( !bFindIntersect ){
                break;
            }

        }//while

        //도형모양
        //rnd.nextInt(2 - 0 + 1) + 0;
        shape.what = rnd.nextInt(3);

        //도형색상
        switch ( rnd.nextInt(5) ){
            case 0:
                shape.color = Color.WHITE;
                break;

            case 1:
                shape.color = Color.RED;
                break;

            case 2:
                shape.color = Color.GREEN;
                break;

            case 3:
                shape.color = Color.BLUE;
                break;

            case 4:
                shape.color = Color.YELLOW;
                break;

        }//switch

        //생성된 도형객체를 arrayList에 저장
        shape.rt = rt;
        arShape.add( shape );

    }//addNewShape()

    //도형 터치
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if( event.getAction() == MotionEvent.ACTION_DOWN ){

            //빈 공간이 아닌 도형의 위치를 제대로 클릭했는지 판단하기 위한 메서드
            int sel = findShapeIdx( (int)event.getX(), (int)event.getY() );

            if( sel == -1 ){
                return true;
            }

            //정답 판단
            if( sel == arShape.size() - 1 ){

                status = BLANK;
                invalidate();
                handler.sendEmptyMessageDelayed(0, DELAY);

            }else{
                //게임 종료시 다이얼로그 생성
                AlertDialog.Builder builder = new AlertDialog.Builder( mParent );
                builder.setMessage("restart game?");
                builder.setTitle("GameOver");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //게임초기화
                        arShape.clear();
                        status = BLANK;
                        invalidate();
                        handler.sendEmptyMessageDelayed(0, DELAY);
                    }
                });

                builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mParent.finish();

                    }
                });

                builder.setCancelable(false);
                builder.show();

            }

        }
        return false;
    }//onTouchEvent()

    private int findShapeIdx( int x, int y ){

        for( int idx = 0; idx < arShape.size(); idx++ ){
            //arShape에 담겨져 있는 도형(Rect)중
            //사용자가 터치한 좌표와 중복되는 객체의 번호를 반환
            if( arShape.get(idx).rt.contains( x, y ) ){
                return idx;
            }

        }

        return -1;

    }//findShapeIdx()

}


























