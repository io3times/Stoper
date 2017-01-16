package com.level8.stoper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private boolean running;
    private int second = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
        //Wydaje mi się to błędne
    }
    public void onStartButtonClicked(View view) {
        running = true;

    }

    public void onStopButtonClicked(View view) {
        running = false;

    }

    public void onResetButtonClicked(View view) {
        running = false;
        second = 0;
    }
    private void runTimer() {
        final TextView godView = (TextView) findViewById(R.id.godTextView);


        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int god=second/3600;
                int min=(second%3600)/60;
                int sek=second%60;
                String msg= String.format("%d:%02d:%02d", god,min,sek);
                godView.setText(msg);

                if (running) {
                    second++;
                }
                handler.postDelayed(this, 1000);
            }



        });


    }




}
