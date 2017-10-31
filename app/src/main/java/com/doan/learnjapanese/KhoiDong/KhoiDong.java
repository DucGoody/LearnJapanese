package com.doan.learnjapanese.KhoiDong;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.doan.learnjapanese.MainActivity;
import com.doan.learnjapanese.R;

import java.util.Timer;
import java.util.TimerTask;

public class KhoiDong extends AppCompatActivity {

    // thời gian chạy là 4s
    private static final long SPLASH_TIME=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  toàn màn hình
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_khoi_dong);
        // khởi tạo TimerTask
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                // chuyển activity
                Intent mainIntent=new Intent().setClass(KhoiDong.this,MainActivity.class);
                // thực thi việc chuyển activity
                startActivity(mainIntent);
                // hoàn tất activity và không cho phép quay trở về
                finish();
            }
        };
        // khởi tạo Timer
        Timer timer=new Timer();
        // thực thi công việc trong  TimerTask sau 4s
        timer.schedule(task,SPLASH_TIME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
