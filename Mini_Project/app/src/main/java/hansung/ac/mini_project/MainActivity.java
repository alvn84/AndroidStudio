package hansung.ac.mini_project;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.annotation.Nullable;



public class MainActivity extends AppCompatActivity {

    EditText edtUrl;
    Button btnGo, btnBack;
    WebView web;

    ImageView imageView;

    private boolean isImage1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);
        imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isImage1) {
                    imageView.setImageResource(R.drawable.frog);  // 새로운 이미지로 변경
                } else {
                    imageView.setImageResource(R.drawable.rabbit);  // 원래 이미지로 변경
                }
                isImage1 = !isImage1;  // 이미지 상태 플래그를 반전
            }
        });

        web.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(edtUrl.getText().toString());
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();
            }
        });

    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
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
                R.drawable.cal,R.drawable.gallery,R.drawable.music,
                R.drawable.draw
        };




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
                    if(pos==0){
                        Intent intent1 = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent1);
                    }
                    else if(pos==1){
                        Intent intent1 = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent1);
                    }
                    else if(pos==2){
                        Intent intent1 = new Intent(getApplicationContext(), FourthActivity.class);
                        startActivity(intent1);
                    }
                    else if(pos==3){
                        Intent intent1 = new Intent(getApplicationContext(), FifthActivity.class);
                        startActivity(intent1);
                    }
                    else if(pos==4){
                        Intent intent1 = new Intent(getApplicationContext(), SixthActivity.class);
                        startActivity(intent1);
                    }
                    else if(pos==5){
                        Intent intent1 = new Intent(getApplicationContext(), SeventhActivity.class);
                        startActivity(intent1);
                    }


                }
            });

            return imageview;
        }
    }
}