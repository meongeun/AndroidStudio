package com.example.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText2, editText3, editText4, editText5;

    TextView textView;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        editText5=(EditText)findViewById(R.id.editText5);

        textView=(TextView)findViewById(R.id.textView);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName= editText.getText().toString();
                openDatabase(databaseName);
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName= editText2.getText().toString();
                createTable(tableName);

            }
        });

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = editText2.getText().toString();
                selectData(tableName);
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= editText3.getText().toString().trim();
                String ageStr= editText4.getText().toString().trim();
                String moblie= editText5.getText().toString().trim();
                int age = -1;
                try{
                    age=Integer.parseInt(ageStr);
                }catch (Exception e){
                    insertData(name, age, moblie);
                }
            }
        });
    }

    public void openDatabase(String databaseName){
        printIn("openDatabase() 호출됨.");
        database= openOrCreateDatabase(databaseName, MODE_PRIVATE,null);
        if(database != null) {
            printIn("데이터베이스 오픈됨.");
        }
    }

    public void createTable(String tableName){
        printIn("createTable() 호출됨");
        if (database!=null){
            String sql = "create table "+ tableName + "(_id integer PRIMARY KEY autoincrement, name text, age integer, mobile text)";
            database.execSQL(sql);

            printIn("테이블 생성됨");
        }else{
            printIn("먼저 데이터베이스를 오픈하세요.");
        }
    }
    public void insertData(String name, int age, String mobile){
        printIn("insertData() 호출됨.");

        if (database != null){
            String sql = "insert into customer(name, age, mobile) values(?,?,?)";
            Object[] params = {name, age, mobile};
            database.execSQL(sql, params);

            printIn("데이터 추가함.");
        }else{
            printIn("먼저 데이터베이스를 오픈하세요");
        }
    }
    public void printIn(String data){
        textView.append(data + "\n");
    }
    public void selectData(String tableName){
        printIn("selectData() 호출됨.");

        if (database != null){
            String sql = "select name, age, mobile from "+ tableName;
            Cursor cursor = database.rawQuery(sql, null);
            printIn("조회된 데이터 개수 : "+cursor.getCount());

            for (int i =0; i<cursor.getCount(); i++){
                cursor.moveToNext();
                String name =cursor.getString(0);
                int age = cursor.getInt(1);
                String mobile = cursor.getString(2);

                printIn("#"+i+ "-> "+name + ", "+age+", "+mobile);
            }
            cursor.close();
        }
    }
}
