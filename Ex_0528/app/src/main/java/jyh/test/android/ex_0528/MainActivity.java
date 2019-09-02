package jyh.test.android.ex_0528;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button bt_date, btn_send;
    EditText edit_b_day, edit_name, edit_age, edit_phone;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_date = findViewById(R.id.bt_date);
        btn_send = findViewById(R.id.btn_send);

        edit_b_day = findViewById(R.id.edit_b_day);
        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        edit_phone = findViewById(R.id.edit_phone);

        bt_date.setOnClickListener(dateClick);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        MainActivity.this, SubActivity.class );

                //화면 전환시 전달할 값들
                String name = edit_name.getText().toString();
                String age = edit_age.getText().toString();
                String phone = edit_phone.getText().toString();
                String birth = edit_b_day.getText().toString();

                //값 전달 방법1 - Intent를 통한 전달
//                i.putExtra("my_name", name);
//                i.putExtra("my_age", age);
//                i.putExtra( "my_phone", phone );

                //값 전달 방법2 - Bundle을 통한 전달
                //Bundle은 여러가지 타입의 값을 저장하는 Map구조의 클래스
                Bundle bundle = new Bundle();
                bundle.putString("m_name", name);
                bundle.putString("m_age", age);
                bundle.putString("m_phone", phone);
                bundle.putString("m_birth", birth);

                //intent에 bundle을 저장
                i.putExtras(bundle);

                startActivity(i);
            }
        });

    }//onCreate()

    View.OnClickListener dateClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //현재 날짜를 가져온다.
            Calendar now = Calendar.getInstance();
            int y = now.get( Calendar.YEAR );//년
            int m = now.get( Calendar.MONTH );//월
            int d = now.get( Calendar.DAY_OF_MONTH );//일

            dialog = new DatePickerDialog(
                    MainActivity.this, //context
                    dateSeleter, //날짜 선택 이벤트 감지자
                    y, //년
                    m, //월
                    d);//일

            dialog.show();

        }
    };

    DatePickerDialog.OnDateSetListener dateSeleter = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            //날짜 형식 지정
            //2018-05-29

            //인자값중 month는
            //1월 -> 0
            //12월 -> 11...
            String date = String.format( "%d-%02d-%02d",
                                            year, month + 1, dayOfMonth );

            edit_b_day.setText( date );

        }
    };


}
















































