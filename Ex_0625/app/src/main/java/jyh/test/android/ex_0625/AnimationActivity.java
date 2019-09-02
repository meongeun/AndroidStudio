package jyh.test.android.ex_0625;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AnimationActivity extends AppCompatActivity {

    Button btn_menu, btn01, btn02, btn03, btn04;
    Animation menu_visible_ani, menu_rotate;
    LinearLayout visible_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        visible_layout = findViewById(R.id.visible_layout);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener( menu_click );

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);

        btn01.setOnClickListener( item_click );
        btn02.setOnClickListener( item_click );
        btn03.setOnClickListener( item_click );
        btn04.setOnClickListener( item_click );

    }//onCreate()

    View.OnClickListener menu_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if( visible_layout.getVisibility() == View.VISIBLE ){
                //메뉴를 숨긴다.
                menu_visible_ani = AnimationUtils.loadAnimation(
                        AnimationActivity.this, R.anim.menu_invisible );

                visible_layout.startAnimation( menu_visible_ani );
                visible_layout.setVisibility( View.INVISIBLE );

            }else{
                //메뉴를 보인다.
                menu_visible_ani = AnimationUtils.loadAnimation(
                        AnimationActivity.this, R.anim.menu_visible );
                visible_layout.startAnimation( menu_visible_ani );
                visible_layout.setVisibility( View.VISIBLE );
            }

            //메뉴 회전
            menu_rotate = AnimationUtils.loadAnimation(
                    AnimationActivity.this, R.anim.menu_rotation);
            btn_menu.startAnimation( menu_rotate );

        }
    };

    View.OnClickListener item_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn01:
                    Toast.makeText( getApplicationContext(), "home", Toast.LENGTH_SHORT ).show();
                    break;

                case R.id.btn02:
                    Toast.makeText( getApplicationContext(), "강의노트", Toast.LENGTH_SHORT ).show();
                    break;

                case R.id.btn03:
                    Toast.makeText( getApplicationContext(), "학생정보", Toast.LENGTH_SHORT ).show();
                    break;

                case R.id.btn04:
                    Toast.makeText( getApplicationContext(), "test", Toast.LENGTH_SHORT ).show();
                    break;

            }//switch
        }
    };

}
















































