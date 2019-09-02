package jyh.test.android.ex_0625;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class VersionInfoActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_info);

        String version;

        try {
            //앱의 현재 버전정보를 얻어온다.
            PackageInfo i = getPackageManager().getPackageInfo( getPackageName(), 0 );
            version = i.versionName;

            Toast.makeText( getApplicationContext(),
                    "versionCode : " + i.versionCode, Toast.LENGTH_SHORT ).show();

            if( !version.equals("2.0") ){
                //만약 앱이 최신버전이 아니라면....
                builder = new AlertDialog.Builder( VersionInfoActivity.this );
                builder.setTitle( "kakaotalk" );
                builder.setMessage("최신버전이 아닙니다. 업데이트 하시겠습니까?");
                builder.setCancelable( false );

                builder.setPositiveButton("업데이트", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent( Intent.ACTION_VIEW );
                        //i.setData( Uri.parse( "market://details?id=com.kakao.talk" ) );
                        i.setData( Uri.parse("http://www.naver.com") );
                        startActivity(i);
                        finish();
                    }
                });

                builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.show();
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }//onCreate()
}












































