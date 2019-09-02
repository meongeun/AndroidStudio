package jyh.test.android.ex_0629_m;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ajalt.reprint.core.AuthenticationFailureReason;
import com.github.ajalt.reprint.core.AuthenticationListener;
import com.github.ajalt.reprint.core.Reprint;

public class PingerprintActivity extends AppCompatActivity {

    TextView text;
    int count = 35;//5회 인식 일패시 대기시간
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingerprint);

        pref = PreferenceManager.getDefaultSharedPreferences(
                                    PingerprintActivity.this );
        text = findViewById(R.id.text);

        //지문사용 초기화
        Reprint.initialize( PingerprintActivity.this );

        //초기화 후 지문사용 가능 기기 체크
        if( checkDeviceSpec() ){

            Reprint.authenticate(new AuthenticationListener() {
                @Override
                public void onSuccess(int moduleTag) {
                    text.setText("인증성공");
                }

                @Override
                public void onFailure(AuthenticationFailureReason failureReason, boolean fatal, CharSequence errorMessage, int moduleTag, int errorCode) {
                    text.setText("인증에 실패했습니다. 다시 시도하세요");

                    if( fatal ){//5회 지문인식 실패시 fatal이 true로 발생

                        count = pref.getInt("restart_count", 35);
                        handler.sendEmptyMessage(0);

                    }
                }
            });

        }else{
            //지문사용 불가
            finish();
        }

    }//onCreate()

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            handler.sendEmptyMessageDelayed(0, 1000);

            text.setText(--count + "초 후에 다시 시도하세요");
            SharedPreferences.Editor edit = pref.edit();
            edit.putInt( "restart_count", count );
            edit.commit();

            if( count == 0 ){
                count = 35;
                edit.putInt( "restart_count", count );
                edit.commit();

                handler.removeMessages(0);
                finish();
            }

        }
    };

    //지문인식을 지원하는 기기인지 확인
    private boolean checkDeviceSpec(){

        boolean fingerprintFlag = Reprint.isHardwarePresent();
        boolean hasRegisteredFlag = Reprint.hasFingerprintRegistered();

        if( !fingerprintFlag ){
            Toast.makeText(
                    getApplicationContext(),
                    "지문인식을 지원하지 않는 기기입니다.",
                    Toast.LENGTH_SHORT).show();
        }else{
            if( !hasRegisteredFlag ){
                Toast.makeText(
                        getApplicationContext(),
                        "등록된 지문이 없습니다.",
                        Toast.LENGTH_SHORT).show();
            }

        }

        return fingerprintFlag && hasRegisteredFlag;

    }//checkDeviceSpec()

}


































































