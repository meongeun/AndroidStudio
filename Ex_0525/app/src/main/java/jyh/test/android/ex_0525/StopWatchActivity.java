package jyh.test.android.ex_0525;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {

    TextView time_out, record;
    Button btn_start, btn_rec;
    ScrollView scroll;

    //스톱워치의 현재 상태를 관리하는 상수
   /* final static int INIT = 0;//초기상태
    final static int RUN = 1;//진행
    final static int PAUSE = 2;//일시정지*/

    //현재 상태를 저장하는 변수
    int cur_status = StopWatchStatus.INIT;

    int myCount = 1;

    //시간경과를 관리할 변수
    long myBaseTime, myPauseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        time_out = findViewById(R.id.time_out);
        record = findViewById(R.id.record);
        btn_start = findViewById(R.id.btn_start);
        btn_rec = findViewById(R.id.btn_rec);
        scroll = findViewById(R.id.scroll);

        btn_start.setOnClickListener( click );
        btn_rec.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_start:
                    switch ( cur_status ){

                        case StopWatchStatus.INIT:
                            //애플리케이션이 실행되고 나서 elapsedRealtime()호출되기까지 경과된 시간
                            myBaseTime = SystemClock.elapsedRealtime();

                            //스톱워치 시작 핸들러
                            myTimer.sendEmptyMessage(0);

                            //버튼의 문자를 STOP으로 변경
                            btn_start.setText( "STOP" );

                            //기록버튼 활성화
                            btn_rec.setEnabled( true );

                            cur_status = StopWatchStatus.RUN;
                            break;

                        case StopWatchStatus.RUN:
                            //핸들러 정지
                            myTimer.removeMessages(0);

                            myPauseTime = SystemClock.elapsedRealtime();

                            btn_start.setText("START");
                            btn_rec.setText("RESET");

                            cur_status = StopWatchStatus.PAUSE;
                            break;

                        case StopWatchStatus.PAUSE:
                            long now = SystemClock.elapsedRealtime();
                            myTimer.sendEmptyMessage(0);

                            myBaseTime += ( now - myPauseTime );

                            btn_start.setText("STOP");
                            btn_rec.setText("RECORD");

                            cur_status = StopWatchStatus.RUN;
                            break;

                    }//inner switch
                    break;

                case R.id.btn_rec:
                    switch ( cur_status ){

                        case StopWatchStatus.RUN:
                            //record에 기록
                            String str = record.getText().toString();
                            str += String.format(
                                    "%02d. %s\n", myCount, resultTime);

                            record.setText( str );

                            //스크롤 갱신
                            scroll.scrollTo( 0, record.getHeight() );

                            myCount++;
                            break;

                        case StopWatchStatus.PAUSE:
                            btn_rec.setText("RECORD");
                            btn_rec.setEnabled( false );

                            time_out.setText("00:00:00");
                            record.setText("");
                            myCount = 1;

                            cur_status = StopWatchStatus.INIT;
                            break;

                    }//inner switch
                    break;

            }//switch

        }
    };

    String resultTime = "";

    //시간계산 핸들러
    Handler myTimer = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            long now = SystemClock.elapsedRealtime();
            long outTime = now - myBaseTime;

            //시간표시 포멧 설정( 00:00:00 )
            resultTime = String.format(
                    "%02d:%02d:%02d",
                    outTime/1000/60, //분
                    outTime/1000%60, //초
                    outTime%1000%60 );// 1/1000초

            time_out.setText( resultTime );

            myTimer.sendEmptyMessage(0);

        }
    };

}





















































