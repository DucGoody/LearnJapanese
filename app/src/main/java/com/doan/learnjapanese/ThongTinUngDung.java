package com.doan.learnjapanese;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ThongTinUngDung extends AppCompatActivity {
    private TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ung_dung);

        ImageView img=(ImageView)findViewById(R.id.img1111);
        ImageView img2=(ImageView)findViewById(R.id.img11111);
        // sự kiện chọn sẽ hiển thị thông báo fb người lập trình
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"https://www.facebook.com/profile.php?id=100008471865981 \n Nguyen Thuy Linh",Toast.LENGTH_SHORT).show();
            }
        });
        // sự kiện chọn sẽ hiển thị thông báo gmail người lập trình
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"thuylinhkc1234@gmail.com",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
