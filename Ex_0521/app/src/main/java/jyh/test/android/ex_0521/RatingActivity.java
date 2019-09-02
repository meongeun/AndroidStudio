package jyh.test.android.ex_0521;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {

    TextView result_txt;
    Button btn;
    Dialog dialog;
    RatingBar rat;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        result_txt = findViewById(R.id.result_txt);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new Dialog( RatingActivity.this );
                dialog.setContentView( R.layout.rating_dialog );

                //다이얼로그가 가진 객체들 검색
                btn_ok = dialog.findViewById( R.id.btn_ok );
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();//다이얼로그 종료
                    }
                });

                rat = dialog.findViewById( R.id.rating );

                //true로 설정하면 사용자가 임의로 별점을 변경할 수 없다.
                rat.setIsIndicator( false );

                //별 반칸당 점수 할당
                rat.setStepSize( 0.5f );

                //레이팅바의 변경사항을 감지하는 감지자
                rat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                        //별 갯수에 따른 한칸 당 점수
                        float st = 10.0f / rat.getNumStars();

                        //별점을 소수점 한자리에서 끊어준다.
                        String str = String.format( "%.1f", ( st * rating ) );

                        result_txt.setText( str + " / 10.0" );

                    }
                });

                dialog.setTitle("rating");
                dialog.show();
            }
        });

    }//onCreate()
}































