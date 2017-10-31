package com.doan.learnjapanese.BoThu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.doan.learnjapanese.R;

public class MainBoThu extends AppCompatActivity {
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_bo_thu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("214 bộ thủ");
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabsbt);
        pager = (ViewPager) findViewById(R.id.pagerbt);
        adapter = new MyPagerAdapter3(getSupportFragmentManager());
        tabs.setTextColor(Color.WHITE);
        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    public class MyPagerAdapter3 extends FragmentPagerAdapter {

        private final String[] TITLES = { "牌1", "牌2", "牌3", "牌4", "牌5", "牌6",
                "牌7", "牌8","牌9", "牌10", "牌11", "牌12", "牌13", "牌14"};

        public MyPagerAdapter3(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return TabBoThu.newInstance(position);
        }

    }
}
