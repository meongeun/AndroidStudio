package jyh.test.android.ex_0523;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    Button btn_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        btn_alert = findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //alert dialog생성
                AlertDialog.Builder dialog = new AlertDialog.Builder( AlertActivity.this );

                //alert dialog는 최대 세 개의 버튼을 추가할 수 있다.
                dialog.setPositiveButton("OK", click );

                //button클릭시 다른 이벤트 처리 없이 다이얼로그만 종료하고 싶다면
                //감지자에 null을 추가하면 된다.
                dialog.setNegativeButton("Cancel", null );

                dialog.setNeutralButton("Neutral", click );

                dialog.setTitle("app title");
                dialog.setMessage( "dialog message" );

                dialog.show();
            }
        });

    }//onCreate()

    DialogInterface.OnClickListener click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            switch ( which ){

                case DialogInterface.BUTTON_POSITIVE:
                    Toast.makeText(AlertActivity.this, "positive", Toast.LENGTH_SHORT).show();
                    break;

               /* case DialogInterface.BUTTON_NEGATIVE:
                    Toast.makeText( AlertActivity.this, "negative", Toast.LENGTH_SHORT ).show();
                    break;*/

                case DialogInterface.BUTTON_NEUTRAL:
                    Toast.makeText( AlertActivity.this, "neutral", Toast.LENGTH_SHORT ).show();
                    break;

            }//switch

        }
    };


}





























































