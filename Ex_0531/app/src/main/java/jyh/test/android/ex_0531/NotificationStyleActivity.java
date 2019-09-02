package jyh.test.android.ex_0531;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;

public class NotificationStyleActivity extends AppCompatActivity {

    Button bigPicture, bigText;
    Notification notification;
    NotificationManagerCompat managerCompat;

    static final int BIG_PICTURE = 0;
    static final int BIG_TEXT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_style);

        managerCompat = NotificationManagerCompat.from(NotificationStyleActivity.this);

        bigPicture = findViewById(R.id.bigPicture);
        bigText = findViewById(R.id.bigText);

        bigPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //리소스로부터 사진을 가져온다.
                Bitmap bigPic = BitmapFactory.decodeResource(
                                    getResources(), R.mipmap.rabbit );

                NotificationCompat.BigPictureStyle p_style =
                        new NotificationCompat.BigPictureStyle();
                p_style.bigPicture( bigPic );
                p_style.setBigContentTitle("Big Title");
                p_style.setSummaryText("summaryText");

                notification = new NotificationCompat.Builder(
                        NotificationStyleActivity.this)
                        .setContentTitle("Title")
                        .setContentText("text")
                        .setSmallIcon( R.mipmap.ic_launcher )
                        .setStyle( p_style )//스타일 적용
                        .build();

                managerCompat.notify( BIG_PICTURE, notification );

            }
        });

        bigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableStringBuilder title = new SpannableStringBuilder();
                title.append("Style Title");

                title.setSpan(
                        new RelativeSizeSpan(2.0f), 0, 5, 0);

                title.setSpan( new ForegroundColorSpan(Color.RED), 0, 5, 0);

                title.setSpan( new StyleSpan(Typeface.BOLD_ITALIC), 0, 3, 0 );

                NotificationCompat.BigTextStyle t_style = new NotificationCompat.BigTextStyle();
                t_style.setBigContentTitle( title );
                t_style.bigText( "text" );

                notification = new NotificationCompat.Builder(NotificationStyleActivity.this)
                        .setContentTitle("Title")
                        .setContentText("text")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setStyle( t_style )
                        .build();

                managerCompat.notify(BIG_TEXT, notification);

            }
        });

    }//onCreate()
}









