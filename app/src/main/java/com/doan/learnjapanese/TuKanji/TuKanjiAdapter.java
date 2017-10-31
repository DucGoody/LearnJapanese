package com.doan.learnjapanese.TuKanji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;


public class TuKanjiAdapter extends ArrayAdapter<ThuocTinhTuKanji> {
    private Context context;
    ArrayList<ThuocTinhTuKanji> listsong = new ArrayList<ThuocTinhTuKanji>();
    int resource;

    public TuKanjiAdapter(Context context, int resource, List<ThuocTinhTuKanji> listsong) {
        super(context, resource, listsong);
        this.context = context;
        this.resource = resource;
        this.listsong = (ArrayList<ThuocTinhTuKanji>) listsong;
    }

    @Override
    public int getCount() {
        return listsong.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TuKanjiAdapter.ViewHolder viewHolder;
        if (v == null) {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_tukanji, null);
            viewHolder = new TuKanjiAdapter.ViewHolder();
            viewHolder.id = (TextView) v.findViewById(R.id.txtvIDkj);
            viewHolder.txtvTuKanji = (TextView) v.findViewById(R.id.txtvkj);
            viewHolder.txtvAmHan = (TextView) v.findViewById(R.id.txtvAmHankj);
            viewHolder.txtvOnoy = (TextView) v.findViewById(R.id.idOnyomi);
            viewHolder.txtvKun = (TextView) v.findViewById(R.id.txtvKunyomi);
            viewHolder.txtvChuThich = (TextView) v.findViewById(R.id.txtvChuThichKanji);
            v.setTag(viewHolder);
        } else {
            viewHolder = (TuKanjiAdapter.ViewHolder) convertView.getTag();
        }
        ThuocTinhTuKanji ttbcc = listsong.get(position);
        viewHolder.id.setText(ttbcc.getID() + "");
        viewHolder.txtvTuKanji.setText(ttbcc.getTuKanji());
        viewHolder.txtvAmHan.setText(ttbcc.getAmHan());
        viewHolder.txtvOnoy.setText(ttbcc.getOnoymi());
        viewHolder.txtvKun.setText(ttbcc.getKunyomi());
        viewHolder.txtvChuThich.setText(ttbcc.getChuThich());
        return v;
    }

    static class ViewHolder {
        TextView txtvTuKanji;
        TextView id, txtvChuThich;
        TextView txtvAmHan;
        TextView txtvOnoy;
        TextView txtvKun;
    }

}
