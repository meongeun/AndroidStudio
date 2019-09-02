package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SampleIntentActivity extends AppCompatActivity {

    public  static final int REQUEST_CODE_ANOTHER =1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_intent);

        Button startBtn = (Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),AnotherActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ANOTHER);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent Data){
        super.onActivityResult(requestCode, resultCode, Date);

        if(requestCode == REQUEST_CODE_ANOTHER){
            Toast toast = Toast.makeText(getBaseContext(), "onActivityResult called with code : "+ resultCode, Toast.LENGTH_SHORT);
            toast.show();
            if(resultCode==1){
                String name = Data.getExtras().getString("name");
                toast = Toast.makeText(getBaseContext(),"result name : "+name, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
