package jyh.test.android.ex_0629_m;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //외부에서 브로드캐스트리시버를 호출하면 실행되는 메서드

        //알림 클릭시 전환할 액티비티
        Intent receiveIntent = new Intent( context, BroadcastActivity.class );

        //알림이 클릭될 때까지 화면전환을 하지 않고 대기하는 PendingIntent
        //PendingIntent는 Intent를 직접 보내지 않고 가지고 대기하고 있다가
        //특정 상황에서 화면전환이 가능하도록 해 주는 클래스

        //PendingIntent.FLAG_UPDATE_CURRENT - 이미 인텐트가 실행중이라면 내용을 갱신
        //PendingIntent.FLAG_ONE_SHOT - 인텐트를 한번만 실행되게 한다
        //PendingIntent.FLAG_CANCEL_CURRENT - 이미 실행중인 인텐트를 취소하고 새로 실행
        //PendingIntent.FLAG_NO_CREATE - 실행중인 인텐트가 없다면 새로 생성하지 않는다
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 0, receiveIntent, PendingIntent.FLAG_UPDATE_CURRENT );

        NotificationManager nm =
                (NotificationManager)context.getSystemService( Context.NOTIFICATION_SERVICE );

        Notification notification = new NotificationCompat.Builder( context )
                                        .setContentTitle( "제목" )
                                        .setContentText("내용")
                                        .setSmallIcon( R.mipmap.ic_launcher )
                                        .setContentIntent( pendingIntent )
                                        .setAutoCancel(true)
                                        .build();

        nm.notify( 0, notification );

    }//onReceive()
}




















































