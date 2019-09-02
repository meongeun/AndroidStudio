package jyh.test.android.ex_0521;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ex_DialogActivity extends AppCompatActivity {

    ImageView img;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex__dialog);

        img = findViewById(R.id.img);

    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){

            case R.id.menu:
                //메뉴 선택시 다이얼로그 생성
                dialog = new Dialog(Ex_DialogActivity.this);
                dialog.setContentView( R.layout.dialog );

                Button btn_inv = dialog.findViewById(R.id.btn_inv);

                if( img.getVisibility() == View.VISIBLE ){
                    btn_inv.setText( "INVISIBLE" );
                }else{
                    btn_inv.setText( "VISIBLE" );
                }

                btn_inv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if( img.getVisibility() == View.VISIBLE ){
                            img.setVisibility( View.INVISIBLE );

                        }else{
                            img.setVisibility( View.VISIBLE );

                        }

                        dialog.dismiss();

                    }
                });
                break;

        }//switch

        dialog.show();

        return super.onOptionsItemSelected(item);
    }
}





















































