package com.example.application;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class MyPage extends Activity implements GestureDetector.OnGestureListener {

    ImageButton btnWarn;
    ImageButton btnFilter;
    PopupMenu pm;

    private LinearLayout main;
    private TextView viewA;

    private  static final int SWIPE_MIN_DISTANCE = 120;
    private  static final int SWIPE_MAX_OFF_PATH= 250;
    private  static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private GestureDetector gestureScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        gestureScanner = new GestureDetector(this);
        main = new LinearLayout(this);
        main.setBackgroundColor(Color.GRAY);
        main.setLayoutParams(new LinearLayout.LayoutParams(320,480));

        viewA = new TextView(this);
        viewA.setBackgroundColor(Color.WHITE);
        viewA.setTextColor(Color.BLACK);
        viewA.setTextSize(30);
        viewA.setGravity(Gravity.CENTER);
        viewA.setLayoutParams(new LinearLayout.LayoutParams(320, 80));
        main.addView(main);



        btnFilter = (ImageButton)findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pm = new PopupMenu(getApplicationContext(), v);

                getMenuInflater().inflate(R.menu.menu_main,pm.getMenu());

                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(),"팝업메뉴 이벤트 처리 -"+item.getTitle(),Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
                pm.show();
            }
        });


        btnWarn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showd();
            }
        });


    }

    void showd(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("신고창");
        builder.setMessage("신고하시겠습니까?");
        builder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "신고했습니다", Toast.LENGTH_LONG).show();
                    }
                });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소했습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public void dd(View v) {
        Toast.makeText(getApplicationContext(), "dd", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==1){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }

    public boolean onDown(MotionEvent e) {
        viewA.setText("-" + "DOWN" + "-");
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;

            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Left Swipe", Toast.LENGTH_SHORT).show();
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Right Swipe", Toast.LENGTH_SHORT).show();
            }
            // down to up swipe
            else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Swipe up", Toast.LENGTH_SHORT).show();
            }
            // up to down swipe
            else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Swipe down", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
        return true;
    }

    public void onLongPress(MotionEvent e) {
        Toast mToast = Toast.makeText(getApplicationContext(), "Long Press", Toast.LENGTH_SHORT);
        mToast.show();
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        viewA.setText("-" + "SCROLL" + "-");
        return true;
    }

    public void onShowPress(MotionEvent e) {
        viewA.setText("-" + "SHOW PRESS" + "-");
    }

    public boolean onSingleTapUp(MotionEvent e) {
        Toast mToast = Toast.makeText(getApplicationContext(), "Single Tap", Toast.LENGTH_SHORT);
        mToast.show();
        return true;
    }

}

