package jyh.test.android.ex_0614;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraResultActivity extends AppCompatActivity {

    final int TAKE_CAMERA = 1;//카메라 연결 확인 리퀘스트 코드

    ImageView imgview;
    Button btn_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_result);

        imgview = findViewById(R.id.imgview);
        btn_camera = findViewById(R.id.btn_camera);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                //내장카메라 연결
                intent.setAction( MediaStore.ACTION_IMAGE_CAPTURE );
                startActivityForResult( intent, TAKE_CAMERA );

            }
        });

    }//onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if( resultCode == RESULT_OK ){

            switch ( requestCode ){

                case TAKE_CAMERA:
                    //Intent형식으로 넘어온 data라는 이름의 파라미터는
                    //카메라에서 찍은 사진이 정상적으로 저장되었다면 비어있지 않을것이다.
                    if( data != null ){
                        Bundle bundle = data.getExtras();
                        Bitmap thumbnail = (Bitmap)bundle.get("data");
                        imgview.setImageBitmap( thumbnail );
                    }
                    break;

            }//switch

        }

    }//onActivityResult()
}










































