package jyh.test.android.ex_0531;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FocusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_focus);

        //추가할 레이아웃을 생성
        LinearLayout rootLinearLayout = new LinearLayout( FocusActivity.this );

        //생성된 레이아웃에 방향성 지정
        rootLinearLayout.setOrientation( LinearLayout.VERTICAL );

        //생성된 레이아웃에 버튼객체 추가
        for( int i = 0; i < 5; i++ ){

            Button b = new Button( FocusActivity.this );
            b.setId(i);//버튼에 id셋팅
            b.setText( "button " + (i + 1) );

            //버튼의 너비와 높이
            b.setWidth( LinearLayout.LayoutParams.MATCH_PARENT );
            b.setHeight( LinearLayout.LayoutParams.WRAP_CONTENT );

            //버튼에 이벤트 감지자 등록
            b.setOnClickListener( click );

            //rootLinearLayout에 생성된 버튼을 추가
            rootLinearLayout.addView( b );

        }//for

        //현재 액티비티에 레이아웃을 추가
        setContentView( rootLinearLayout );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast.makeText(
                    getApplicationContext(),
                    "button " + (v.getId() + 1), Toast.LENGTH_SHORT ).show();

        }
    };

}















































