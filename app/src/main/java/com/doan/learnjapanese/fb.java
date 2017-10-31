package com.doan.learnjapanese;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fb extends AppCompatActivity {
    // khai báo control  WebView
    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);
        // thiết lập phím back cho toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // tham chiếu control tới contorl trong layout WebView
        view = (WebView) findViewById(R.id.webView);
        // lấy ra link và tiêu đề cho tab từ activity khác chuyển tới
        String duonglink = getIntent().getStringExtra("fb");
        String title = getIntent().getStringExtra("lh");
        // load link
        view.loadUrl(duonglink);
        // thiết lập hiển thị lên webView mà không chuyển ứng dụng khác
        view.setWebViewClient(new WebViewClient());
        // thiết lập tiêu đề cho toolbar
        setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
