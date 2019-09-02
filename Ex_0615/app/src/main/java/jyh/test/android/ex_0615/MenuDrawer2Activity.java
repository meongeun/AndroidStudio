package jyh.test.android.ex_0615;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuDrawer2Activity extends AppCompatActivity {

    DrawerLayout drawer_layout;
    View drawer;
    Button btn_open, btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drawer2);

        drawer_layout = findViewById(R.id.drawer_layout);
        drawer = findViewById(R.id.drawer);

        btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //서랍열기
                drawer_layout.openDrawer( drawer );
            }
        });

        btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //서랍닫기
                //drawer_layout.closeDrawer( drawer );
                drawer_layout.closeDrawers();
            }
        });

        //서랍에 감지자 등록
        drawer_layout.setDrawerListener( myDrawerListener );

        //손으로 서랍을 열고닫을수 없다.( 이벤트로만 제어 가능 )
        drawer_layout.setDrawerLockMode( DrawerLayout.LOCK_MODE_LOCKED_CLOSED, drawer );

        //손으로 서랍을 열고 닫을 수 있다.
        //drawer_layout.setDrawerLockMode( DrawerLayout.LOCK_MODE_UNLOCKED, drawer );

    }//onCreate()

    DrawerLayout.DrawerListener myDrawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            //메뉴가 열리는 중일 때
            //slideOffset은 메뉴가 완전히 닫혀있다면 0.0, 완전히 열려있으면 1.0
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
            //메뉴가 완전히 열렸을 때
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
            //메뉴가 완전히 닫혔을 때
        }

        @Override
        public void onDrawerStateChanged(int newState) {
            //서랍의 현재 상태
            switch ( newState ){

                case DrawerLayout.STATE_IDLE:
                    //서랍이 완전히 열렸거나 닫혔을 때
                    break;

                case DrawerLayout.STATE_DRAGGING:
                    //손으로 여는 중일때
                    break;

                case DrawerLayout.STATE_SETTLING:
                    //버튼 클릭등의 이벤트로 서랍이 열릴때
                    break;

            }//switch
        }
    };

}








































