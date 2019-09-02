package com.example.dialogalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String items[] ={"사과", "바나나", "포도"};
    private final boolean status[] = {false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        switch (v.getId()){
            case R.id.btnDialog1:
                builder.setTitle("대화상자1");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage(Html.fromHtml("안드로이드의 기본 대화상자로는 "+"<b>AlertDialog</b>가 있으며, <i>AlertDialog</i>를 특수화한 "+
                        "<b>DatePickerDialog</b>와 <b>TimePickerDialog</b>가 있다."));

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
                break;
            case R.id.btnDialog2:
                builder.setTitle("대화상자2");
                builder.setIcon(R.mipmap.ic_launcher_round);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which],Toast.LENGTH_SHORT).show();
                    }
                });
            builder.create().show();
            break;
            case R.id.btnDialog3:
                builder.setTitle("대화상자3");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,items[which],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("Close",null);
                builder.create().show();
                break;
            case R.id.btnDialog4:
                builder.setTitle("대화상자4");
                builder.setIcon(R.mipmap.ic_launcher_foreground);
                builder.setMultiChoiceItems(items, status, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        status[which]=isChecked;
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,status[0]+", "+status[1]+", "+status[2],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();

        }
    }
}
