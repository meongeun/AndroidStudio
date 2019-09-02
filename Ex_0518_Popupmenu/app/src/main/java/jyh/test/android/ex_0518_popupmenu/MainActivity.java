package jyh.test.android.ex_0518_popupmenu;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button menu_show_btn;
    Button anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anchor = findViewById(R.id.anchor);
        menu_show_btn = findViewById(R.id.menu_show_btn);

        menu_show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //팝업메뉴
                PopupMenu popup = new PopupMenu(
                        MainActivity.this,  //화면제어권자
                        anchor); //anchor : 팝업을 띄울 기준이 되는 view

                //팝업메뉴가 참조할 메뉴 xml
                getMenuInflater().inflate( R.menu.main_menu, popup.getMenu() );

                //팝업메뉴에 이벤트 감지자 등록
                popup.setOnMenuItemClickListener( popupClick );

                popup.show();//메뉴 노출

            }
        });

    }//onCreate()

    PopupMenu.OnMenuItemClickListener popupClick = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch ( item.getItemId() ){

                case R.id.menu1:
                    Toast.makeText( MainActivity.this,
                                    "email menu click", Toast.LENGTH_SHORT ).show();
                    break;

                case R.id.menu2:
                    Toast.makeText( MainActivity.this,
                                    "phone menu click", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.menu3:
                    //액티비티 종료
                    finish();
                    break;

            }
            return true;
        }
    };

}












