package hansung.ac.mini_project;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.Nullable;

public class FourthActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this, R.raw.song1);

        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(switch1.isChecked()==true){
                    mPlayer.start();
                }
                else{
                    mPlayer.stop();
                }
            }
        });

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}