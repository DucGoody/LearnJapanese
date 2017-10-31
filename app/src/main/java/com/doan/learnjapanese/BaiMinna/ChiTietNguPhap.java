package com.doan.learnjapanese.BaiMinna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.doan.learnjapanese.R;

public class ChiTietNguPhap extends AppCompatActivity {
    // khai báo các control gồm các TextView
    private TextView txtvTieuDe,txtvTieuDeChiTiet,txtvNoiDung,txtxViDuChiTiet,txtvChuY,txtvTieuDeMoRong,txtvChuThichMoRong,txtvViDuMoRong;
    // khai báo biến kdl: String
    private String tieuDe,tieudeChiTiet,noiDung,viDu,chuY,tieuDeMoRong,noiDungMoRong,viDuMoRong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_ngu_phap);
        // gọi phím back trên toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // thiết lặp  tiêu đề cho toolbar
        setTitle("Chi tiết ngữ pháp");
        // tham chiếu các control tới các control trong layout activity_chi_tiet_ngu_phap
        txtvTieuDe=(TextView)findViewById(R.id.txtvTieuDeNguPhap);// hiểu thị tiêu đề ngữ pháp 1
        txtvTieuDeChiTiet=(TextView)findViewById(R.id.txtvTieuDeChiTiet);// tiêu đề chi tiết 1
        txtvNoiDung=(TextView)findViewById(R.id.txtvNoiDungNguPhap);// nội dung 1
        txtxViDuChiTiet=(TextView)findViewById(R.id.txtvViDuNguPhap);// ví dụ 1
        txtvChuY=(TextView)findViewById(R.id.txtvChuYNgưPhap);// chú ý (chữ màu đỏ)
        txtvTieuDeMoRong=(TextView)findViewById(R.id.txtvTieuDeNguPhapMoRong);// tiêu đề ngữ pháp 2
        txtvChuThichMoRong=(TextView)findViewById(R.id.txtvNoiDungNguPhapMoRong);// nội dung 2
        txtvViDuMoRong=(TextView)findViewById(R.id.txtvViDuNguPhapMoRong);// ví dụ 2
        // dùng Bundle để bắt dữ liệu từ activity trước chuyển tới
        Bundle bundle=getIntent().getExtras();
        // lấy về tiêu đề với key là tieude
        tieuDe=bundle.getString("tieude");
        // lấy rà tiêu đề chi tiết với key : tieudechitiet
        tieudeChiTiet=bundle.getString("tieudechitiet");
        // nội dung 1  với key :noidung
        noiDung=bundle.getString("noidung");
        // ví dụ 1 với key: vidu
        viDu=bundle.getString("vidu");
        // chú ý với key: chuy
        chuY=bundle.getString("chuy");
        // tiêu đề 2 với key: tieudemorong
        tieuDeMoRong=bundle.getString("tieudemorong");
        //nội dung 2 với ket noidungmorong
        noiDungMoRong=bundle.getString("noidungmorong");
        //ví dụ 2: với key vidumorong
        viDuMoRong=bundle.getString("vidumorong");

        // thiết lập giá trị cho các textView
        txtvTieuDe.setText(tieuDe);
        txtvTieuDeChiTiet.setText(tieudeChiTiet);
        txtvNoiDung.setText(noiDung);
        txtxViDuChiTiet.setText(viDu);
        txtvChuY.setText(chuY);
        txtvTieuDeMoRong.setText(tieuDeMoRong);
        txtvChuThichMoRong.setText(noiDungMoRong);
        txtvViDuMoRong.setText(viDuMoRong);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // hoàn tất activity và trở về activity trước khi ấn back trên thanh toolbar
        finish();
        return super.onOptionsItemSelected(item);
    }
}
