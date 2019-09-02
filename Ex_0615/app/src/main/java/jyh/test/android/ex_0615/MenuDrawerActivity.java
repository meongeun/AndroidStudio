package jyh.test.android.ex_0615;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

public class MenuDrawerActivity extends AppCompatActivity {

    MenuDrawer left_Drawer, right_Drawer;
    Button btn_open, btn1, btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_menu_drawer);
        left_Drawer = MenuDrawer.attach(
                            MenuDrawerActivity.this,
                            MenuDrawer.Type.BEHIND,
                            Position.LEFT,
                            MenuDrawer.MENU_DRAG_WINDOW);

        right_Drawer = MenuDrawer.attach(
                            MenuDrawerActivity.this,
                            MenuDrawer.Type.BEHIND,
                            Position.RIGHT,
                            MenuDrawer.MENU_DRAG_WINDOW );

        //서랍 메인 레이아웃 지정
        left_Drawer.setContentView( R.layout.activity_menu_drawer );

        //서랍으로 사용할 레이아웃 지정
        left_Drawer.setMenuView( R.layout.left_side_menu );
        right_Drawer.setMenuView( R.layout.right_side_menu );

        //디바이스의 화면 크기 얻어오기
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics( dm );

        //dm.widthPixels -> 너비
        //dm.heightPixels -> 높이

        //서랍이 휴대폰 너비의 5/6지점까지 열리도록 설정
        left_Drawer.setMenuSize( dm.widthPixels / 6 * 5 );
        right_Drawer.setMenuSize( dm.widthPixels / 6 * 5 );

        //베젤 영역 수정
        left_Drawer.setTouchBezelSize( dm.widthPixels / 2 );
        right_Drawer.setTouchBezelSize( dm.widthPixels / 2 );

        btn_open = findViewById(R.id.btn_open);
        btn1 = findViewById(R.id.btn1);
        btn_close = findViewById(R.id.btn_close);

        btn_open.setOnClickListener( click );
        btn1.setOnClickListener( click );
        btn_close.setOnClickListener( click );

        //서랍 open감지자
        left_Drawer.setOnDrawerStateChangeListener(new MenuDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int i, int i1) {

                //왼쪽 서랍이 열려있다면.....
                if( left_Drawer.isMenuVisible() ){
                    //오른쪽 서랍을 닫는다.
                    right_Drawer.setTouchMode( MenuDrawer.STATE_CLOSED );
                }else{
                    right_Drawer.setTouchMode( MenuDrawer.STATE_DRAGGING );
                }

            }

            @Override
            public void onDrawerSlide(float v, int i) {

            }
        });

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_open://서랍열기
                    right_Drawer.openMenu();
                    break;

                case R.id.btn1:
                    Toast.makeText(
                            getApplicationContext(), "btn1",
                            Toast.LENGTH_SHORT ).show();
                    break;

                case R.id.btn_close://서랍닫기
                    right_Drawer.closeMenu();
                    break;

            }//switch

        }
    };

}













