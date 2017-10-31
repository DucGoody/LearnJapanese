package com.doan.learnjapanese.LuyenThi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;

import com.doan.learnjapanese.R;

public class LuyenThi extends AppCompatActivity {
    // khai báo control và lớp
    // control CardView
    private CardView c1, c2, c3, c4, c5, c6;
    // lớp Intent
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_luyen_thi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Luyện thi JLPT");
        c1 = (CardView) findViewById(R.id.ccc1);
        c2 = (CardView) findViewById(R.id.ccc2);
        c3 = (CardView) findViewById(R.id.ccc3);
        c4 = (CardView) findViewById(R.id.ccc4);
        c5 = (CardView) findViewById(R.id.ccc5);
        c6 = (CardView) findViewById(R.id.ccc6);
        // thiết lập sự kiện chon cardView
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khởi tạo intent
                intent = new Intent(getApplicationContext(), HienThiLuyenThi.class);
                // put dữ liệu qua activity HienThiLuyenThi
                intent.putExtra("lt", 51);
                // thực thi việc chuyển activity
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HienThiLuyenThi.class);
                intent.putExtra("lt", 52);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HienThiLuyenThi.class);
                intent.putExtra("lt", 53);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HienThiLuyenThi.class);
                intent.putExtra("lt", 41);
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HienThiLuyenThi.class);
                intent.putExtra("lt", 42);
                startActivity(intent);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HienThiLuyenThi.class);
                intent.putExtra("lt", 43);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        finish();
        return super.onOptionsItemSelected(item);
    }
}


