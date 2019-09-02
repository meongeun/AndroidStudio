package jyh.test.android.ex_0621_m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class LevelActivity extends AppCompatActivity {

    MyLevelView mView;
    SensorManager sensorManager;
    Sensor orientation;
    SensorEventListener sensorL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView( new MyLevelView( LevelActivity.this ) );

        //애플리케이션이 실행중인 동안에는 화면이 꺼지지 않도록 유지
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mView = new MyLevelView(LevelActivity.this);

        sensorManager = (SensorManager)getSystemService( SENSOR_SERVICE );

        //센서의 종류를 결정
        //가속도 센서와 자기장 센서를 혼합해서 방위,기울기,경사도를 가져오는 것을 권장
        orientation = sensorManager.getDefaultSensor( Sensor.TYPE_ORIENTATION );

        setContentView( mView );

        sensorL = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //센서의 변경사항이 감지되면 호출되는 메서드
                float[] v = event.values;

                //v[0] : 방위값(heading)
                //v[1] : 경사도(pitch)
                //v[2] : 기울기(rolling)
                if( mView.pitch != v[1] || mView.roll != v[2] ){

                    mView.pitch = v[1] *= -1;
                    mView.roll = v[2] *= -1;
                    mView.invalidate();//onDraw()갱신

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //센서의 반응속도가 변경되면 호출되는 메서드
            }
        };

    }//onCreate()

    @Override
    protected void onResume() {
        super.onResume();
        //센서 등록
        sensorManager.registerListener(
                sensorL, orientation, SensorManager.SENSOR_DELAY_GAME );

    }

    @Override
    protected void onPause() {
        super.onPause();
        //등록된 센서 감지자를 해제
        sensorManager.unregisterListener( sensorL );
    }
}
























































