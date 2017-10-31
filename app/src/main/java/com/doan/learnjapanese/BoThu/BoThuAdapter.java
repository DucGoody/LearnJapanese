package com.doan.learnjapanese.BoThu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;


public class BoThuAdapter extends ArrayAdapter<ThuocTinhBoThu> {
    private Context context;
    ArrayList<ThuocTinhBoThu> listsong = new ArrayList<ThuocTinhBoThu>();
    int resource;

    public BoThuAdapter(Context context, int resource, List<ThuocTinhBoThu> listsong) {
        super(context, resource, listsong);
        this.context = context;
        this.resource = resource;
        this.listsong = (ArrayList<ThuocTinhBoThu>) listsong;
    }

    @Override
    public int getCount() {
        return listsong.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        BoThuAdapter.ViewHolder viewHolder;
        if (v == null) {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_bothu, null);
            viewHolder = new BoThuAdapter.ViewHolder();
            viewHolder.txtvid = (TextView) v.findViewById(R.id.txtvIDbt);
            viewHolder.txtvNhat = (TextView) v.findViewById(R.id.txtvTuNhatbt);
            viewHolder.txtvNghia = (TextView) v.findViewById(R.id.txtvNghiabt);
            viewHolder.txtvNghiaViet = (TextView) v.findViewById(R.id.txtvNghiaVietbt);

            v.setTag(viewHolder);
        } else {
            viewHolder = (BoThuAdapter.ViewHolder) convertView.getTag();
        }
        ThuocTinhBoThu ttbcc = listsong.get(position);
        viewHolder.txtvid.setText(ttbcc.getId() + "");
        viewHolder.txtvNhat.setText(ttbcc.getTuNhat()+"  ");
        viewHolder.txtvNghia.setText(ttbcc.getNghia()+": ");
        viewHolder.txtvNghiaViet.setText(ttbcc.getNghiaViet());

        return v;
    }

    static class ViewHolder {
        TextView txtvid;
        TextView txtvNhat;
        TextView txtvNghia;
        TextView txtvNghiaViet;
    }
}
