package jyh.test.android.ex_0523;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Alert2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert2);
    }//onCreate()

    @Override
    public void onBackPressed() {
        //뒤로가기 버튼 클릭 감지
        AlertDialog.Builder dialog = new AlertDialog.Builder(Alert2Activity.this);
        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("cancel", null);

        dialog.setTitle("app title");
        dialog.setMessage("do you want finish??");

        dialog.show();
    }
}












































