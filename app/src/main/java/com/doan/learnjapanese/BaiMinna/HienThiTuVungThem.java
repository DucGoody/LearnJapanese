package com.doan.learnjapanese.BaiMinna;

import android.content.Context;
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

public class HienThiTuVungThem extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private ArrayList<ThuocTinhTuVungThem> arrayList;
    private ListView lv;
    private ThuocTinhTuVungThem ttbcc;
    private TuVungThemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_tu_vung_them);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        arrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        lv=(ListView)findViewById(R.id.lvTVT);
        Bundle bundle=getIntent().getExtras();
        int s=bundle.getInt("tabstvt");
        int tab=s+1;
        setTitle("Từ vựng thêm - 牌"+tab);
        hienThi(tab);
    }
    private void hienThi(int bai){
        databaseHelper.copyDB();
        Cursor cursor=databaseHelper.getCursor("SELECT ID,TuNhat,TuViet,Bai FROM btlTVThem WHERE Bai = '"+bai+"'");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ttbcc = new ThuocTinhTuVungThem(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            arrayList.add(ttbcc);

            cursor.moveToNext();
        }
        cursor.close();
        adapter=new TuVungThemAdapter(this,R.layout.item_tuvungthem,arrayList);
        lv.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    class TuVungThemAdapter extends ArrayAdapter<ThuocTinhTuVungThem> {
        private Context context;
        ArrayList<ThuocTinhTuVungThem> listsong = new ArrayList<ThuocTinhTuVungThem>();
        int resource;

        public TuVungThemAdapter(Context context, int resource, List<ThuocTinhTuVungThem> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhTuVungThem>) listsong;
        }

        @Override
        public int getCount() {
            return listsong.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            TuVungThemAdapter.ViewHolder viewHolder;
            if (v == null) {
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_tuvungthem, null);
                viewHolder = new TuVungThemAdapter.ViewHolder();
                viewHolder.txtvTuNhat = (TextView) v.findViewById(R.id.txtvTuNhatTVT);
                viewHolder.txtvTuViet = (TextView) v.findViewById(R.id.txtvTuVietTVT);
                v.setTag(viewHolder);
            } else {
                viewHolder = (TuVungThemAdapter.ViewHolder) convertView.getTag();
            }
            ThuocTinhTuVungThem ttbcc = listsong.get(position);
            viewHolder.txtvTuNhat.setText(ttbcc.getTuNhat());
            viewHolder.txtvTuViet.setText(ttbcc.getTuViet());
            return v;
        }

        class ViewHolder {
            TextView txtvTuNhat;
            TextView txtvTuViet;
        }
    }

}
