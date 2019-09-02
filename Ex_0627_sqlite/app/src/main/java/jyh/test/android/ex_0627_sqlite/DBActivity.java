package jyh.test.android.ex_0627_sqlite;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBActivity extends AppCompatActivity {

    SQLiteDatabase mDatabase;
    Button btn_allFriends, btn_searchFriends, btn_insertFriend, btn_delFriends;
    EditText input_et;
    TextView result_txt;
    boolean isFirst = true;

    EditText name, phone, age;
    Button send;
    Dialog dialog;

    SharedPreferences pref;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        pref = PreferenceManager.getDefaultSharedPreferences( this );

        if( ActivityCompat.checkSelfPermission(
                DBActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE ) !=
                PackageManager.PERMISSION_GRANTED ){

            setPermission();
            return;
        }

        if( ActivityCompat.checkSelfPermission(
                DBActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE ) !=
                PackageManager.PERMISSION_GRANTED){

            setPermission();
            return;
        }

        input_et = findViewById(R.id.input_et);
        result_txt = findViewById(R.id.result_txt);
        btn_allFriends = findViewById(R.id.btn_allFriends);
        btn_delFriends = findViewById(R.id.btn_delFriends);
        btn_insertFriend = findViewById(R.id.btn_insertFriend);
        btn_searchFriends = findViewById(R.id.btn_searchFriends);

        btn_allFriends.setOnClickListener( myClick );
        btn_delFriends.setOnClickListener( myClick );
        btn_insertFriend.setOnClickListener( myClick );
        btn_searchFriends.setOnClickListener( myClick );

        load();
        copyAssets();
        save();

        //DB읽기
        mDatabase = openOrCreateDatabase(
                Environment.getExternalStorageDirectory() + "/database/myDB.db",
                SQLiteDatabase.CREATE_IF_NECESSARY, null);

        //테이블 검색 실패시 생성
        searchQuery( "create table if not exists friend( name varchar2(20), phone varchar2(20), age number(3) );" );

    }//onCreate()

    private void save(){

        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean( "save", isFirst );
        edit.commit();

    }

    private void load(){
        isFirst = pref.getBoolean("save", true);
    }

    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_allFriends://전체목록 조회
                    searchQuery( "select * from friend" );
                    break;

                case R.id.btn_delFriends://친구삭제
                    String str2 = input_et.getText().toString().trim();
                    if( str2.length() != 0){
                        String tmp = String.format(
                                "delete from friend where name='%s'", str2 );
                        searchQuery( tmp );

                        //삭제 후 전체목록 갱신
                        searchQuery("select * from friend");
                    }else{
                        Toast.makeText( getApplicationContext(),
                                "검색할 이름을 입력하세요",
                                Toast.LENGTH_SHORT ).show();
                    }
                    break;

                case R.id.btn_insertFriend://친구추가
                    dialog = new Dialog( DBActivity.this, R.style.Dialog );
                    dialog.setContentView( R.layout.dialog );

                    name = dialog.findViewById(R.id.name);
                    phone = dialog.findViewById(R.id.phone);
                    age = dialog.findViewById(R.id.age);
                    send = dialog.findViewById(R.id.send);

                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //DB에 데이터를 추가
                            ContentValues values = new ContentValues();
                            values.put("name", name.getText().toString());
                            values.put("phone", phone.getText().toString());
                            values.put("age", Integer.parseInt( age.getText().toString() ) );
                            mDatabase.insert( "friend", null, values );

                            //추가된 값을 갱신하기 위해 전체목록 보여주기를 수행
                            searchQuery("select * from friend");


                            dialog.dismiss();
                        }
                    });

                    dialog.setTitle("친구추가");
                    dialog.show();
                    break;

                case R.id.btn_searchFriends://친구검색
                    String str = input_et.getText().toString().trim();
                    if( str.length() != 0){
                        String tmp = String.format(
                                "select * from friend where name='%s'", str );
                        searchQuery( tmp );
                    }else{
                        Toast.makeText( getApplicationContext(),
                                "검색할 이름을 입력하세요",
                                Toast.LENGTH_SHORT ).show();
                    }
                    break;

            }//switch

        }
    };

    //sql문장을 통해 검색결과를 반환하는 메서드
    public void searchQuery( String query ){

        Cursor c = mDatabase.rawQuery( query, null );
        String[] col = c.getColumnNames();//컬럼명을 가져온다.(name, phone, age)

        String[] str = new String[ c.getColumnCount() ];
        String result = "";

        while( c.moveToNext() ){

            for( int i = 0; i < c.getColumnCount(); i++ ){

                str[i] = "";
                str[i] += c.getString(i);//각 컬럼별 데이터

                //result = 컬럼명 : 값( name : 홍길동 )
                result += col[i] + " : " + str[i] + "\n";
            }

            result += "\n";

        }//while

        result_txt.setText( result );

    }//searchQuery()

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.close();
    }

    //assets폴더의 데이터베이스 파일을 휴대폰 내부저장소에 복사
    private void copyAssets(){

        AssetManager assetManager = getAssets();
        String[] files = null;
        String mkdir = "";

        try {
            files = assetManager.list("");

        } catch (IOException e) {
            e.printStackTrace();
        }

        for( int i = 0; i < files.length; i++ ){

            InputStream in = null;
            OutputStream out = null;

            try{

                in = assetManager.open( files[i] );
                //내부저장소에 폴더생성
                mkdir = Environment.getExternalStorageDirectory() + "/database";
                File mpath = new File( mkdir );

                if( !mpath.exists() ){
                    //File클래스의 생성 경로가 물리적으로 존재하지 않는다면....
                    isFirst = true;
                }

                if( isFirst ){

                    mpath.mkdirs();//폴더 생성

                    out = new FileOutputStream( mkdir + "/" + files[i] );

                    byte[] buffer = new byte[2048];
                    in.read( buffer );

                    in.close();
                    out.flush();
                    out.close();

                    isFirst = false;
                }

            }catch (Exception e){

            }

        }

    }//copyAssets()

    //앱 권한 설정 감지자
    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            //모든 권한의 수락이 완료 되었을 때
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            //한가지라도 수락되지 않은 권한이 있을경우
            finish();
        }
    };

    private void setPermission(){

        TedPermission.with( this )
                .setPermissionListener( permissionListener )
                .setDeniedMessage("수락되지 않은 권한이 있습니다\n\n[설정] -> [권한]에서 권한을 활성화 해주세요")
                .setPermissions( Manifest.permission.READ_EXTERNAL_STORAGE,
                                 Manifest.permission.WRITE_EXTERNAL_STORAGE ).check();

    }//setPermission()

}
























































