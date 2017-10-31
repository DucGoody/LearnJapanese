package com.doan.learnjapanese.BaiMinna;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.doan.learnjapanese.DatabaseHelper;
import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;

public class HienThiNguPhap extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private ArrayList<ThuocTinhNguPhap> arrayList;
    private ListView lv;
    private ThuocTinhNguPhap ttbcc;
    private NguPhapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_ngu_phap);
        arrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        lv=(ListView)findViewById(R.id.lvNP);
        Bundle bundle=getIntent().getExtras();
        int s=bundle.getInt("tabsnp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int tab=s+1;
        setTitle("Ngữ pháp - 牌"+tab);
        hienThi(tab);
    }
    private void hienThi(int bai){

        databaseHelper.copyDB();

        Cursor cursor=databaseHelper.getCursor("SELECT * FROM tblNguPhap WHERE Bai = '"+bai+"'");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ttbcc = new ThuocTinhNguPhap(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getInt(9),cursor.getInt(10));
            arrayList.add(ttbcc);
            cursor.moveToNext();
        }
        cursor.close();
        adapter=new NguPhapAdapter(this,R.layout.item_nguphap,arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tieude=arrayList.get(position).getTieuDe();
                String tieudechitiet=arrayList.get(position).getTieuDeChiTiet();
                String noidung=arrayList.get(position).getNoiDung();
                String vidu=arrayList.get(position).getViDuChiTiet();
                String chuy=arrayList.get(position).getChuY();
                String tieudemorong=arrayList.get(position).getTieuDeMoRong();
                String noidungmorong=arrayList.get(position).getChuThichMoRong();
                String vidumorong=arrayList.get(position).getViDuMoRong();
                Intent intent=new Intent(getApplicationContext(),ChiTietNguPhap.class);
                intent.putExtra("tieude",tieude);
                intent.putExtra("tieudechitiet",tieudechitiet);
                intent.putExtra("noidung",noidung);
                intent.putExtra("vidu",vidu);
                intent.putExtra("chuy",chuy);
                intent.putExtra("tieudemorong",tieudemorong);
                intent.putExtra("noidungmorong",noidungmorong);
                intent.putExtra("vidumorong",vidumorong);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
    class NguPhapAdapter extends ArrayAdapter<ThuocTinhNguPhap> {
        private Context context;
        ArrayList<ThuocTinhNguPhap> listsong = new ArrayList<ThuocTinhNguPhap>();
        int resource;

        public NguPhapAdapter(Context context, int resource, List<ThuocTinhNguPhap> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhNguPhap>) listsong;
        }

        @Override
        public int getCount() {
            return listsong.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            NguPhapAdapter.ViewHolder viewHolder;
            if (v == null) {
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_nguphap, null);
                viewHolder = new NguPhapAdapter.ViewHolder();
                viewHolder.txtvTieuDe = (TextView) v.findViewById(R.id.txtvTieuDeNP);
                viewHolder.txtvNoiDung = (TextView) v.findViewById(R.id.txtvNoiDungNP);
                v.setTag(viewHolder);
            } else {
                viewHolder = (NguPhapAdapter.ViewHolder) convertView.getTag();
            }
            ThuocTinhNguPhap ttbcc = listsong.get(position);
            viewHolder.txtvTieuDe.setText(ttbcc.getTieuDe());
            viewHolder.txtvNoiDung.setText(ttbcc.getNoiDung());
            return v;
        }

        class ViewHolder {
            TextView txtvTieuDe;
            TextView txtvNoiDung;
        }
    }

}
