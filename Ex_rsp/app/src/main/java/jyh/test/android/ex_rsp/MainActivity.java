package jyh.test.android.ex_rsp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView[] com = new ImageView[3];
    ImageView[] user = new ImageView[3];
    Button btnStart, btnExit, selectR, selectS, selectP;

    //그림을 움직이기 위한 변수
    int count = 0;
    int rot = 0;

    int comRand = 0;//컴퓨터 난수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com[0] = findViewById(R.id.comR);
        com[1] = findViewById(R.id.comS);
        com[2] = findViewById(R.id.comP);

        user[0] = findViewById(R.id.userR);
        user[1] = findViewById(R.id.userS);
        user[2] = findViewById(R.id.userP);

        btnStart = findViewById(R.id.btnStart);
        btnExit = findViewById(R.id.btnExit);

        selectR = findViewById(R.id.btnR);
        selectS = findViewById(R.id.btnS);
        selectP = findViewById(R.id.btnP);

        btnStart.setOnClickListener( myBtn );
        btnExit.setOnClickListener( myBtn );

        selectR.setOnClickListener( selectButton );
        selectS.setOnClickListener( selectButton );
        selectP.setOnClickListener( selectButton );

    }//onCreate()

    View.OnClickListener myBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btnStart:
                    //애니메이션 핸들러
                    handler.sendEmptyMessage(0);
                    break;

                case R.id.btnExit:
                    finish();
                    break;

            }//switch

        }
    };

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            moving();
            handler.sendEmptyMessageDelayed(0, 50);

        }
    };

    //유저와 컴퓨터 이미지의 숨김처리를 위한 메서드
    private void visible( int c, int u ){

        com[c].setVisibility( View.VISIBLE );
        user[u].setVisibility( View.VISIBLE );

        for( int i = 0; i < 3; i++ ){

            if( i != c )
                com[i].setVisibility( View.INVISIBLE );

            if( i != u )
                user[i].setVisibility( View.INVISIBLE );

        }

    }//visible()

    //이미지를 움직이는 메서드
    private void moving(){

        count++;
        rot = count % 3;

        visible( rot, rot );

        if( count == 3 )
            count = 0;
    }

    View.OnClickListener selectButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            comRand = new Random().nextInt(3);
            handler.removeMessages(0);

            int userResult = 0;

            switch ( v.getId() ){

                case R.id.btnR:
                    userResult = 0;
                    break;

                case R.id.btnS:
                    userResult = 1;
                    break;

                case R.id.btnP:
                    userResult = 2;
                    break;

            }//switch

            visible( comRand, userResult );

        }
    };


}








































