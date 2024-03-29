package com.example.mythread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ValueHandler handler = new ValueHandler();
    Handler handler2 = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    textView = (TextView)findViewById(R.id.textView);

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               BackgroungThread thread = new BackgroungThread();
               thread.start();

                /*new Thread(new Runnable() {
                    int value =0;
                    boolean running=false;
                    @Override
                    public void run() {

                        running=true;
                        while(running){
                            value +=1;
                            handler2.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("현재 값: "+value);
                                }
                            });
                            try {
                                Thread.sleep(1000);

                            }catch (Exception e){

                            }
                        }
                    }
                }).start();*/

            }
        });

        Button button2 =(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               // textView.setText("현재 값 : "+value);
            }
        });
    }

    class BackgroungThread extends Thread{
        int value =0;
        boolean running = false;
        public void run(){
            running=true;
            while(running){
                value +=1;
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value",value);
                message.setData(bundle);
                message.setData(bundle);
                handler.sendMessage(message);
                try {
                    Thread.sleep(1000);

                }catch (Exception e){

                }
            }
        }
    }

    class ValueHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle= msg.getData();
            int value = bundle.getInt("value");
            textView.setText("현재 값: "+value);
        }
    }
}
