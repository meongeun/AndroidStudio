package jyh.test.android.ex_0619_m;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    Button[] menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        //뷰페이저에 어댑터를 연결
        pager.setAdapter( new MyPagerAdapter( getSupportFragmentManager() ) );

        //시작페이지 설정
        pager.setCurrentItem( 0 );

        /*//밑줄을 그려주는 indecator를 설정
        UnderlinePageIndicator indicator = findViewById( R.id.indicator );
        //true면 underline이 fade out된다.
        indicator.setFades( false );
        indicator.setViewPager( pager );*/

        /*TitlePageIndicator titlePageIndicator = findViewById(R.id.titles);
        titlePageIndicator.setViewPager( pager );*/

        CirclePageIndicator circlePageIndicator = findViewById(R.id.circles);
        circlePageIndicator.setViewPager( pager );

        menus = new Button[PageInfo.PAGES];
        for( int i = 0; i < menus.length; i++ ){

            try {

                menus[i] = findViewById(
                        new R.id().getClass().getField("menu" + (i + 1)).getInt(null) );

                menus[i].setTag(i);//각 버튼에 태그 추가
                menus[i].setOnClickListener( click );

            }catch (Exception e){

            }

        }//for

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //클릭된 버튼의 태그를 감지해서 해당 페이지로 전환
            pager.setCurrentItem( (int)v.getTag() );

        }
    };

}








































































