package jyh.test.android.ex_0530;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class TutorialActivity extends AppCompatActivity {

    CheckBox check;
    Button btn_home;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        pref = PreferenceManager.getDefaultSharedPreferences(
                                        TutorialActivity.this);

        //체크박스의 마지막 상태를 로드
        boolean c = pref.getBoolean("save", false);
        if( c ){
            showMain();
        }

        check = findViewById(R.id.check);
        btn_home = findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor edit = pref.edit();
                //체크박스의 마지막 상태를 저장
                edit.putBoolean("save", check.isChecked());
                edit.commit();

                showMain();

            }
        });

    }//onCreate()

    private void showMain(){

        Intent i = new Intent(
                TutorialActivity.this, MainActivity.class );
        startActivity(i);
        finish();

    }

}






































