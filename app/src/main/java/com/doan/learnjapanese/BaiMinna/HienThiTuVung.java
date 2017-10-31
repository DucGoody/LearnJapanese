package com.doan.learnjapanese.BaiMinna;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.doan.learnjapanese.DatabaseHelper;
import com.doan.learnjapanese.MauCauGiaoTiep.MainGiaoTiep;
import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HienThiTuVung extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private ArrayList<ThuocTinhTuVung> arrayList;
    private ListView lv;
    private ThuocTinhTuVung ttbcc;
    private TuVungAdapter adapter;
    private ImageView imgPlay;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private SeekBar seekbar;
    int i =0;
    private TextView tx1,tx2;
    private TextToSpeech toSpeech;
    public static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_tu_vung);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        arrayList=new ArrayList<>();
        tx1=(TextView)findViewById(R.id.txtvtimetv);
        tx2=(TextView)findViewById(R.id.txtvtotaltv);
        databaseHelper=new DatabaseHelper(this);
        lv=(ListView)findViewById(R.id.lvTV);
        Bundle bundle=getIntent().getExtras();
        int t1=bundle.getInt("tabstv");
        int tab=t1-1;
        setTitle("Từ vựng - 牌"+tab);
        hienThi(tab);

        if (tab==1) {
            phatnhac(R.raw.bai1mntv);
        }else if (tab==2){
            phatnhac(R.raw.bai2mntv);
        }
        else if (tab==3){
            phatnhac(R.raw.bai3mntv);
        }
        else if (tab==4){
            phatnhac(R.raw.bai4mntv);
        }
        else if (tab==5){
            phatnhac(R.raw.bai5mntv);
        }
        else if (tab==6){
            phatnhac(R.raw.bai6mntv);
        }
        else if (tab==7){
            phatnhac(R.raw.bai7mntv);
        }
        else if (tab==8){
            phatnhac(R.raw.bai8mntv);
        }
        else if (tab==9){
            phatnhac(R.raw.bai9mntv);
        }else if (tab==10){
            phatnhac(R.raw.bai10mntv);
        }else if (tab==11){
            phatnhac(R.raw.bai11mntv);
        }
        else if (tab==12){
            phatnhac(R.raw.bai12mntv);
        }
        else if (tab==13){
            phatnhac(R.raw.bai13mntv);
        }
        else if (tab==14){
            phatnhac(R.raw.bai14mntv);
        }
        else if (tab==15){
            phatnhac(R.raw.bai15mntv);
        }else if (tab==16){
            phatnhac(R.raw.bai16mntv);
        }else if (tab==17){
            phatnhac(R.raw.bai17mntv);
        }
        else if (tab==18){
            phatnhac(R.raw.bai18mntv);
        }
        else if (tab==19){
            phatnhac(R.raw.bai19mntv);
        }
        else if (tab==20){
            phatnhac(R.raw.bai20mntv);
        }
        else if (tab==21){
            phatnhac(R.raw.bai21mntv);
        }else if (tab==22){
            phatnhac(R.raw.bai22mntv);
        }
        else if (tab==23){
            phatnhac(R.raw.bai23mntv);
        }
        else if (tab==24){
            phatnhac(R.raw.bai24mntv);
        }
        else if (tab==25){
            phatnhac(R.raw.bai25mntv);
        }
        else if (tab==26){
            phatnhac(R.raw.bai26mntv);
        }
        else if (tab==27){
            phatnhac(R.raw.bai27mntv);
        }
        else if (tab==28){
            phatnhac(R.raw.bai28mntv);
        }
        else if (tab==29){
            phatnhac(R.raw.bai29mntv);
        }
        else if (tab==30){
            phatnhac(R.raw.bai30mntv);
        }
        else if (tab==31){
            phatnhac(R.raw.bai31mntv);
        }
        else if (tab==32){
            phatnhac(R.raw.bai32mntv);
        }
        else if (tab==33){
            phatnhac(R.raw.bai33mntv);
        }
        else if (tab==34){
            phatnhac(R.raw.bai34mntv);
        }
        else if (tab==35){
            phatnhac(R.raw.bai35mntv);
        }
        else if (tab==36){
            phatnhac(R.raw.bai36mntv);
        }
        else if (tab==37){
            phatnhac(R.raw.bai37mntv);
        }
        else if (tab==38){
            phatnhac(R.raw.bai38mntv);
        }
        else if (tab==39){
            phatnhac(R.raw.bai39mntv);
        }
        else if (tab==40){
            phatnhac(R.raw.bai40mntv);
        }else if (tab==41){
            phatnhac(R.raw.bai41mntv);
        }
        else if (tab==42){
            phatnhac(R.raw.bai42mntv);
        }
        else if (tab==43){
            phatnhac(R.raw.bai43mntv);
        }
        else if (tab==44){
            phatnhac(R.raw.bai44mntv);
        }
        else if (tab==45){
            phatnhac(R.raw.bai45mntv);
        }
        else if (tab==46){
            phatnhac(R.raw.bai46mntv);
        }
        else if (tab==47){
            phatnhac(R.raw.bai47mntv);
        }
        else if (tab==48){
            phatnhac(R.raw.bai48mntv);
        }
        else if (tab==49){
            phatnhac(R.raw.bai49mntv);
        }
        else if (tab==50){
            phatnhac(R.raw.bai50mntv);
        }

        myHandler.postDelayed(UpdateSongTime,100);
        imgPlay=(ImageView) findViewById(R.id.playTV);
        imgPlay.setImageResource(R.drawable.play);
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.pause);
                    i=1;
                } else if (i == 1) {
                    i = 0;
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.play);
                }
                finalTime = mediaPlayer.getDuration();
                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                }
                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);

            }
        });
        mediaPlayer.setLooping(true);
        nghe();
    }
    private void nghe() {
        toSpeech = new TextToSpeech(HienThiTuVung.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    toSpeech.setLanguage(Locale.getDefault());
                    toSpeech.setLanguage(Locale.JAPANESE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    private void phatnhac(int id2){
        mediaPlayer = MediaPlayer.create(this, id2);
        seekbar = (SeekBar) findViewById(R.id.sbTV);
        seekbar.setClickable(false);
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();

        tx2.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );
        tx1.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                startTime)))
        );
    }
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d:%d ",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );

            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
            seekbar.setThumb(null);
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if(fromUser){
                        mediaPlayer.seekTo(progress);
                        seekbar.setProgress(progress);}
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
    };
    private void hienThi(int bai){
        databaseHelper.copyDB();
        Cursor cursor=databaseHelper.getCursor("SELECT * FROM tblTuVung WHERE Bai = '"+bai+"'");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ttbcc = new ThuocTinhTuVung(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getInt(4),cursor.getInt(5));
            arrayList.add(ttbcc);

            cursor.moveToNext();
        }
        cursor.close();
        adapter=new TuVungAdapter(this,R.layout.item_tuvung,arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    class TuVungAdapter extends ArrayAdapter<ThuocTinhTuVung> {
        private Context context;
        ArrayList<ThuocTinhTuVung> listsong = new ArrayList<ThuocTinhTuVung>();
        int resource;

        public TuVungAdapter(Context context, int resource, List<ThuocTinhTuVung> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhTuVung>) listsong;
        }

        @Override
        public int getCount() {
            return listsong.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            final TuVungAdapter.ViewHolder viewHolder;
            if (v == null) {
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_tuvung, null);
                viewHolder = new TuVungAdapter.ViewHolder();
                viewHolder.txtvAmNhat = (TextView) v.findViewById(R.id.txtvTuNhatTV);
                viewHolder.txtvAmViet = (TextView) v.findViewById(R.id.txtvTuVietTV);
                viewHolder.txtvHanTu = (TextView) v.findViewById(R.id.txtvHanTuTV);
                viewHolder.img=(ImageView)v.findViewById(R.id.imgloaTV);
                v.setTag(viewHolder);
            } else {
                viewHolder = (TuVungAdapter.ViewHolder) convertView.getTag();
            }
            ThuocTinhTuVung ttbcc = listsong.get(position);
            viewHolder.txtvAmNhat.setText(ttbcc.getAmNhat());
            viewHolder.txtvAmViet.setText(ttbcc.getHanTu());
            viewHolder.txtvHanTu.setText(ttbcc.getAmViet());
            viewHolder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String txt = viewHolder.txtvAmNhat.getText().toString().trim();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        toSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
            return v;
        }

        class ViewHolder {
            TextView txtvAmNhat;
            TextView txtvAmViet;
            TextView txtvHanTu;
            ImageView img;
        }
    }
}
