package com.doan.learnjapanese.LuyenThi;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.doan.learnjapanese.DatabaseHelper;
import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HienThiLuyenThi extends AppCompatActivity {
    // khai báo các control và biến, list,lớp
    // control ProgressBar
    private ProgressBar mProgressBar;
    // biến tổng để lưu tổng số câu hỏi
    private int tongs;
    // số câu tl
    private int soctl = 0;
    // số câu tl đúng và số câu tl sai
    private int socautlsai = 0, socautldung = 0;
    // control TextView
    private TextView txtv;
    private TextView tldung, tlsai, txtvCauHoi, tong;
    // control Button
    private Button btn1, btn2, btn3, btn4;
    // lớp DatabaseHelper
    private DatabaseHelper db;
    // lớp đối tượng ThuocTinhLuyenThi
    private ThuocTinhLuyenThi tinhLuyenThi;
    // danh sách với dữ liệu String
    private List<String> arrayList;
    // biến bài
    private int bai;
    // lớp CountDownTimer
    private CountDownTimer mCountDownTimer;
    // biến progress để lưu lại tiến trình chạy của ProgressBar
    private int progress = 10;
    // biến lưu giá trị da1(a), da2(b),da3(c),da4(d),da (da đúng)
    private String da1, da2, da3, da4, da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_luyen_thi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        setTitle("Kiểm tra JLPT");
        txtv = (TextView) findViewById(R.id.txtvThoiGian);
        bai = bundle.getInt("lt");
        tldung = (TextView) findViewById(R.id.txtvTLDung);
        tlsai = (TextView) findViewById(R.id.txtvTLSai);
        tong = (TextView) findViewById(R.id.txtvTong);
        txtvCauHoi = (TextView) findViewById(R.id.txtvCauHoi2);
        btn1 = (Button) findViewById(R.id.btnda1);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        btn2 = (Button) findViewById(R.id.btnda2);
        btn3 = (Button) findViewById(R.id.btnda3);
        btn4 = (Button) findViewById(R.id.btnda4);
        tldung.setText(socautldung + "");
        tlsai.setText(socautlsai + "");

        db = new DatabaseHelper(this);
        arrayList = new ArrayList<>();
        db.copyDB();
        // thực thi lớp hiển thị câu hỏi
        hientThiCauHoi();
        // sự kiện chọn các đáp án
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // nếu đáp án 1 bằng đáp án đúng
                if (da1.equals(da)) {
                    // thông báo chính xác
                    Toast.makeText(getApplicationContext(), "Chính xác", Toast.LENGTH_SHORT).show();
                    // tăng giá trị đúng tăng lên
                    socautldung++;
                    // thiết lập câu trả lời đúng cho TextView
                    tldung.setText(socautldung + "");
                } else {
                    // nếu sai
                    // thống báo sai
                    Toast.makeText(getApplicationContext(), "Đáp án đúng là: " + da, Toast.LENGTH_SHORT).show();
                    // tăng số câu tl sai
                    socautlsai++;
                    // thiết lập số câu tl sai cho Text
                    tlsai.setText(socautlsai + "");
                }
                // dừng lớp CountDownTimer
                mCountDownTimer.cancel();
                // load câu hỏi tiếp theo sau 0.5s
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hientThiCauHoi();
                    }
                },500);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (da2.equals(da)) {
                    Toast.makeText(getApplicationContext(), "Chính xác", Toast.LENGTH_SHORT).show();
                    socautldung++;
                    tldung.setText(socautldung + "");
                } else {
                    Toast.makeText(getApplicationContext(), "Đáp án đúng là: " + da, Toast.LENGTH_SHORT).show();
                    socautlsai++;
                    tlsai.setText(socautlsai + "");
                }
                mCountDownTimer.cancel();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hientThiCauHoi();
                    }
                },500);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (da3.equals(da)) {
                    Toast.makeText(getApplicationContext(), "Chính xác", Toast.LENGTH_SHORT).show();
                    socautldung++;
                    tldung.setText(socautldung + "");
                } else {
                    socautlsai++;
                    Toast.makeText(getApplicationContext(), "Đáp án đúng là: " + da, Toast.LENGTH_SHORT).show();
                    tlsai.setText(socautlsai + "");
                }
                mCountDownTimer.cancel();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hientThiCauHoi();
                    }
                },500);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (da4.equals(da)) {
                    Toast.makeText(getApplicationContext(), "Chính xác", Toast.LENGTH_SHORT).show();
                    socautldung++;
                    tldung.setText(socautldung + "");
                } else {
                    Toast.makeText(getApplicationContext(), "Đáp án đúng là: " + da, Toast.LENGTH_SHORT).show();
                    socautlsai++;
                    tlsai.setText(socautlsai + "");
                }
                mCountDownTimer.cancel();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hientThiCauHoi();
                    }
                },500);
            }
        });
    }

    // phương thức hiển thị câu hỏi theo bài
    private void hientThiCauHoi() {
        // câu lệnh truy vấn với bảng tblLuyenThi
        String query = "SELECT* FROM tblLuyenThi WHERE Bai=" + bai + "";
        // thực thi câu lệnh
        Cursor cursor = db.getCursor(query);
        // lấy ra tổng số bảng ghi
        tongs = cursor.getCount();
        // số lượng câu hỏi là 15
        if (soctl < 15) {
            // khởi tạo Random
            Random random = new Random();
            // tăng số câu tl
            soctl++;
            // thiết lập số câu tl
            tong.setText(soctl + "/15");
            // khai báo biến vị trí câu hỏi
            int vitrich = 0;
            do {
                // load ngẫu nhiên câu hỏi trong tất cả các câu trong bảng tblLuyenThi
                vitrich = random.nextInt(tongs);
                // lấy con trở tại ví trị vitrich
                cursor.moveToPosition(vitrich);
                // lấy ra các thuộc tính của đối tượng ThuocTinhLuyenThi tương ứng với các cột trong csdl
                tinhLuyenThi = new ThuocTinhLuyenThi(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7),cursor.getInt(8));
            // điều kiện dừng là khi trùng câu hỏi
            } while (arrayList.contains(tinhLuyenThi.getCauHoi()));
            // thêm câu hỏi vào danh sách
            arrayList.add(tinhLuyenThi.getCauHoi());
            // thiết lập giá trị cho text là câu hỏi
            txtvCauHoi.setText(cursor.getString(1));
            // lấy ra thuộc tính tại ví trí vitrich đối tượng ThuocTinhLuyenThi
            da1 = cursor.getString(2);
            da2 = cursor.getString(3);
            da3 = cursor.getString(4);
            da4 = cursor.getString(5);
            da = cursor.getString(7);
            // thiết lập giá trị cho button
            btn1.setText(da1);
            btn2.setText(da2);
            btn3.setText(da3);
            btn4.setText(da4);
            // khởi tạo progress
            progress = 10;
            //  khởi tạo lớp CountDownTimer với tổng thời gian, thời gian giảm sau mỗi s
            mCountDownTimer = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    // giảm giá trị progress
                    progress--;
                    // thiết lập lại giá trị cho txtv
                    txtv.setText(progress + "");
                    // thiết lập lại giá trị cho ProgressBar
                    mProgressBar.setProgress(progress);
                }
                // khi chạy hết time sẽ load câu hỏi tiếp theo
                @Override
                public void onFinish() {
                    hientThiCauHoi();
                }
            };
            mCountDownTimer.start();
        } else {
            // nếu hết 15 câu
            android.support.v7.app.AlertDialog.Builder dialog = new android.support.v7.app.AlertDialog.Builder(this);
            // thiết lập tiêu đề cho dialog
            dialog.setTitle("Bạn đã hoàn thành xong bài thi.");
            // thiết lập nội dung tiêu đề
            dialog.setMessage("Bạn đã đúng " + socautldung + "/" + 15);
            // thiết lập nút cho dialog
            dialog.setPositiveButton("Đồng ý.", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // ẩn dialog
                    dialog.dismiss();
                    // hoàn tất activity và trở về activity trước
                    finish();
                }
            });
            // hiển thị dialog
            dialog.create().show();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
