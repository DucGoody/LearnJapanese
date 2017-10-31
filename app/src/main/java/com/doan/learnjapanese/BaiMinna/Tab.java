package com.doan.learnjapanese.BaiMinna;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.doan.learnjapanese.R;


public class Tab extends Fragment {
    //khai báo biến
    // ARG_POSITION từ khóa để lấy vị trí tab
    private static final String ARG_POSITION = "position";
    // giá trị của tab
    private int position;

    // phương thức put giá trị của tab
    public static Tab newInstance(int position) {
        // khởi tạo tab
        Tab f = new Tab();
        // dùng Bundle để lấy put giá trị vị trí của tab
        Bundle b = new Bundle();
        // put ví trí tab với key: ARG_POSITION
        b.putInt(ARG_POSITION, position);
        // thiết lập giá trị cho fragment vị trí tab
        f.setArguments(b);
        return f;
    }
    // phương thức khởi tạo
    public Tab() {

    }
    // phương thức onCreate lấy ra giá trị của tab
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // gán view bằng layout fragment_tab
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        // khai báo và tham chiếu các CardView tới trong layout fragment_tab
        CardView c1, c2, c3, c4, c5;
        c1 = (CardView) rootView.findViewById(R.id.c1mn2);
        c2 = (CardView) rootView.findViewById(R.id.c2mn2);
        c3 = (CardView) rootView.findViewById(R.id.c3mn2);
        c4 = (CardView) rootView.findViewById(R.id.c4mn2);
        c5 = (CardView) rootView.findViewById(R.id.c5mn2);
//            s=getArguments().getInt(ARG_SECTION_NUMBER);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khi chọn chọn CardView sẽ chuyển tới HienThiHoiThoai activity
                Intent intent = new Intent(getActivity(), HienThiHoiThoai.class);
                // put position+2 tới HienThiHoiThoai với key tabsht
                intent.putExtra("tabsht", position + 2);
                // thực thi việc chuyển đổi activity
                startActivity(intent);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiTuVung.class);
                intent.putExtra("tabstv", position + 2);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiNguPhap.class);
                intent.putExtra("tabsnp", position);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiHoiThoaiMau.class);
                intent.putExtra("tabshtm", position);
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HienThiTuVungThem.class);
                intent.putExtra("tabstvt", position);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
