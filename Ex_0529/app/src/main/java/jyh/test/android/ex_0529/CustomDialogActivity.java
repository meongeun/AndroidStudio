package jyh.test.android.ex_0529;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class CustomDialogActivity extends AppCompatActivity {

    FrameLayout frame;
    Button btn_cancel, btn_ok;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        frame = findViewById(R.id.frame);

        //LayoutInflater를 통해 xml문서를 view로 객체화 시켜준다.
        LayoutInflater in = (LayoutInflater)getSystemService( LAYOUT_INFLATER_SERVICE );
        view = in.inflate( R.layout.inner_dialog, null );
        frame.addView( view );

        btn_cancel = findViewById(R.id.btn_cancel);
        btn_ok = findViewById(R.id.btn_ok);

        btn_cancel.setOnClickListener( click );
        btn_ok.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch( v.getId() ){

                case R.id.btn_cancel:
                    frame.setVisibility( View.GONE );
                    break;

                case R.id.btn_ok:
                    finish();
                    break;

            }//switch

        }
    };

    @Override
    public void onBackPressed() {

        if( frame.getVisibility() != View.VISIBLE ) {
            frame.setVisibility( View.VISIBLE );

        }else{
            frame.setVisibility( View.GONE );

        }

    }//onBackPressed()
}












































