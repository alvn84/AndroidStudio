package hansung.ac.mini_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class FifthActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2, SQUARE = 3;
    static int curShape = SQUARE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setTitle("간단 그림판");
        setContentView(new MyGraphicView(this));

    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu); // 메뉴 추가 옵션
        menu.add(0,1,0,"선 그리기");
        menu.add(0,1,0,"원 그리기");
        menu.add(0,1,0,"사각형 그리기");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){ // 무슨 도형 그릴 지 판별해주는 스위치문
        switch(item.getItemId()){
            case 1:
                curShape = LINE;
                return true;
            case 2:
                curShape = CIRCLE;
                return true;
            case 3:
                curShape = SQUARE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(@NonNull Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            switch (curShape){
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX-startX, 2) +
                            Math.pow(stopY-startY,2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case SQUARE:
                    canvas.drawRect(startX, startY, stopX, stopY, paint);
                    break;
            }
        }
    }

}