package com.doan.learnjapanese.MauCauGiaoTiep;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.doan.learnjapanese.DatabaseHelper;
import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainGiaoTiep extends AppCompatActivity {
    private static Context context;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private static TextToSpeech toSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_giao_tiep);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Mẫu câu giao tiếp");
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        nghe();
    }

    private void nghe() {
        toSpeech = new TextToSpeech(MainGiaoTiep.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    toSpeech.setLanguage(Locale.getDefault());
                    toSpeech.setLanguage(Locale.JAPANESE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_giao_tiep, menu);
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
        private DatabaseHelper databaseHelper;
        private ArrayList<ThuocTinhCauGiaoTiep> arrayList;
        private GiaoTiepAdapter adapter;
        private ThuocTinhCauGiaoTiep thuocTinhCauGiaoTiep;
        private ListView lv;

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
            View rootView = inflater.inflate(R.layout.fragment_main_giao_tiep, container, false);
            databaseHelper = new DatabaseHelper(getActivity());
            arrayList = new ArrayList<>();
            lv = (ListView) rootView.findViewById(R.id.lvgiaotiep2);
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                hienThi("chaohoi");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                hienThi("ngaythang");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                hienThi("sodem");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                hienThi("hoithoai");
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
                hienThi("phuonghuong");
            }
            return rootView;
        }

        private void hienThi(String s) {
            databaseHelper.copyDB();
            Cursor cursor = databaseHelper.getCursor("SELECT * FROM tblMauCauGiaoTiep WHERE Loai = '" + s + "'");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                thuocTinhCauGiaoTiep = new ThuocTinhCauGiaoTiep(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4));
                arrayList.add(thuocTinhCauGiaoTiep);
                cursor.moveToNext();
            }
            cursor.close();
            adapter = new GiaoTiepAdapter(getActivity(), R.layout.item_giaotiep, arrayList);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return " Chào hỏi ";
                case 1:
                    return " Hội thoại ";
                case 2:
                    return "  Số đếm  ";
                case 3:
                    return "Ngày tháng";
                case 4:
                    return "Phương hướng";
            }
            return null;
        }
    }

    static class GiaoTiepAdapter extends ArrayAdapter<ThuocTinhCauGiaoTiep> {
        private Context context;
        ArrayList<ThuocTinhCauGiaoTiep> listsong = new ArrayList<ThuocTinhCauGiaoTiep>();
        int resource;

        public GiaoTiepAdapter(Context context, int resource, List<ThuocTinhCauGiaoTiep> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhCauGiaoTiep>) listsong;
        }

        @Override
        public int getCount() {
            return listsong.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            final GiaoTiepAdapter.ViewHolder viewHolder;
            if (v == null) {
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_giaotiep, null);
                viewHolder = new GiaoTiepAdapter.ViewHolder();
                viewHolder.txtvcauNhat = (TextView) v.findViewById(R.id.txtvCauNhatgt);
                viewHolder.txtvcauViet = (TextView) v.findViewById(R.id.txtvCauVietgt);
                viewHolder.img = (ImageView) v.findViewById(R.id.imgLoagiaotiep);
                v.setTag(viewHolder);
            } else {
                viewHolder = (GiaoTiepAdapter.ViewHolder) convertView.getTag();
            }
            ThuocTinhCauGiaoTiep ttbcc = listsong.get(position);
            viewHolder.txtvcauNhat.setText(ttbcc.getCauNhat());
            viewHolder.txtvcauViet.setText(ttbcc.getCauViet());
            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String txt = viewHolder.txtvcauNhat.getText().toString().trim();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
            return v;
        }

        class ViewHolder {
            ImageView img;
            TextView txtvcauViet;
            TextView txtvcauNhat;
        }
    }
}
