package com.doan.learnjapanese.BangChuCai;

import android.app.Dialog;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.speech.tts.TextToSpeech;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.doan.learnjapanese.BaiMinna.HienThiTuVung;
import com.doan.learnjapanese.DatabaseHelper;
import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.Locale;

public class MainBangChuCai extends AppCompatActivity {
    // khai báo lớp SectionsPagerAdapter
    private SectionsPagerAdapter mSectionsPagerAdapter;
    // khai báo viewPager
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bang_chu_cai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Bảng chữ cái");

        // khởi tạo SectionsPagerAdapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // tham chiếu ViewPager tới ViewPager tại layout activity_main_bang_chu_cai
        mViewPager = (ViewPager) findViewById(R.id.containerbcc);
        // thiết lập các giá trị cho tab
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // khai báo TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsbcc);
        // thiết lập khung nhìn cho TabLayout
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    // khai báo lớp PlaceholderFragment kế thừa từ fragment
    public static class PlaceholderFragment extends Fragment {
        // khai báo các các lớp, cntrol và biến
        // lớp TextToSpeech
        private TextToSpeech toSpeech;
        // lớp DatabaseHelper
        private DatabaseHelper databaseHelper;
        // khai báo list ThuocTinhBangChuCai
        private ArrayList<ThuocTinhBangChuCai> arrayList;
        // control GridView
        private GridView gv;
        // lớp đối tượng ThuocTinhBangChuCai
        private ThuocTinhBangChuCai ttbcc;
        // lớp BangChuCaiAdapter
        private BangChuCaiAdapter adapter;
        // hiệu ứng animation
        private Animation animation1;
        // các biến để lưu trữ dữ liệu
        private String chucai, vidu, colum, nghia;
        // key để lấy ra vị trí tab
        private static final String ARG_SECTION_NUMBER = "section_number";
        // phương thức khởi tạo không tham số
        public PlaceholderFragment() {
        }
        // phương thức 1 tham số và ví trí tab
        public static PlaceholderFragment newInstance(int sectionNumber) {
            // khởi tạo
            PlaceholderFragment fragment = new PlaceholderFragment();
            // khởi tạo Bundle
            Bundle args = new Bundle();
            // put vị trí tab với key là :ARG_SECTION_NUMBER
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            // thiết lập fragment với args
            fragment.setArguments(args);
            return fragment;
        }
        // phương thức thực thi của fragment
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_bang_chu_cai, container, false);
            // khởi tạo ArrayList và lớp DatabaseHelper
            arrayList = new ArrayList<>();
            databaseHelper = new DatabaseHelper(getActivity());
            // tham chiếu control tới control trong layout fragment_main_bang_chu_cai
            gv = (GridView) rootView.findViewById(R.id.gvBCC);
            // khởi tạo animation
            animation1 = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);
            // so sánh ví trí tab
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                // bằng =1 thì hiển thị bảng chữ cái loại seion
                hienThi("seion");
                // thiết lập số cột trong gridView là 5
                gv.setNumColumns(5);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                hienThi("dakuon");
                gv.setNumColumns(5);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                hienThi("youon");
                gv.setNumColumns(5);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                hienThi("tokuni");
                gv.setNumColumns(5);
            }
            else if (getArguments().getInt(ARG_SECTION_NUMBER) == 5) {
                hienThi2("seion");
                gv.setNumColumns(5);
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) ==6) {
                hienThi2("dakuon");
                gv.setNumColumns(5);
            }
            else if (getArguments().getInt(ARG_SECTION_NUMBER) ==7) {
                hienThi2("youon");
                gv.setNumColumns(5);
            }
            // thực thi lớp nghe
            nghe();
            return rootView;
        }
        // khởi tạo và thiết lập ngôn ngữ phát âm cho TextToSpeech
        private void nghe() {
            toSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        toSpeech.setLanguage(Locale.getDefault());
                        toSpeech.setLanguage(Locale.JAPANESE);
                    }
                }
            });
        }
        // phương thức hiển thị
        private void hienThi(String t) {
            // gọi lớp copyDB
            databaseHelper.copyDB();
            // dùng con trỏ để lấy dữ liệu từ bảng tblBCC
            Cursor cursor = databaseHelper.getCursor("SELECT * FROM tblBCC WHERE Loai = '" + t + "'");
            // gán con trỏ tại ví trí đầu tiên
            cursor.moveToFirst();
            // duyệt cho tới khi con trỏ ở vị trí cuối cùng
            while (!cursor.isAfterLast()) {
                // khởi tạo đối tượng với các tham số tương ứng với cột trong csdl
                ttbcc = new ThuocTinhBangChuCai(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),cursor.getInt(7),cursor.getString(8));
                // thêm vào arraylisst
                arrayList.add(ttbcc);
                // next ví trí con trỏ
                cursor.moveToNext();
            }
            // đóng con trỏ
            cursor.close();
            // khởi tạo adapter
            adapter = new BangChuCaiAdapter(getActivity(), R.layout.item_bangchucai, arrayList);
            // thiết lập adapter cho gv
            gv.setAdapter(adapter);
            // sự kiện chọn từ
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // lấy ra các thuộc tính tại ví trị item chọn
                    chucai = arrayList.get(position).getTuNhat();
                    vidu = arrayList.get(position).getChuThich();
                    colum = arrayList.get(position).getColum();
                    nghia = arrayList.get(position).getNghia();
                    // khởi tạo dialog
                    final Dialog dialog = new Dialog(getActivity());
                    // thiết lập khung nhìn cho dialog bằng layout dialog_bcc
                    dialog.setContentView(R.layout.dialog_bcc);
                    // thiết lập tiêu đề cho dialog
                    dialog.setTitle("Chi tiết từ");

                    // tham chiếu các control tới control trong layout dialog_bcc
                    TextView text = (TextView) dialog.findViewById(R.id.txtvChiTietTuMain);
                    // thiết lập text cho TextView
                    text.setText(chucai);
                    TextView text1 = (TextView) dialog.findViewById(R.id.txtvViDuNhatBCCMain);
                    text1.setText(vidu);
                    TextView text2 = (TextView) dialog.findViewById(R.id.txtvViDuColumBCCMain);
                    text2.setText(colum);
                    TextView text3 = (TextView) dialog.findViewById(R.id.txtvViDuNghiaBCCMain);
                    text3.setText(nghia);
                    text.startAnimation(animation1);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imgLoaBCCMain);
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // cho phép nghe khi chọn loa
                            String txt = chucai;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                            }
                        }
                    });

                    ImageView dialogButton = (ImageView) dialog.findViewById(R.id.okiBCCMain2);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // sự kiến tắt dialog
                            dialog.dismiss();
                        }
                    });
                    // hiển thị dialog
                    dialog.show();
                }
            });
        }
        // phương thức hiển thị cho kata
        private void hienThi2(String t) {
            // gọi lớp copyDB
            databaseHelper.copyDB();
            // dùng con trỏ để lấy dữ liệu từ bảng tblBCC
            Cursor cursor = databaseHelper.getCursor("SELECT * FROM tblBCC WHERE Loai = '" + t + "'");
            // gán con trỏ tại ví trí đầu tiên
            cursor.moveToFirst();
            // duyệt cho tới khi con trỏ ở vị trí cuối cùng
            while (!cursor.isAfterLast()) {
                // khởi tạo đối tượng với các tham số tương ứng với cột trong csdl
                ttbcc = new ThuocTinhBangChuCai(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),cursor.getInt(7),cursor.getString(8));
                // thêm vào arraylisst
                arrayList.add(ttbcc);
                // next ví trí con trỏ
                cursor.moveToNext();
            }
            // đóng con trỏ
            cursor.close();
            // khởi tạo adapter
            BangChuCaiAdapterKata adapter22= new BangChuCaiAdapterKata(getActivity(), R.layout.item_bangchucai, arrayList);
            // thiết lập adapter cho gv
            gv.setAdapter(adapter22);
            // sự kiện chọn từ
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // lấy ra các thuộc tính tại ví trị item chọn
                     final String chucai2 = arrayList.get(position).getKata();
                    vidu = arrayList.get(position).getChuThich();
                    colum = arrayList.get(position).getColum();
                    nghia = arrayList.get(position).getNghia();
                    // khởi tạo dialog
                    final Dialog dialog = new Dialog(getActivity());
                    // thiết lập khung nhìn cho dialog bằng layout dialog_bcc
                    dialog.setContentView(R.layout.dialog_bcc);
                    // thiết lập tiêu đề cho dialog
                    dialog.setTitle("Chi tiết từ");

                    // tham chiếu các control tới control trong layout dialog_bcc
                    TextView text = (TextView) dialog.findViewById(R.id.txtvChiTietTuMain);
                    // thiết lập text cho TextView
                    text.setText(chucai2);
                    TextView text1 = (TextView) dialog.findViewById(R.id.txtvViDuNhatBCCMain);
                    text1.setText(vidu);
                    TextView text2 = (TextView) dialog.findViewById(R.id.txtvViDuColumBCCMain);
                    text2.setText(colum);
                    TextView text3 = (TextView) dialog.findViewById(R.id.txtvViDuNghiaBCCMain);
                    text3.setText(nghia);
                    text.startAnimation(animation1);
                    ImageView image = (ImageView) dialog.findViewById(R.id.imgLoaBCCMain);
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // cho phép nghe khi chọn loa
                            String txt = chucai2;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                            }
                        }
                    });

                    ImageView dialogButton = (ImageView) dialog.findViewById(R.id.okiBCCMain2);
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // sự kiến tắt dialog
                            dialog.dismiss();
                        }
                    });
                    // hiển thị dialog
                    dialog.show();
                }
            });
        }

    }


    // lớp SectionsPagerAdapter kế thừa FragmentPagerAdapter để thực thi các thao tác với tab bao gồm lấy ra tab, tiêu đề cho tab
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        // phương thức khởi tạo  1 tham số
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        // lấy ra vị trí fragment
        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }
        // số lượng tab
        @Override
        public int getCount() {
            return 7;
        }

        // tiêu đề các tab
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SEION";
                case 1:
                    return "DAKUON";
                case 2:
                    return "YOUON";
                case 3:
                    return "TOKUNI";
                case 4:
                    return "SEION(KATA)";
                case 5:
                    return "DAKUON(KATA)";
                case 6:
                    return "YOUON(KATA)";
            }
            return null;
        }
    }
}
