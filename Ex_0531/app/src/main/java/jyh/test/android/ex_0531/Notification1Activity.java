package jyh.test.android.ex_0531;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification1Activity extends AppCompatActivity {

    Button basicBtn, actionBtn, basicCancelBtn, actionCancelBtn;

    //알림매니저
    NotificationManagerCompat notificationManager;

    //매니저를 통해 전달할 기본알림 id
    static final int BASIC_ID = 0;

    //매니저를 통해 전달할 액션알림 id
    static final int ACTION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification1);

        //알림매니저
        notificationManager = NotificationManagerCompat.from( Notification1Activity.this );

        basicBtn = findViewById(R.id.basicBtn);
        basicCancelBtn = findViewById(R.id.basicCancelBtn);

        actionBtn = findViewById(R.id.actionBtn);
        actionCancelBtn = findViewById(R.id.actionCancelBtn);

        basicBtn.setOnClickListener( basicClick );
        basicCancelBtn.setOnClickListener( basicClick );

        actionBtn.setOnClickListener( actionClick );
        actionCancelBtn.setOnClickListener( actionClick );

    }//onCreate()

    View.OnClickListener actionClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.actionBtn:
                    //액티비티 전환을 위한 Intent생성
                    Intent viewIntent = new Intent(
                            Notification1Activity.this, Notification1Activity.class );
                    viewIntent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );

                    //액션을 실행할 때까지 대기할 팬딩인텐트 생성
                    //PendingIntent는 Intent를 직접적으로 보내지 않고, 다른 클래스에게
                    //Intent정보를 위임해주기 위한 클래스
                    PendingIntent viewPending =
                            PendingIntent.getActivity(
                                    Notification1Activity.this,
                                    0,
                                    viewIntent,
                                    PendingIntent.FLAG_CANCEL_CURRENT);
                    // PendingIntent.FLAG_CANCEL_CURRENT : 이미 실행된 인텐트를 취소하고 새로 생성

                    Notification notification =
                            new NotificationCompat.Builder(
                                    Notification1Activity.this )
                            .setContentTitle("action title")
                            .setContentText("action text")
                            .setSmallIcon( R.mipmap.ic_launcher )
                            .addAction( R.mipmap.gunship,
                                        "ActionButton",
                                        viewPending)
                            .build();

                    notificationManager.notify( ACTION_ID, notification );
                    break;

                case R.id.actionCancelBtn:
                    notificationManager.cancel( ACTION_ID );
                    break;

            }//switch

        }
    };

    View.OnClickListener basicClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.basicBtn:

                    Intent i = new Intent(
                            Notification1Activity.this, Notification1Activity.class );
                    i.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );

                    PendingIntent pending = PendingIntent.getActivity(
                                                Notification1Activity.this,
                                                0,
                                                i,
                                                PendingIntent.FLAG_CANCEL_CURRENT);

                    Notification notification =
                            new NotificationCompat.Builder(Notification1Activity.this)
                            .setContentTitle("basicNotiTitle")
                            .setContentText("basic text")
                            .setSmallIcon( R.mipmap.ic_launcher )
                            .setContentIntent( pending )
                            .setAutoCancel(true)
                            .build();

                    //매니저를 통해 알림 전송
                    notificationManager.notify( BASIC_ID, notification );
                    break;

                case R.id.basicCancelBtn:
                    notificationManager.cancel( BASIC_ID );
                    break;

            }//switch

        }
    };

}





























































