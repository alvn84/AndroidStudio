package hansung.ac.mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,
            R.id.BtnNum4,R.id.BtnNum5,R.id.BtnNum6,
            R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        setTitle("테이블레이아웃 계산기");
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1)+Integer.parseInt(num2);
                textResult.setText("계산 결과: " + result.toString());

                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과: " + result.toString());

                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과: " + result.toString());

                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과: " + result.toString());

                return false;
            }
        });

        for(i=0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for(i=0; i<numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    if(edit1.isFocused()){
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused()){
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else
                        Toast.makeText(getApplicationContext(),"먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();

                }
            });
        }
        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}