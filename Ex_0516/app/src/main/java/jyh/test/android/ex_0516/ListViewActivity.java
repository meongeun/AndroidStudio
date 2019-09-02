package jyh.test.android.ex_0516;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    Button addBtn;
    ListView myList;
    ArrayList<String> arr;
    MyAdapter adapter;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        arr = new ArrayList<>();
        addBtn = findViewById(R.id.addBtn);
        myList = findViewById(R.id.myList);

        //어댑터를 생성하고 리스트뷰에 탑재
        adapter = new MyAdapter( ListViewActivity.this,
                                 R.layout.list_form, arr );
        myList.setAdapter( adapter );

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ++count;
                arr.add( "item " + count );

                if( myList != null ){
                    adapter.notifyDataSetChanged();
                }

            }
        });

    }//onCreate()
}
































