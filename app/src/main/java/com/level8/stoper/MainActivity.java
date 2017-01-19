package com.level8.stoper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private boolean running;
    private int second = 0;
    private boolean wasRunning=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            second=savedInstanceState.getInt("second");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }
    @Override
    protected void onPause(){
        super.onPause();
        running=false;

    }
    @Override
    protected void onResume(){
        super.onResume();
       if (wasRunning){
           running=true;
       } else {
           running=false;
       }
    }
    public void onStartButtonClicked(View view) {
        running = true;
        wasRunning=true;
    }

    public void onStopButtonClicked(View view) {
        running = false;
        wasRunning=false;
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
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("second", second);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }



}
