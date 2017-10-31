package com.doan.learnjapanese.TuKanji;

import android.content.Intent;
import android.database.Cursor;

import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import android.widget.AdapterView;

import android.widget.ListView;


import com.doan.learnjapanese.DatabaseHelper;
import com.doan.learnjapanese.R;

import java.util.ArrayList;

public class MainKanji extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kanji);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("512 Từ Kanji");
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.containerkj);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabskj);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_kanji, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private ListView lv;
        private TuKanjiAdapter adapter;
        private DatabaseHelper databaseHelper;
        private ArrayList<ThuocTinhTuKanji> arrayList;
        private ThuocTinhTuKanji tuKanji;

        private Intent intent;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_kanji, container, false);
            databaseHelper = new DatabaseHelper(getActivity());
            arrayList = new ArrayList<>();
            databaseHelper.copyDB();
            lv = (ListView) rootView.findViewById(R.id.lvkj);
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                hienThi(1);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                hienThi(2);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                hienThi(3);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                hienThi(4);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
                hienThi(5);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 6) {
                hienThi(6);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 7) {
                hienThi(7);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 8) {
                hienThi(8);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 9) {
                hienThi(9);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 10) {
                hienThi(10);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 11) {
                hienThi(11);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 12) {
                hienThi(12);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 13) {
                hienThi(13);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 14) {
                hienThi(14);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 15) {
                hienThi(15);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 16) {
                hienThi(16);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 17) {
                hienThi(17);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 18) {
                hienThi(18);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 19) {
                hienThi(19);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 20) {
                hienThi(20);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 20) {
                hienThi(20);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 21) {
                hienThi(21);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 22) {
                hienThi(22);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 23) {
                hienThi(23);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 24) {
                hienThi(24);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 25) {
                hienThi(25);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 26) {
                hienThi(26);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 27) {
                hienThi(27);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 28) {
                hienThi(28);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 29) {
                hienThi(29);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 30) {
                hienThi(30);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 31) {
                hienThi(31);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 32) {
                hienThi(32);
            }
            return rootView;
        }

        private void hienThi(int loai) {
            String query = "SELECT* FROM btlKanji2 WHERE Loai=" + loai + "";
            Cursor cursor = databaseHelper.getCursor(query);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    tuKanji = new ThuocTinhTuKanji(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getInt(9), cursor.getString(10),cursor.getInt(11));
                    arrayList.add(tuKanji);
                } while (cursor.moveToNext());
            }
            cursor.close();
            adapter = new TuKanjiAdapter(getActivity(), R.layout.item_tukanji, arrayList);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id1) {
                    int id = arrayList.get(position).getID();
                    String tuKanji = arrayList.get(position).getTuKanji();
                    String amHan = arrayList.get(position).getAmHan();
                    String ony = arrayList.get(position).getOnoymi();
                    String kuny = arrayList.get(position).getKunyomi();
                    String nghia = arrayList.get(position).getNghia();
                    String viduViet = arrayList.get(position).getViDuViet();
                    String viduNhat = arrayList.get(position).getViDuNhat();
                    String vidu2 = arrayList.get(position).getViDu2();

                    intent = new Intent(getActivity(), ChiTietTuKanji.class);
                    intent.putExtra("idct", id);
                    intent.putExtra("tukanji", tuKanji);
                    intent.putExtra("amhan", amHan);
                    intent.putExtra("ony", ony);
                    intent.putExtra("kuny", kuny);
                    intent.putExtra("nghia", nghia);
                    intent.putExtra("vidu2", vidu2);
                    intent.putExtra("vidunhatct", viduNhat);
                    intent.putExtra("viduvietct", viduViet);
                    startActivity(intent);
                }
            });
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 32;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "牌1";
                case 1:
                    return "牌2";
                case 2:
                    return "牌3";
                case 3:
                    return "牌4";
                case 4:
                    return "牌5";
                case 5:
                    return "牌6";
                case 6:
                    return "牌7";
                case 7:
                    return "牌8";
                case 8:
                    return "牌9";
                case 9:
                    return "牌10";
                case 10:
                    return "牌11";
                case 11:
                    return "牌12";
                case 12:
                    return "牌13";
                case 13:
                    return "牌14";
                case 14:
                    return "牌15";
                case 15:
                    return "牌16";
                case 16:
                    return "牌17";
                case 17:
                    return "牌18";
                case 18:
                    return "牌19";
                case 19:
                    return "牌20";
                case 20:
                    return "牌21";
                case 21:
                    return "牌22";
                case 22:
                    return "牌23";
                case 23:
                    return "牌24";
                case 24:
                    return "牌25";
                case 25:
                    return "牌26";
                case 26:
                    return "牌27";
                case 27:
                    return "牌28";
                case 28:
                    return "牌29";
                case 29:
                    return "牌30";
                case 30:
                    return "牌31";
                case 31:
                    return "牌32";
            }
            return null;
        }
    }
}
