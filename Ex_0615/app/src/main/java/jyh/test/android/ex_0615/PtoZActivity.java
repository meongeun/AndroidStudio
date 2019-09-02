package jyh.test.android.ex_0615;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class PtoZActivity extends AppCompatActivity {

    ImageView mImageView;
    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pto_z);

        mImageView = findViewById(R.id.iv_photo);

        //이미지 뷰와 PhotoViewAttacher를 연결
        mAttacher = new PhotoViewAttacher( mImageView );

        mAttacher.update();
    }//onCreate()
}














































