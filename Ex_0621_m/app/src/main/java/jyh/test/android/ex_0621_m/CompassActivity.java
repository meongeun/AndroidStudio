package jyh.test.android.ex_0621_m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class CompassActivity extends AppCompatActivity {

    MyCompassView mView;
    float heading;

    private SensorManager sensorManager;
    Sensor accelerometer;//가속도 센서
    Sensor magnetometer;//자기장 센서
    SensorEventListener sensorL;

    float[] mGravity;
    float[] mGeomagnetic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_compass);

        //화면 켜짐상태 유지
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );

        mView = new MyCompassView( CompassActivity.this );
        setContentView( mView );

        //센서관련
        sensorManager = (SensorManager)getSystemService( SENSOR_SERVICE );
        accelerometer = sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );
        magnetometer = sensorManager.getDefaultSensor( Sensor.TYPE_MAGNETIC_FIELD );

        sensorL = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //방위값 구하기 공식
                if( event.sensor.getType() == Sensor.TYPE_ACCELEROMETER ){
                    mGravity = event.values;
                }

                if( event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD ){
                    mGeomagnetic = event.values;
                }

                if( mGravity != null && mGeomagnetic != null ){

                    float[] R = new float[9];
                    float[] I = new float[9];

                    boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);

                    if( success ){
                        float[] orientation = new float[3];
                        SensorManager.getOrientation( R, orientation );

                        //orientation[0] - heading:방위
                        //orientation[1] - pitch:경사도
                        //orientation[2] - roll:기울기
                        heading = orientation[0];

                        mView.heading = heading;
                        mView.invalidate();//onDraw()갱신
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }//onCreate()

    //센서 등록
    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(
                sensorL, accelerometer, SensorManager.SENSOR_DELAY_FASTEST );

        sensorManager.registerListener(
                sensorL, magnetometer, SensorManager.SENSOR_DELAY_FASTEST );
    }

    @Override
    protected void onPause() {
        super.onPause();
        //센서해제
        sensorManager.unregisterListener( sensorL );
    }
}











































