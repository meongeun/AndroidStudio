package jyh.test.android.ex_0626;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        //전화걸기 권한에 대한 수락 여부 확인
        if( ActivityCompat.checkSelfPermission(
                PermissionActivity.this, Manifest.permission.CALL_PHONE )
                    != PackageManager.PERMISSION_GRANTED ){
            setPermission();
            return;
        }

        //주소록 접근 권한에 대한 수락 여부 확인
        if( ActivityCompat.checkSelfPermission(
                PermissionActivity.this, Manifest.permission.READ_CONTACTS )
                    != PackageManager.PERMISSION_GRANTED){

            setPermission();
            return;
        }

    }//onCreate()

    private void setPermission(){

        TedPermission.with( PermissionActivity.this )
                .setPermissionListener( permissionListener )
                .setDeniedMessage( "이 앱에서 요구하는 2개의 권한이 있습니다.\n\n " +
                        "[설정] > [권한]에서 해당 권한을 활성화 해 주세요" )
                .setPermissions(
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.CALL_PHONE)
                .check();

    }//setPermission()

    //앱의 권한설정 감지자
    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            //모든 권한이 수락된 경우
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            //한가지라도 수락되지 않은 권한이 있는 경우
            finish();
        }
    };

}


























































