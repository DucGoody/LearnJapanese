package com.doan.learnjapanese.BaiMinna;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class HienThiHoiThoai extends AppCompatActivity {
    //khai báo các control, lớp và các biến
    // lớp databaseHelper
    private DatabaseHelper databaseHelper;
    // danh sách thuoctinhoithuoc
    private ArrayList<ThuocTinhHoiThoai> arrayList;
    // control listView
    private ListView lv;
    // lớp đối tượng ThuocTinhHoiThoai
    private ThuocTinhHoiThoai ttbcc;
    // lớp HoiThoaiAdapter để đổ dữ liệu vào listView
    private HoiThoaiAdapter adapter;
    // control TextView
    private TextView txtv;
    // control ImageView
    private ImageView imgPlay;
    // lớp mediaPlayer
    private MediaPlayer mediaPlayer;
    // biến tính thời gian bắt đầu
    private double startTime = 0;
    // biến tính tổng time
    private double finalTime = 0;
    // xử lý tiến trình load câu hỏi sau n giây
    private Handler myHandler = new Handler();
    //control seekBar để hiển thị thay chạy âm thanh
    private SeekBar seekbar;
    // biển để xử lý phím chọn play hay pause
    private int i = 0;
    // control TextView tính thời gian chạy và tổng thời gian
    private TextView tx1, tx2;
    // biến kiếm tra điều kiện max cho SeekBar
    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_hoi_thoai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // khởi tạo ArrayList
        arrayList = new ArrayList<>();
        // khởi tạo lớp DatabaseHelper
        databaseHelper = new DatabaseHelper(this);
        // tham chiếu các control tới control trong layout activity_hien_thi_hoi_thoai
        lv = (ListView) findViewById(R.id.lvHT);
        txtv = (TextView) findViewById(R.id.textView2);
        tx1 = (TextView) findViewById(R.id.txtvstarttimeHT);
        tx2 = (TextView) findViewById(R.id.txtvtotaltimeHT);


        Bundle bundle = getIntent().getExtras();
        // lấy về vị trí của tab từ 0
        int s = bundle.getInt("tabsht");
        // gán tab bằng s+1 xét từ 1
        int tab=s+1;
        setTitle("Luyện hội thoại - 牌" + tab);
        // gọi phương thức hiển thị nội dung với biến là vị trí tab
        hienThi(tab);

        // kiểm tra điều kiện vị trí tab , phát nhạc cho theo tab và tiêu đề nội dung của bài với tab tương ứng
        // nếu bằng 1 tức là tab 1
        if (tab == 1) {
            // tiến hành cho phép phát nhạc  ở bài 1, nhạc lưu vào thư mục raw
            phatnhac(R.raw.bai1mnht);
            // thiết lập tiêu đề cho tab
            txtv.setText("はじめまして \n Rất vui được làm quen với chị.");
        } else if (tab == 2) {
            phatnhac(R.raw.bai2mnht);
            txtv.setText("ほんのきもちです \n Chỉ là chút lòng thành.");
        } else if (tab == 3) {
            phatnhac(R.raw.bai3mnht);
            txtv.setText("これをください \n Chị cho tôi chai này.");
        } else if (tab == 4) {
            phatnhac(R.raw.bai4mnht);
            txtv.setText("そちらは何時から何時までですか \n Chổ của chị mở cửa từ mấy giờ đến mấy giờ ạ.");
        } else if (tab == 5) {
            phatnhac(R.raw.bai5mnht);
            txtv.setText("甲子園へいきますか \n Tàu này có đi Koshien không ạ?");
        } else if (tab == 6) {
            phatnhac(R.raw.bai6mnht);
            txtv.setText("いっしょうにいきませんか \n Anh có đi cùng với tôi không?");
        } else if (tab == 7) {
            phatnhac(R.raw.bai7mnht);
            txtv.setText("ごめんください\n Xin lỗi, tôi có thể vào được chứ.");
        } else if (tab == 8) {
            phatnhac(R.raw.bai8mnht);
            txtv.setText("そろそろしつれいします \n Đã đến lúc tôi phải về.");
        } else if (tab == 9) {
            phatnhac(R.raw.bai9mnht);
            txtv.setText("ざんねんです \n Thật đáng tiếc.");
        } else if (tab == 10) {
            phatnhac(R.raw.bai10mnht);
            txtv.setText("チリソースはありませんか \n Có tương ớt không ạ.");
        } else if (tab == 11) {
            phatnhac(R.raw.bai11mnht);
            txtv.setText("これおねがいします\n Cái này, cho tôi gủi bằng đường biển.");
        } else if (tab == 12) {
            phatnhac(R.raw.bai12mnht);
            txtv.setText("お祭りはどうでしたか \n Lễ hội thế nào?");
        } else if (tab == 13) {
            txtv.setText("べつべつにお願いします \n Chị tính riêng ra cho ạ.");
            phatnhac(R.raw.bai13mnht);
        } else if (tab == 14) {
            phatnhac(R.raw.bai14mnht);
            txtv.setText("うめだまで行ってください \n Cho tôi đến Umeda.");
        } else if (tab == 15) {
            phatnhac(R.raw.bai15mnht);
            txtv.setText("ご家族は？ \n Gia đình anh thế nào?");
        } else if (tab == 16) {
            phatnhac(R.raw.bai16mnht);
            txtv.setText("使い方を教えてください \n Làm ơn chỉ cho tôi cách dùng");
        } else if (tab == 17) {
            phatnhac(R.raw.bai17mnht);
            txtv.setText("どうしましたか \nÔng bị làm sao?");
        } else if (tab == 18) {
            phatnhac(R.raw.bai18mnht);
            txtv.setText("しゅみは何ですか\n Sở thích của anh là gì?");
        } else if (tab == 19) {
            phatnhac(R.raw.bai19mnht);
            txtv.setText("ダイエットは明日からします \n Tôi sẽ bắt đầu chế độ giảm cân từ ngày mai vậy.");
        } else if (tab == 20) {
            phatnhac(R.raw.bai20mnht);
            txtv.setText("夏安みはどうするの \n Nghỉ hè cậu làm gì?");
        } else if (tab == 21) {
            phatnhac(R.raw.bai21mnht);
            txtv.setText("わたしもそう思います \n Tôi cũng nghĩ như thế.");
        } else if (tab == 22) {
            phatnhac(R.raw.bai22mnht);
            txtv.setText("どんな　アパトーが　いいですか。 \n Anh muốn tìm căn hộ như thế nào?");
        } else if (tab == 23) {
            phatnhac(R.raw.bai23mnht);
            txtv.setText("どうやって　行きますか。 \n Đi như thế nào ạ.");
        } else if (tab == 24) {
            phatnhac(R.raw.bai24mnht);
            txtv.setText("手伝って　くれますか。 \n Anh giúp tôi được không?");
        } else if (tab == 25) {
            phatnhac(R.raw.bai25mnht);
            txtv.setText("いろいろ　お世話に　なりました\n Các anh chị đã giúp đỡ tôi rất nhiều.");
        } else if (tab == 26) {
            phatnhac(R.raw.bai26mnht);
            txtv.setText("どこに　ごみを出したら　いいですか。 \nTôi phải đổ rác ở đâu?");
        } else if (tab == 27) {
            phatnhac(R.raw.bai27mnht);
            txtv.setText("何でも　作れるんですね。\n Cái gì anh cũng làm được nhỉ?  ");
        } else if (tab == 28) {
            phatnhac(R.raw.bai28mnht);
            txtv.setText("お茶でも　飲みながら。。。 \n Anh có thể vừa uống trà vừa...");
        } else if (tab == 29) {
            phatnhac(R.raw.bai29mnht);
            txtv.setText("忘れ物を　して　しまったんです。\nTôi để quên đồ.");
        } else if (tab == 30) {
            phatnhac(R.raw.bai30mnht);
            txtv.setText("チケットを　予約して　おきます。  \n Tôi đặt vé trước.");
        } else if (tab == 31) {
            phatnhac(R.raw.bai31mnht);
            txtv.setText("インタネットを　始めようと　思っています。 \n Tôi đang định sẽ dùng Internet.");
        } else if (tab == 32) {
            phatnhac(R.raw.bai32mnht);
            txtv.setText("病気かも　しれません。 \nCó thể anh bị bệnh.");
        } else if (tab == 33) {
            phatnhac(R.raw.bai33mnht);
            txtv.setText("これは　どういう　意味ですか。 \n Cái này nghĩa là gì?");
        } else if (tab == 34) {
            phatnhac(R.raw.bai34mnht);
            txtv.setText("する　とおりに して　ください。 \n Hãy làm theo đúng như tôi làm");
        } else if (tab == 35) {
            phatnhac(R.raw.bai35mnht);
            txtv.setText("旅行者へ　行けば　わかります。 \n Đến công ty du lịch thì sẽ biết");
        } else if (tab == 36) {
            phatnhac(R.raw.bai36mnht);
            txtv.setText("あたまと　からだを　使うように　して　います。 \n Tôi cố gắng vận động cả trí não lẫn cơ thể.");
        } else if (tab == 37) {
            phatnhac(R.raw.bai37mnht);
            txtv.setText("海を　埋め立てて　造られました。 \n Chổ này được tạo thành từ việc lấp biển.");
        } else if (tab == 38) {
            phatnhac(R.raw.bai38mnht);
            txtv.setText("片づけるのが　すきなんです。 \n Thầy Watt, bản thông báo đây.");
        } else if (tab == 39) {
            phatnhac(R.raw.bai39mnht);
            txtv.setText("遅れて、　すみません。 \n Xin lỗi tôi đến muộn.");
        } else if (tab == 40) {
            phatnhac(R.raw.bai40mnht);
            txtv.setText("ともだちが　できたかどうか　心配です。 \n Tôi không biết nó có kết bạn được với ai không?");
        } else if (tab == 41) {
            phatnhac(R.raw.bai41mnht);
            txtv.setText("にもつを　あずかって　いただけませんか \n Nhờ chị giữ giúp hành lý có được không.");
        } else if (tab == 42) {
            phatnhac(R.raw.bai42mnht);
            txtv.setText("ボーナスは　何に　使いますか。 \n Anh sẽ tiêu tiền thưởng vào việc gì?");
        } else if (tab == 43) {
            phatnhac(R.raw.bai43mnht);
            txtv.setText("やきしそうですね。 \n Trông có vẻ hiền lành nhỉ?");
        } else if (tab == 44) {
            phatnhac(R.raw.bai44mnht);
            txtv.setText("この　写真みたいに　して　ください。 \n Anh hãy cắt kiểu như trong bức ảnh này.");
        } else if (tab == 45) {
            phatnhac(R.raw.bai45mnht);
            txtv.setText("いっしょうけんめい　練習したのに \n Tôi đã luyện tập nhiều, thế mà...");
        } else if (tab == 46) {
            phatnhac(R.raw.bai46mnht);
            txtv.setText("もうすぐ　着く　はずです。 \n Chắc chắn sắp đến nơi rồi.");
        } else if (tab == 47) {
            phatnhac(R.raw.bai47mnht);
            txtv.setText("こんやくしたそうです。 \n Nghe nói chị ấy đã đính hôn.");
        } else if (tab == 48) {
            phatnhac(R.raw.bai48mnht);
            txtv.setText("休ませて　いただけませんか。 \n Cho phép tôi nghỉ có được không?");
        } else if (tab == 49) {
            phatnhac(R.raw.bai49mnht);
            txtv.setText("よろしく　お伝え　ください。 \n Nhờ anh nhắn lại.");
        } else if (tab == 50) {
            phatnhac(R.raw.bai50mnht);
            txtv.setText("心から　かんしゃいたします。 \n Chân thành cám ơn.");
        }
        // tiến hành load time theo nhạc 0.1s load 1 lần
        myHandler.postDelayed(UpdateSongTime, 100);

        imgPlay = (ImageView) findViewById(R.id.imgHT);
        // thiết lập ảnh cho phím play nhạc
        imgPlay.setImageResource(R.drawable.play);
        // chon phim play
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click lần 1 cho phát nhạc và gán hình  đồng thời set biến i =1
                if (i == 0) {
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.pause);
                    i = 1;
                    // click lần 2 thiết lập biến i=2. pause nhạc đồng thời gán hình cho imgPlay
                } else if (i == 1) {
                    i = 0;
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.play);
                }
                // gán thời gian bằng thời gian media chạy
                finalTime = mediaPlayer.getDuration();


//                finalTime = mediaPlayer.getDuration();

                // nếu mà oneTimeOnly thì seekbar max là bằng finalTime tức là hết giờ chạy media
                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                }
                //gán tiến trình chạy của seekbar bằng thời gian bắt đầu
                seekbar.setProgress((int) startTime);
                // cập nhật sau 0.1s
                myHandler.postDelayed(UpdateSongTime, 100);
            }
        });
    }

    @Override
    protected void onDestroy() {
        // khi hủy activity thì sẽ dừng media
        mediaPlayer.stop();
        super.onDestroy();
    }
// phương thức phát nhạc với tham số là id2  tức là địa chỉ link nhạc
    private void phatnhac(int id2) {
        // khởi tạo MediaPlayer
        mediaPlayer = MediaPlayer.create(this, id2);

        seekbar = (SeekBar) findViewById(R.id.sbHT);
        // cho phép click để thua
        seekbar.setClickable(false);
        // lấy ra tổng thời gian của nhạc
        finalTime = mediaPlayer.getDuration();
        // set thời gian chạy
        startTime = mediaPlayer.getCurrentPosition();
        // thiết lập giá trị cho textView tổng thời gian
        tx2.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );
        // thiết lập giá trị cho textView thời gian chạy
        tx1.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                startTime)))
        );

    }
    // cập nhật thời gian
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            // lấy ra thời gian chạy
            startTime = mediaPlayer.getCurrentPosition();
            // thiết lập giá trị cho textView thời gian chạy
            tx1.setText(String.format("%d:%d ",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            // gán tiến trình chạy seekbar bằng startTime
            // cập nhật sau 0.1s
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
            // sự kiện seekbar
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // cho phép tua
                    if (fromUser) {
                        mediaPlayer.seekTo(progress);
                        seekbar.setProgress(progress);
                    }
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
// phương thức hiển thị bài theo tab
    private void hienThi(int bai) {
        // gọi phương thức copyDB
        databaseHelper.copyDB();
        // thực thi câu lệnh sql
        Cursor cursor = databaseHelper.getCursor("SELECT * FROM tblLuyenHoiThoai WHERE Bai = '" + bai + "'");
        // gán con trỏ bằng vị trí ban đầu
        cursor.moveToFirst();
        // duyệt con trỏ cho tới khi cuối cùng
        while (!cursor.isAfterLast()) {
            // khởi tạo đối tượng bằng các tham số với cột tương ứng trong csdl
            ttbcc = new ThuocTinhHoiThoai(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5));
            // thêm vào danh sách
            arrayList.add(ttbcc);
            // next con trỏ
            cursor.moveToNext();
        }
        // đóng con trỏ
        cursor.close();
        // đổ đối tượng trong danh sách với item ListView theo view ở item_hoithoai
        adapter = new HoiThoaiAdapter(this, R.layout.item_hoithoai, arrayList);
        // thiết lập adapter
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
    // lớp custom listView
    class HoiThoaiAdapter extends ArrayAdapter<ThuocTinhHoiThoai> {

        private Context context;
        ArrayList<ThuocTinhHoiThoai> listsong = new ArrayList<ThuocTinhHoiThoai>();
        int resource;
        // phương thức khởi tạo 3 tham số : contexxt , resource layout và list ThuocTinhHoiThoai
        public HoiThoaiAdapter(Context context, int resource, List<ThuocTinhHoiThoai> listsong) {
            super(context, resource, listsong);
            this.context = context;
            this.resource = resource;
            this.listsong = (ArrayList<ThuocTinhHoiThoai>) listsong;
        }

        // lấy ra kích thước listsong
        @Override
        public int getCount() {
            return listsong.size();
        }

        // phương thức xử lý khung nhìn cho item listView
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // gán view = convertView
            View v = convertView;
            HoiThoaiAdapter.ViewHolder viewHolder;
            //v== null
            if (v == null) {
                // LayoutInflater để sử dụng khung nhìn item_hoithoai
                LayoutInflater inflater;
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.item_hoithoai, null);
                // khởi tạo lớpViewHolder
                viewHolder = new HoiThoaiAdapter.ViewHolder();
                // tham chiếu tới các control tỏng layout item_hoithoai
                viewHolder.txtvNguoi = (TextView) v.findViewById(R.id.txtvnguoi);
                viewHolder.txtvCauNhat = (TextView) v.findViewById(R.id.txtvCauNhatht);
                viewHolder.txtvCauViet = (TextView) v.findViewById(R.id.txtvCauVietht);
                // thiết lập tag cho iew
                v.setTag(viewHolder);
            } else {
                // ngược lại lấy ra tag cho View
                viewHolder = (HoiThoaiAdapter.ViewHolder) convertView.getTag();
            }
            // lấy ra đối tượng trong danh sách tại ví trí position
            ThuocTinhHoiThoai ttbcc = listsong.get(position);
            // thiết lập các giá trị cho control
            viewHolder.txtvNguoi.setText(ttbcc.getNguoi());
            viewHolder.txtvCauNhat.setText(ttbcc.getCauNhat());
            viewHolder.txtvCauViet.setText(ttbcc.getCauViet());
            return v;
        }
        // lớp khai báo các control trong trong layout item_hoithoai
        class ViewHolder {
            TextView txtvNguoi;
            TextView txtvCauNhat;
            TextView txtvCauViet;
        }
    }
}
