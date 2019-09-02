package jyh.test.android.ex_0619_m;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    final String[] CONTENT = { "다섯", "개의", "페이지가", "존재", "합니다" };

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return CONTENT[position];
    }

    @Override
    public Fragment getItem(int position) {
        return new Page().create( position );
    }

    @Override
    public int getCount() {
        return PageInfo.PAGES;
    }

}
