package com.doan.learnjapanese.BaiMinna;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.doan.learnjapanese.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HienThiHoiThoaiMau extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private ArrayList<ThuocTinhHoiThoaiMau> arrayList;
    private ListView lv;
    private ThuocTinhHoiThoaiMau ttbcc;
    private HoiThoaiMauAdapter adapter;
    private ImageView imgPlay;
    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private SeekBar seekbar;
    private TextView tx1,tx2;
    private int i=0;

    public static int oneTimeOnly = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_hoi_thoai_mau);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        arrayList=new ArrayList<>();
        databaseHelper=new DatabaseHelper(this);
        lv=(ListView) findViewById(R.id.lvHTM);
        tx1=(TextView)findViewById(R.id.txtvtimeHTM);
        tx2=(TextView)findViewById(R.id.txtvtotalHTM);
        Bundle bundle=getIntent().getExtras();
        int s=bundle.getInt("tabshtm");
        int tab=s+1;
        setTitle("Hội thoại mẫu - 牌"+tab);
        hienThi(tab);
        if (tab==1) {
            phatnhac(R.raw.bai1minna);
        }else if (tab==2){
            phatnhac(R.raw.bai2minna);
        }
        else if (tab==3){
            phatnhac(R.raw.bai3minna);
        }
        else if (tab==4){
            phatnhac(R.raw.bai4minna);
        }
        else if (tab==5){
            phatnhac(R.raw.bai5minna);
        }
        else if (tab==6){
            phatnhac(R.raw.bai6minna);
        }
        else if (tab==7){
            phatnhac(R.raw.bai7minna);
        }
        else if (tab==8){
            phatnhac(R.raw.bai8minna);
        }
        else if (tab==9){
            phatnhac(R.raw.bai9minna);
        }else if (tab==10){
            phatnhac(R.raw.bai10minna);
        }else if (tab==11){
            phatnhac(R.raw.bai11minna);
        }
        else if (tab==12){
            phatnhac(R.raw.bai12minna);
        }
        else if (tab==13){
            phatnhac(R.raw.bai13minna);
        }
        else if (tab==14){
            phatnhac(R.raw.bai14minna);
        }
        else if (tab==15){
            phatnhac(R.raw.bai15minna);
        }else if (tab==16){
            phatnhac(R.raw.bai16minna);
        }else if (tab==17){
            phatnhac(R.raw.bai17minna);
        }
        else if (tab==18){
            phatnhac(R.raw.bai18minna);
        }
        else if (tab==19){
            phatnhac(R.raw.bai19minna);
        }
        else if (tab==20){
            phatnhac(R.raw.bai20minna);
        }
        else if (tab==21){
            phatnhac(R.raw.bai21minna);
        }else if (tab==22){
            phatnhac(R.raw.bai22minna);
        }
        else if (tab==23){
            phatnhac(R.raw.bai23minna);
        }
        else if (tab==24){
            phatnhac(R.raw.bai24minna);
        }
        else if (tab==25){
            phatnhac(R.raw.bai25minna);
        }
        else if (tab==26){
            phatnhac(R.raw.bai26minna);
        }
        else if (tab==27){
            phatnhac(R.raw.bai27minna);
        }
        else if (tab==28){
            phatnhac(R.raw.bai28minna);
        }
        else if (tab==29){
            phatnhac(R.raw.bai29minna);
        }
        else if (tab==30){
            phatnhac(R.raw.bai30minna);
        }
        else if (tab==31){
            phatnhac(R.raw.bai31minna);
        }
        else if (tab==32){
            phatnhac(R.raw.bai32minna);
        }
        else if (tab==33){
            phatnhac(R.raw.bai33minna);
        }
        else if (tab==34){
            phatnhac(R.raw.bai34minna);
        }
        else if (tab==35){
            phatnhac(R.raw.bai35minna);
        }
        else if (tab==36){
            phatnhac(R.raw.bai36minna);
        }
        else if (tab==37){
            phatnhac(R.raw.bai37minna);
        }
        else if (tab==38){
            phatnhac(R.raw.bai38minna);
        }
        else if (tab==39){
            phatnhac(R.raw.bai39minna);
        }
        else if (tab==40){
            phatnhac(R.raw.bai40minna);
        }else if (tab==41){
            phatnhac(R.raw.bai41minna);
        }
        else if (tab==42){
            phatnhac(R.raw.bai42minna);
        }
        else if (tab==43){
            phatnhac(R.raw.bai43minna);
        }
        else if (tab==44){
            phatnhac(R.raw.bai44minna);
        }
        else if (tab==45){
            phatnhac(R.raw.bai45minna);
        }
        else if (tab==46){
            phatnhac(R.raw.bai46minna);
        }
        else if (tab==47){
            phatnhac(R.raw.bai47minna);
        }
        else if (tab==48){
            phatnhac(R.raw.bai48minna);
        }
        else if (tab==49){
            phatnhac(R.raw.bai49minna);
        }
        else if (tab==50){
            phatnhac(R.raw.bai50minna);
        }


        myHandler.postDelayed(UpdateSongTime,100);
        imgPlay=(ImageView) findViewById(R.id.playHTM);
        imgPlay.setImageResource(R.drawable.play);
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.pause);
                    i = 1;
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
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    private void phatnhac(int id2){
        mediaPlayer = MediaPlayer.create(this, id2);
        seekbar = (SeekBar) findViewById(R.id.sbHTM);
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

        Cursor cursor=databaseHelper.getCursor("SELECT * FROM tblHoiThoaiMau WHERE Bai = '"+bai+"'");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ttbcc = new ThuocTinhHoiThoaiMau(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3),cursor.getInt(4));
            arrayList.add(ttbcc);

            cursor.moveToNext();
        }
        cursor.close();
        adapter=new HoiThoaiMauAdapter(this,R.layout.item_hoithoaimau,arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
    class HoiThoaiMauAdapter extends ArrayAdapter<ThuocTinhHoiThoaiMau> {
        private Context context;
        ArrayList<ThuocTinhHoiThoaiMau> listsong = new ArrayList<ThuocTinhHoiThoaiMau>();
        int resource;

        public HoiThoaiMauAdapter(Context context, int resource, List<ThuocTinhHoiThoaiMau> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhHoiThoaiMau>) listsong;
        }

        @Override
        public int getCount() {
            return listsong.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            HoiThoaiMauAdapter.ViewHolder viewHolder;
            if (v == null) {
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_hoithoaimau, null);
                viewHolder = new HoiThoaiMauAdapter.ViewHolder();
                viewHolder.txtvCauNhat = (TextView) v.findViewById(R.id.txtvCauNhathtm);
                viewHolder.txtvCauViet = (TextView) v.findViewById(R.id.txtvCauViethtm);
                v.setTag(viewHolder);
            } else {
                viewHolder = (HoiThoaiMauAdapter.ViewHolder) convertView.getTag();
            }
            ThuocTinhHoiThoaiMau ttbcc = listsong.get(position);
            viewHolder.txtvCauNhat.setText(ttbcc.getCauNhat());
            viewHolder.txtvCauViet.setText(ttbcc.getCauViet());
            return v;
        }

        class ViewHolder {
            TextView txtvCauNhat;
            TextView txtvCauViet;
        }
    }
}
