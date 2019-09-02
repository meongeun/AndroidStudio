package jyh.test.android.ex_0618;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch ( position ){

            case PageInfo.FRAGMENT_PAGE1://0
                return new PageFragment1();

            case PageInfo.FRAGMENT_PAGE2://1
                return new PageFragment2();

            case PageInfo.FRAGMENT_PAGE3://2
                return new PageFragment3();
        }//switch

        return null;
    }

    @Override
    public int getCount() {
        //생성가능한 전체 페이지 수
        return PageInfo.PAGES;
    }
}














