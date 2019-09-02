package jyh.test.android.ex_0629_m;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SwipeRefreshActivity extends AppCompatActivity {

    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);

        refreshLayout = findViewById(R.id.swipe);
        refreshLayout.setOnRefreshListener( refresh );//감지자 등록

        //디스크의 배경색
        refreshLayout.setProgressBackgroundColorSchemeColor(
                                Color.argb( 255, 127, 179, 255 ) );

        //디스크 사이즈 변경
        refreshLayout.setSize( SwipeRefreshLayout.LARGE );//DEFAULT:기본

        //그....왜...디스크 안에 그.... 꺼먼거 막...돌아가는...막 그거....
        refreshLayout.setColorSchemeResources(
                R.color.color1, R.color.color2, R.color.color3, R.color.color4 );

        //디스크 확대기능 & 끝 위치
        refreshLayout.setProgressViewEndTarget( true, 400 );

        //디스크 확대기능 & 시작/끝 위치
        //refreshLayout.setProgressViewOffset( true, 100, 200 );

    }//onCreate()

    SwipeRefreshLayout.OnRefreshListener refresh = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //로딩시작시 호출되는 메서드
            Toast.makeText( getApplicationContext(), "로딩시작", Toast.LENGTH_SHORT ).show();
            h.sendEmptyMessageDelayed(0, 3000);
        }
    };

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //로딩 완료시 디스크 제거
            refreshLayout.setRefreshing( false );
        }
    };

}
















































