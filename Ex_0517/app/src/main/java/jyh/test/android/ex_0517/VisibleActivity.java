package jyh.test.android.ex_0517;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VisibleActivity extends AppCompatActivity {

    Button back1, back2, btn_bottom, btn_gone;
    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visible);

        back1 = findViewById(R.id.back1);
        back2 = findViewById(R.id.back2);
        btn_bottom = findViewById(R.id.btn_bottom);
        btn_gone = findViewById(R.id.btn_gone);
        img1 = findViewById(R.id.back1_img);
        img2 = findViewById(R.id.back2_img);

        back1.setOnClickListener( click );
        back2.setOnClickListener( click );

        btn_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( btn_gone.getVisibility() == View.VISIBLE ){

                    btn_gone.setVisibility( View.GONE );

                }else{

                    btn_gone.setVisibility( View.VISIBLE );

                }

            }
        });

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.back1:
                    img1.setVisibility( View.VISIBLE );
                    img2.setVisibility( View.INVISIBLE );
                    break;

                case R.id.back2:
                    img1.setVisibility( View.INVISIBLE );
                    img2.setVisibility( View.VISIBLE );
                    break;

            }//switch

        }
    };

}









































