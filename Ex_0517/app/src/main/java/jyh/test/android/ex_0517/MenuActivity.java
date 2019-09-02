package jyh.test.android.ex_0517;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openOptionsMenu();

            }
        });

    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.my_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){

            case R.id.menu1:
                Toast.makeText( MenuActivity.this,
                                 "email click", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu2:
                Toast.makeText( MenuActivity.this,
                        "phone click", Toast.LENGTH_SHORT ).show();
                break;

            case R.id.menu3:
                finish(); //액티비티 종료
                break;

        }//switch
        return super.onOptionsItemSelected(item);
    }
}














































