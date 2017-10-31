package com.doan.learnjapanese.BaiMinna;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.doan.learnjapanese.R;

public class TabMinna extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    // khai báo MyPagerAdapter
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_minna);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("50 bài Minna");
        // tham chiếu control tới các control trong layout PagerSlidingTabStrip
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabsmn);
        pager = (ViewPager) findViewById(R.id.pagermn);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        // màu cho tab
        tabs.setTextColor(Color.WHITE);
        // thiết lập adapter cho ViewPager khung nhìn của từng item
        pager.setAdapter(adapter);
        // giá trị margin cho page
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        // thiết lập margin cho pager
        pager.setPageMargin(pageMargin);
// thiết lập các tab cho PagerSlidingTabStrip
        tabs.setViewPager(pager);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    // lớp MyPagerAdapter để đổ dữ liệu vào PagerSlidingTabStrip
    public class MyPagerAdapter extends FragmentPagerAdapter {
        // mảng tab
        private final String[] TITLES = { "牌1", "牌2", "牌3", "牌4", "牌5", "牌6",
                "牌7", "牌8","牌9", "牌10", "牌11", "牌12", "牌13", "牌14",
                "牌15", "牌16","牌17", "牌18", "牌19", "牌20", "牌21", "牌22",
                "牌23", "牌24","牌25", "牌26", "牌27", "牌28", "牌29", "牌30",
                "牌31", "牌32","牌33", "牌34", "牌35", "牌36", "牌37", "牌38",
                "牌39", "牌40","牌41", "牌42", "牌43", "牌44", "牌45", "牌46",
                "牌47", "牌48" ,"牌49", "牌50"};

        // phương thức khởi tab với tham số là  FragmentManager
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        // lấy ra tiêu đề page
        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
        // số lượng tab
        @Override
        public int getCount() {
            return TITLES.length;
        }
        // lấy ra vị trí  tab
        @Override
        public Fragment getItem(int position) {
            return Tab.newInstance(position);
        }

    }
}
