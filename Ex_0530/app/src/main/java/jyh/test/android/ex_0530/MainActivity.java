package jyh.test.android.ex_0530;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_show_tutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show_tutorial = findViewById(R.id.btn_show_tutorial);
        btn_show_tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref =
                        PreferenceManager.getDefaultSharedPreferences(
                                                        MainActivity.this );

                SharedPreferences.Editor edit = pref.edit();
                edit.putBoolean("save", false);
                edit.commit();

                Intent i = new Intent( MainActivity.this, TutorialActivity.class );
                startActivity(i);
                finish();

            }
        });

    }//onCreate()
}












































