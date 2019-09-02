package com.example.moviefinder;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.drm.DrmStore;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainPagerActivity extends FragmentActivity {

    int MAX_PAGE=3;
    Fragment cur_fragment = new Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pager);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));


    }



    private class adapter extends FragmentPagerAdapter{
        private ImageView imageView_img;
        private TextView textView_title, textView_reserve, textView_age;


        public adapter(FragmentManager fm){

            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i<0||MAX_PAGE<=i)
            return null;
            switch (i){
                case 0:
                    cur_fragment=new Pager1();
                    break;
                case 1:
                    cur_fragment=new Pager2();
                    break;
                case 2:
                    cur_fragment=new Pager3();
                    break;
            }

            return cur_fragment;
        }

        public int getCount(){
            return MAX_PAGE;
        }
    }
}
