package com.example.arraystest;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res =getResources();
        String[] fruits = res.getStringArray(R.array.fruits);
        TextView textFruits = (TextView)findViewById(R.id.textFruits);
        for(String fruit: fruits){
            textFruits.append(fruit+"\n");
        }
        int[] fibonacci = res.getIntArray(R.array.fibonacci);
        TextView textFiconacci = (TextView)findViewById(R.id.textFibonacci);
        for (int num: fibonacci){
            textFiconacci.append(num+"\n");
        }
    }
}
