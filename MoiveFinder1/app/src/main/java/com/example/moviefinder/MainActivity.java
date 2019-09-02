package com.example.moviefinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{
    Button btnLook;
    private ArrayList<String> mData = new ArrayList<>();
    int CHECK_NUML =0;
    int CHECK_NUMH =0;
    int counterl=0;
    int counterh=0;
    TextView liken; TextView haten;
    private  int mWidthPixel =0;
    private  int mHeightPixel =0;

    ListView mList1;
    ListViewAdapter adapter1;

    private Button btnWrite;
    private PopupWindow popupWindow;
    private EditText writeText;
    private Button btnSave;
    private Button btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button thumb_up = (Button)findViewById(R.id.thumb_up);
        final Button thumb_down = (Button)findViewById(R.id.thumb_down);
        liken=(TextView)findViewById(R.id.liken);
        haten = (TextView)findViewById(R.id.haten);

        thumb_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CHECK_NUML==0){
                    thumb_up.setSelected(true);
                    if(CHECK_NUMH==1&&counterh>0){
                        liken.setText(String.valueOf(++counterl));
                        haten.setText(String.valueOf(--counterh));
                        thumb_down.setSelected(false);
                    }else if (CHECK_NUMH==1&&counterh<0) {
                        liken.setText(String.valueOf(++counterl));
                        haten.setText(String.valueOf(0));
                        thumb_down.setSelected(false);
                    }else{
                        liken.setText(String.valueOf(++counterl));
                    }


                    CHECK_NUML=1;
                }
                else {
                    thumb_up.setSelected(false);
                    liken.setText(String.valueOf(--counterl));
                    CHECK_NUML=0;
                }
            }
        });

        thumb_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CHECK_NUMH==0){
                    thumb_down.setSelected(true);
                    if(CHECK_NUML==1){
                        haten.setText(String.valueOf(++counterh));
                        liken.setText(String.valueOf(--counterl));
                        thumb_up.setSelected(false);
                    }
                    else if(CHECK_NUML==1&& counterl>0){
                        haten.setText(String.valueOf(++counterh));
                        liken.setText(String.valueOf(0));
                        thumb_up.setSelected(false);

                    }else{
                        haten.setText(String.valueOf(++counterh));
                    }

                    CHECK_NUMH=1;
                }
                else {
                    thumb_down.setSelected(false);
                    haten.setText(String.valueOf(--counterh));
                    CHECK_NUMH=0;
                }
            }
        });




        btnLook = (Button) findViewById(R.id.btnLook);
        btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LookActivity.class);
                startActivity(intent);


            }
        });
        final ArrayList<String> mData = new ArrayList<>();

        mData.add("작성된 게 없습니다.");
        mData.add("Seoul");
        mData.add("Busan");
        mData.add("Daegu");
        mData.add("Jeju");



        mList1 = (ListView)findViewById(R.id.list1);
        adapter1 = new ListViewAdapter();
        mList1.setAdapter(adapter1);

        adapter1.addItem(ContextCompat.getDrawable(this,R.drawable.user1), "Box","Account Box Black 36dp");

        adapter1.addItem(ContextCompat.getDrawable(this, R.drawable.user1),"Circle","Account Circle Black 36dp");

        adapter1.addItem(ContextCompat.getDrawable(this, R.drawable.user1),"Ind","Assignment Ind Black 36dp");

        mList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListViewItem item =(ListViewItem)parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String  descStr = item.getDescStr();
                Drawable iconDrawable = item.getIcon();
            }
        });

        Button btnWrite =(Button)findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });


    }//onCreate();


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        int id = item.getItemId();

        if(id==R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if(id== R.id.mlist){
            Intent intent = new Intent(getApplicationContext(), MainPagerActivity.class);
            startActivity(intent);

        }else if(id==R.id.mreview){

        }else if(id==R.id.mbook){

        }
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        }else {
            super.onBackPressed();
        }

    }
}
