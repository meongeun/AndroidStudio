package jyh.test.android.ex_0518;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    Button btn_dialog, btn_menu1, btn_close;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //다이얼로그 생성
                dialog = new Dialog( DialogActivity.this );

                //다이얼로그의 타이틀 제거
                dialog.requestWindowFeature( Window.FEATURE_NO_TITLE );

                //다이얼로그 반투명 제거
                dialog.getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND );

                //다이얼로그 자체 배경 투명화
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT ));

                dialog.setContentView( R.layout.dialog_form );
                dialog.setTitle( "My Dialog Test" );

                //다이얼로그의 버튼 검색
                btn_menu1 = dialog.findViewById(R.id.btn_menu1);
                btn_close = dialog.findViewById(R.id.btn_close);
                btn_menu1.setOnClickListener( menuClick );
                btn_close.setOnClickListener( menuClick );

                //뒤로가기로 다이얼로그 강제종료 방지
                dialog.setCancelable( false );
                dialog.show();
            }
        });

    }//onCreate()

    View.OnClickListener menuClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_menu1:
                    Toast.makeText(
                            DialogActivity.this,
                            "menu1 click",
                            Toast.LENGTH_SHORT).show();

                    dialog.dismiss();

                    break;

                case R.id.btn_close:
                    //다이얼로그 닫기
                    dialog.dismiss();
                    break;

            }//switch

        }
    };

}


















































