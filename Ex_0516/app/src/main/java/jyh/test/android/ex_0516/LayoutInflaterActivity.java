package jyh.test.android.ex_0516;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class LayoutInflaterActivity extends AppCompatActivity {

    FrameLayout frame;
    View view;

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_inflater);

        frame = findViewById(R.id.frame);

        //xml문서를 객체화 시켜주는 역할을 수행하는 LayoutInflater
        LayoutInflater in = (LayoutInflater)getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        view = in.inflate( R.layout.inner, frame );
        //frame.addView( view );

        btn1 = view.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText( LayoutInflaterActivity.this,
                                "click",
                                Toast.LENGTH_SHORT ).show();

            }
        });

    }//onCreate()
}































