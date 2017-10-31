package com.doan.learnjapanese;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doan.learnjapanese.BaiMinna.TabMinna;
import com.doan.learnjapanese.BangChuCai.MainBangChuCai;
import com.doan.learnjapanese.BoThu.MainBoThu;
import com.doan.learnjapanese.LuyenThi.LuyenThi;
import com.doan.learnjapanese.MauCauGiaoTiep.MainGiaoTiep;
import com.doan.learnjapanese.TuKanji.MainKanji;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private CardView c1, c2, c3, c4, c5;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nav("Learn Japanese");
        c1 = (CardView) findViewById(R.id.cc1);
        c2 = (CardView) findViewById(R.id.cc2);
        c3 = (CardView) findViewById(R.id.cc3);
        c4 = (CardView) findViewById(R.id.cc4);
        c5 = (CardView) findViewById(R.id.cc5);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HuongDanSuDung.class);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), fb.class);
                intent.putExtra("fb", "https://www.facebook.com/profile.php?id=100008471865981");
                intent.putExtra("lh", "Facebook");
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), fb.class);
                intent.putExtra("fb", "https://mail.google.com/mail/u/0/");
                intent.putExtra("lh", "Google Plus");
                Toast.makeText(getApplicationContext(), "Mail nhà phát triền: thuylinhkc1234@gmail.com", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }

    public void Nav(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);

        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id) {
            case R.id.nav_bangchucai:
                intent = new Intent(getApplicationContext(), MainBangChuCai.class);
                startActivity(intent);
                break;
            case R.id.nav_baiminna:
                intent = new Intent(getApplicationContext(), TabMinna.class);
                startActivity(intent);
                break;
            case R.id.nav_tukanji:
                intent = new Intent(getApplicationContext(), MainKanji.class);
                startActivity(intent);
                break;
            case R.id.nav_bothu:
                intent = new Intent(getApplicationContext(), MainBoThu.class);
                startActivity(intent);
                break;
            case R.id.nav_caugiaotiep:
                intent = new Intent(getApplicationContext(), MainGiaoTiep.class);
                startActivity(intent);
                break;
            case R.id.nav_luyenthi:
                intent = new Intent(getApplicationContext(), LuyenThi.class);
                startActivity(intent);
                break;
            case R.id.nav_ttud:
                intent = new Intent(getApplicationContext(), ThongTinUngDung.class);
                startActivity(intent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void share() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Ứng dụng học tiếng nhật trên Android.");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Sinh viên thực hiện: Nguyễn Thùy Linh");
        startActivity(Intent.createChooser(sharingIntent, "Chia sẻ"));
    }

    private void dialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Thoát!");

        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Bạn có chắc muốn thoát không ?");
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(R.drawable.icontrong);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtoncancel);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
