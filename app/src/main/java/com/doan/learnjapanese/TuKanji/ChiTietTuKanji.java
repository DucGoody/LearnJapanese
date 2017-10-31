package com.doan.learnjapanese.TuKanji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.doan.learnjapanese.R;

public class ChiTietTuKanji extends AppCompatActivity {
    private TextView txtvID, txtvTuKanji, txtvAmHan, txtvNghia, txtvOny, txtvKuny, txtvViDuNhat, txtvViDu2, txtvViDuViet;
    private String tuKanji, amHan, ony, kuny, nghia, viduViet, viduNhat, vidu2;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tu_kanji);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Chi tiết từ Kanji");
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("idct");
        tuKanji = bundle.getString("tukanji");
        amHan = bundle.getString("amhan");
        nghia = bundle.getString("nghia");
        ony = bundle.getString("ony");
        kuny = bundle.getString("kuny");
        viduNhat = bundle.getString("vidunhatct");
        vidu2 = bundle.getString("vidu2");
        viduViet = bundle.getString("viduvietct");
        ChiTiet();

    }

    private void ChiTiet() {
        txtvID = (TextView) findViewById(R.id.txtvIDCT2);
        txtvAmHan = (TextView) findViewById(R.id.txtvAmHanCT2);
        txtvTuKanji = (TextView) findViewById(R.id.txtvTuKanjiCT2);
        txtvOny = (TextView) findViewById(R.id.txtvOnyomiCT2);
        txtvKuny = (TextView) findViewById(R.id.txtvKunyomi2);
        txtvViDuNhat = (TextView) findViewById(R.id.txtvViDuNhatCT2);
        txtvViDu2 = (TextView) findViewById(R.id.txtvViDu2CT2);
        txtvViDuViet = (TextView) findViewById(R.id.txtvViDuVietCT2);
        txtvNghia = (TextView) findViewById(R.id.txtvNghiaCT2);
        txtvID.setText(id + "");
        txtvTuKanji.setText(tuKanji);
        txtvAmHan.setText(amHan);
        txtvNghia.setText(nghia);
        txtvOny.setText(ony);
        txtvKuny.setText(kuny);
        txtvViDuNhat.setText(viduNhat);
        txtvViDu2.setText(vidu2);
        txtvViDuViet.setText(viduViet);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
