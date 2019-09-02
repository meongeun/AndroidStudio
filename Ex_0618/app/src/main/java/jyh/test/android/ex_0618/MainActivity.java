package jyh.test.android.ex_0618;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    ViewPager pager;
    Button btn_page1, btn_page2, btn_page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_page1 = findViewById(R.id.btn_page1);
        btn_page2 = findViewById(R.id.btn_page2);
        btn_page3 = findViewById(R.id.btn_page3);

        pager = findViewById(R.id.pager);
        //viewPager에 어댑터 세팅
        pager.setAdapter( new MyPagerAdapter(getSupportFragmentManager()) );

        //시작페이지 지정
        pager.setCurrentItem( PageInfo.FRAGMENT_PAGE1 );
        btn_page1.setSelected( true );

        //상단 버튼에 이벤트 감지자 등록
        btn_page1.setOnClickListener( click );
        btn_page2.setOnClickListener( click );
        btn_page3.setOnClickListener( click );

        //뷰 페이저의 페이지 변경 감지자
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //상단의 버튼의 선택상태를 false로 지정
                btn_page1.setSelected( false );
                btn_page2.setSelected( false );
                btn_page3.setSelected( false );

                switch ( position ){

                    case PageInfo.FRAGMENT_PAGE1:
                        btn_page1.setSelected( true );
                        break;

                    case PageInfo.FRAGMENT_PAGE2:
                        btn_page2.setSelected( true );
                        break;

                    case PageInfo.FRAGMENT_PAGE3:
                        btn_page3.setSelected( true );
                        break;

                }//switch
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ){

                case R.id.btn_page1:
                    pager.setCurrentItem( PageInfo.FRAGMENT_PAGE1 );
                    break;

                case R.id.btn_page2:
                    pager.setCurrentItem( PageInfo.FRAGMENT_PAGE2 );
                    break;

                case R.id.btn_page3:
                    pager.setCurrentItem( PageInfo.FRAGMENT_PAGE3 );
                    break;

            }//switch

        }
    };

}











































