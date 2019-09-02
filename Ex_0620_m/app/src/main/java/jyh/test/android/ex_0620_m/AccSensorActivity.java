package jyh.test.android.ex_0620_m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccSensorActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3;
    SensorManager sensorM;
    SensorEventListener sensorL;
    Sensor acc_sensor;

    int x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_sensor);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        sensorM = (SensorManager)getSystemService( SENSOR_SERVICE );
        acc_sensor = sensorM.getDefaultSensor( Sensor.TYPE_ACCELEROMETER );//중력가속도 센서

        sensorL = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                x = (int)event.values[0];//x축 가속도
                y = (int)event.values[1];//y축 가속도
                z = (int)event.values[2];//z축. 중력가속도

                txt1.setText( "x : " + x );
                txt2.setText( "y : " + y );
                txt3.setText( "z : " + z );
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

    }//onCreate()

    @Override
    protected void onResume() {
        super.onResume();
        //현재 액티비티 호출시 센서 감지자 등록
        sensorM.registerListener( sensorL, acc_sensor, SensorManager.SENSOR_DELAY_FASTEST );
    }

    @Override
    protected void onPause() {
        super.onPause();
        //다른화면으로 전환 될 때 센서감지자 해제
        if( sensorM != null ){
            sensorM.unregisterListener( sensorL );
        }
    }
}









































