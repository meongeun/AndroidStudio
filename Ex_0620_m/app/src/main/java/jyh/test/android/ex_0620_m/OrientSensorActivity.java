package jyh.test.android.ex_0620_m;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrientSensorActivity extends AppCompatActivity {

    //센서작업에 필요한 객체들
    SensorManager sensorM;
    SensorEventListener sensorL;
    Sensor orientSensor;

    int n1, n2, n3;

    TextView txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orient_sensor);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        sensorM = (SensorManager)getSystemService( SENSOR_SERVICE );
        orientSensor = sensorM.getDefaultSensor( Sensor.TYPE_ORIENTATION );

        //센서 감지자 생성
        sensorL = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //센서의 값이 변경될 때 마다 호출되는 메서드

                n1 = (int)event.values[0];//방위값
                n2 = (int)event.values[1];//경사도
                n3 = (int)event.values[2];//회전값

                //센서 값이 변경될때마다 화면 갱신
                txt1.setText( "방위 : " + n1 );
                txt2.setText( "경사도 : " + n2 );
                txt3.setText( "회전값 : " + n3 );

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //센서의 민감도가 변경되면 호출되는 메서드
            }
        };

    }//onCreate()

    //현재 액티비티가 표시되면 센서 감지자 등록
    @Override
    protected void onResume() {
        super.onResume();

        //registerListener( 센서이벤트 감지자, 센서종류, 센서반응속도 );
        sensorM.registerListener( sensorL, orientSensor, SensorManager.SENSOR_DELAY_GAME );

        //SENSOR_DELAY_FASTEST
        //SENSOR_DELAY_GAME
        //SENSOR_DELAY_UI
        //SENSOR_DELAY_NORMAL

    }

    //일시정지 상태일때 센서 해제
    @Override
    protected void onPause() {
        super.onPause();

        if( sensorM != null ){
            sensorM.unregisterListener( sensorL );
        }

    }
}





































