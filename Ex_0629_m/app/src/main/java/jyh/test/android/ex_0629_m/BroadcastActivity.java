package jyh.test.android.ex_0629_m;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    Button btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener( click );
        btn_stop.setOnClickListener( click );

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent receiveIntent = null;
            PendingIntent pendingIntent = null;

            switch ( v.getId() ){

                case R.id.btn_start:
                    //10초 간격으로 리시버를 호출
                    alarmManager = (AlarmManager)getSystemService( ALARM_SERVICE );
                    receiveIntent = new Intent( BroadcastActivity.this, MyReceiver.class );
                    pendingIntent = PendingIntent.getBroadcast(
                            BroadcastActivity.this,
                            0, receiveIntent, PendingIntent.FLAG_UPDATE_CURRENT );

                    long period = 1000 * 10;

                    //AlarmManager.ELAPSED_REALTIME_WAKEUP : 부팅 후 시간을 기준으로 시간을 측정. 장치를 깨움
                    //AlarmManager.ELAPSED_REALTIME : 부팅 후 시간을 기준으로 시간을 측정
                    //AlarmManager.RTC : UTC표준 시간을 기준( 우리가 사용하는 시간 )
                    //AlarmManager.RTC_WAKEUP : UTC표준 시간을 기준으로 장치를 깨움.
                    alarmManager.setRepeating(
                            AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            SystemClock.elapsedRealtime(), period, pendingIntent);
                    break;

                case R.id.btn_stop:
                    //알람 취소
                    alarmManager = (AlarmManager)getSystemService( ALARM_SERVICE );
                    receiveIntent = new Intent( BroadcastActivity.this, MyReceiver.class );
                    pendingIntent = PendingIntent.getBroadcast(
                            BroadcastActivity.this,
                            0, receiveIntent, PendingIntent.FLAG_UPDATE_CURRENT );

                    alarmManager.cancel( pendingIntent );
                    break;

            }//switch

        }
    };

}





































































































