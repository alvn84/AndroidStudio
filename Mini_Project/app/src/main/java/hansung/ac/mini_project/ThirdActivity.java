package hansung.ac.mini_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }
        public int getCount(){
            //return 0;
            return posterID.length;
        }
        public Object getItem(int arg0){
            return null;
        }
        public long getItemId(int arg0){
            return 0;
        }

        Integer[] posterID = {
                R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
                R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
                R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
                R.drawable.mov10,R.drawable.mov11,R.drawable.mov12,
                R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,
                R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,
                R.drawable.mov19,R.drawable.mov20
        };
        String[] movieName = {"토이 스토리4", "호빗", "제이슨 본", "반지의 제왕", "정직한 후보",
                "나쁜 녀석들", "겨울왕국2", "알라딘", "극한직업", "스파이더맨", "레옹", "주먹왕 랄프",
        "타짜3", "걸캅스", "도굴", "어벤져스 엔드게임", "엑시트", "캡틴 마블", "봉오동 전투", "분노의 질주: 홉스 앤 쇼"};




        public View getView(int position, View convertView, ViewGroup parent){
            //return null;
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5,5,5,5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(ThirdActivity.this,R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(ThirdActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(movieName[pos]);
                    //dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageview;
        }
    }
}