package com.doan.learnjapanese;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.doan.learnjapanese.R;

public class HuongDanSuDung extends AppCompatActivity {
    private TextView txtv1,txtv2,txtv3,txtv4,txtv5,txtv6;
    private CardView c1,c2,c3,c4,c5,c6;
    private ImageView img1,img2, img3, img4,img5,img6;
    private int i1 = 0;
    private int i2=0;
    private int i3=0;
    private int i4=0;
    private int i5=0;
    private int i6=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan_su_dung);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hướng dẫn sử dụng");
        anhXa();
        txtv1.setText("Cung cấp bảng chữ cái tiếng nhật gồm 4 loại: seion, dakuon, youon, tokuni\n" +
                " 1: Hiển thị chữ cái theo loại , cho phép người dùng xem. \n" +
                " 2: Chọn chữ cái để xem thông tin của chữ cái đó gồm: âm thanh, ví dụ...\n" +
                " 3: Chọn biểu tượng loa ở màn hình hiển thị chi tiết chữ để nghe cách đọc của chữ cái đó.");
        txtv2.setText("Cung cấp đên người dùng với 50 bài Minna gồm các chuyên mục: từ vựng, ngữ pháp, luyện hội thoại, hội thoại mẫu, từ vựng thêm. \n" +
                " 1: Hiển thị từ vựng gồm: từ nhật, hán tự và nghĩ tiếng việt. \n" +
                "  Để nghe phát âm của từ chọn vào biểu tượng loa tại từ đó. \n" +
                "  Ngoài ra có thể nghe toàn bộ phát âm của từ tại bài đã chọn, để dừng phát âm chọn nút vàng góc dưới màn hình và chọn lần 2 nút vàng để phát tiếp đoạn đã đừng tại bài đã chọn. \n" +
                " 2: Hiển thị ngữ pháp gồm: chủ đề, nội dung của chủ đề(chú ý, ví dụ).\n" +
                "  Môi bài sẽ có những phần ngữ pháp riêng , chọn vào chủ đề của ngữ pháp để xem chi tiết của chủ đề.\n" +
                " 3: Luyện hội thoại gồm: chủ đề, câu nhật và nghĩa việt tương ứng. \n" +
                "  Người dùng sẽ được nghe toàn bộ nội dung của hội thoại, tạm dừng và phát tiếp âm thanh tại nút vàng dưới màn hình.\n" +
                "  Cung cấp việc luyện hội thoại cho người dùng, giúp người dùng đọc và khả năng nghe với những cuộc hội thoại.\n" +
                " 4: Hội thoại mẫu gôm: câu nhật và nghĩa việt tương ứng:\n" +
                "  Nghe nội dung cuộc hội thoại với những hội thoại mẫu theo bài.\n" +
                " 5: Từ vựng thêm: hiển thị từ vựng thêm cho từng bài, giúp người dùng có thêm vốn từ theo bài.");
        txtv3.setText("Hiển thị 512 từ Kanji chia làm 32 tab.\n" +
                " 1: Chọn từ để xem chi tiết của từ: vị trí, từ kanji, âm hán, nghĩa, Onyomi, Kunyomi và ví dụ: \n" +
                " 2: Chọn tab để xem các từ tiếp theo.");
        txtv4.setText("214 bộ thủ được phân loại theo nét từ 1-17 được sắp xếp thự tự quan trọng có ý nghĩa để các bạn tra cứu.");
        txtv5.setText("Gồm các phần: chào hỏi, hội thoại, số điểm, ngày tháng và phương hướng.\n" +
                " 1: Chọn biểu tượng loa để phát âm thanh tương ứng với câu đó.\n" +
                " 2: Chọn các chủ đề ở các tab tương ứng.");
        txtv6.setText("Cho phép người dùng thử khả năng nhớ với nội dung đã học tại ứng dụng. Môi lần thi có 15 câu.\n" +
                " 1: Điểm từ con thiếu bằng cách chọn 1 trong 4 đáp án.\n" +
                " 2: Với thời gian cho mỗi câu hỏi là 10s. \n" +
                " 3: Cung cấp việc hiển thị tổng số câu, số câu trả lời đúng, số câu trả lời sai.\n" +
                " 4: Khi kết thúc hệ thống sẽ hiển thị thông báo số câu trả lời đúng. Người dùng muốn tiếp tục bằng cách chọn đồng ý. \n" +
                " 5: Hiển thị các phần thi: từ vựng, ngữ pháp, kanji, TỪ N4...N5.");
    }
    private void anhXa(){
        c1=(CardView)findViewById(R.id.chd1);
        c2=(CardView)findViewById(R.id.chd2);
        c3=(CardView)findViewById(R.id.chd3);
        c4=(CardView)findViewById(R.id.chd4);
        c5=(CardView)findViewById(R.id.chd5);
        c6=(CardView)findViewById(R.id.chd6);
        txtv1=(TextView)findViewById(R.id.txtvhd1);
        txtv2=(TextView)findViewById(R.id.txtvhd2);
        txtv3=(TextView)findViewById(R.id.txtvhd3);
        txtv4=(TextView)findViewById(R.id.txtvhd4);
        txtv5=(TextView)findViewById(R.id.txtvhd5);
        txtv6=(TextView)findViewById(R.id.txtvhd6);
        img1=(ImageView)findViewById(R.id.imghd1);
        img2=(ImageView)findViewById(R.id.imghd2);
        img3=(ImageView)findViewById(R.id.imghd3);
        img4=(ImageView)findViewById(R.id.imghd4);
        img5=(ImageView)findViewById(R.id.imghd5);
        img6=(ImageView)findViewById(R.id.imghd6);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // nếu i1=0;
                if (i1==0){
                    // thiết lập hình ảnh cho img1
                    img1.setImageResource(R.drawable.up);
                    // hiển thị textView
                    txtv1.setVisibility(View.VISIBLE);
                     // gán i1=1
                    i1 =1;
                    // nếu i1=1
                }else if (i1==1){
                    // thiết lập lại hình ảnh cho img1
                    img1.setImageResource(R.drawable.down);
                    // ẩn textView
                    txtv1.setVisibility(View.GONE);
                    // thiết lập i1=0
                    i1 =0;
                }
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i2==0){
                    img2.setImageResource(R.drawable.up);
                    txtv2.setVisibility(View.VISIBLE);
                    i2 =1;
                }else if (i2==1){
                    img2.setImageResource(R.drawable.down);
                    txtv2.setVisibility(View.GONE);
                    i2 =0;
                }
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i3==0){
                    img3.setImageResource(R.drawable.up);
                    txtv3.setVisibility(View.VISIBLE);
                    i3 =1;
                }else if (i3==1){
                    img3.setImageResource(R.drawable.down);
                    txtv3.setVisibility(View.GONE);
                    i3 =0;
                }
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i4==0){
                    img4.setImageResource(R.drawable.up);
                    txtv4.setVisibility(View.VISIBLE);
                    i4 =1;
                }else if (i4==1){
                    img4.setImageResource(R.drawable.down);
                    txtv4.setVisibility(View.GONE);
                    i4 =0;
                }
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i5==0){
                    img5.setImageResource(R.drawable.up);
                    txtv5.setVisibility(View.VISIBLE);
                    i5 =1;
                }else if (i5==1){
                    img5.setImageResource(R.drawable.down);
                    txtv5.setVisibility(View.GONE);
                    i5 =0;
                }
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i6==0){
                    img6.setImageResource(R.drawable.up);
                    txtv6.setVisibility(View.VISIBLE);
                    i6 =1;
                }else if (i6==1){
                    img6.setImageResource(R.drawable.down);
                    txtv6.setVisibility(View.GONE);
                    i6 =0;
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
