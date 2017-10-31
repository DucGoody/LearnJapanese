package com.doan.learnjapanese.BangChuCai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;


public class BangChuCaiAdapter extends ArrayAdapter<ThuocTinhBangChuCai> {
    // lớp để custom  GridView
    // khai báo lớp Context: để truyền context Vd: Mainactivity.this
    private Context context;
    // khai báo list ThuocTinhBangChuCai
    ArrayList<ThuocTinhBangChuCai> listsong = new ArrayList<ThuocTinhBangChuCai>();
    // giá trị của layout custom
    int resource;
    // phương thức khởi tạo 3 tham số
    public BangChuCaiAdapter(Context context, int resource, List<ThuocTinhBangChuCai> listsong) {
        super(context, resource, listsong);
        this.context = context;
        this.resource = resource;
        this.listsong = (ArrayList<ThuocTinhBangChuCai>) listsong;

    }
// lấy ra kích thước list
    @Override
    public int getCount() {
        return listsong.size();
    }

    // đổ dữ liệu vào khung nhìn của từng item listView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // gán v= convertView trong phương thức
        View v = convertView;
        // khai báo lớp ViewHolder
        ViewHolder viewHolder;

        if (v == null) {
            // khai báo LayoutInflater
            LayoutInflater inflater;
            // khởi tạo LayoutInflater
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // gán view = khung nhìn của layout item_bangchucai
            v = inflater.inflate(R.layout.item_bangchucai, null);
            // khởi tạo lớp ViewHolder
            viewHolder = new ViewHolder();
            // tham chiếu các control tới các control trong layout item_bangchucai
            viewHolder.txtvTuNhat = (TextView) v.findViewById(R.id.txtvBccTuNhat);
            viewHolder.txtvTuViet = (TextView) v.findViewById(R.id.txtvBccTuViet);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // lấy ra đối tượng ThuocTinhBangChuCai tại vị trí position
        ThuocTinhBangChuCai ttbcc = listsong.get(position);
        // đổ dữ liệu vào control tương ứng
        viewHolder.txtvTuNhat.setText(ttbcc.getTuNhat());
        viewHolder.txtvTuViet.setText(ttbcc.getTuViet());
        return v;
    }
    // lớp khai báo các control trong itemListView
    static class ViewHolder {
        TextView txtvTuNhat;
        TextView txtvTuViet;

    }
}
