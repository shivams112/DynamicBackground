package io.github.shivams112.dynamicbg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    RelativeLayout bg;
    Date mDate;
    TextView mTextView;
    Handler hand = new Handler();
    Handler hand1 = new Handler();
    private static final long GET_DATA_INTERVAL = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bg = findViewById(R.id.bg);
        mTextView = findViewById(R.id.txt);
       //  String tt = getTime();
        // String color = "#ff";
        // color = color + tt +tt;
        // bg.setBackgroundColor(Color.parseColor(color));
        hand1.postDelayed(run1, GET_DATA_INTERVAL);
    }


    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume: ", "Change...Change");


    }
    public String getTime(){
        String timestamp = new SimpleDateFormat("ss").format(Calendar.getInstance().getTime());
        String mm = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime());
        String hh = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
        //char[] time = timestamp.toCharArray();
        int finalTime = 0;
        //String color ="";
//        for(char output:time){
//            if(output!=':'){
//                int num = output-'0';
//                color+=output;
//                finalTime = finalTime*10 + num;
//            }
//        }
        String clock = hh+":"+mm+":"+timestamp;
        Log.d("time: ", timestamp+" "+finalTime);
        mTextView.setText(clock);
        return "#"+hh+mm+timestamp;
    }
    public void runTime() {
        String tt = getTime();
        //String color = "#ff";
        //color = color + tt +tt;
        bg.setBackgroundColor(Color.parseColor(tt));
        //TimeUnit.SECONDS.sleep(1);
        //runTime();
    }
    Runnable run1 = new Runnable() {
        @Override
        public void run() {
            runTime();
            hand1.postDelayed(run1, GET_DATA_INTERVAL);
        }
    };
}
