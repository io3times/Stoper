package com.level8.stoper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
   public boolean running;
    public int second=0;
    public String msg="Godziny";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   final TextView godz_textView=(TextView)findViewById(R.id.godz_textView);
  //  final TextView min_textView=(TextView)findViewById(R.id.min_textView);
  // final TextView sek_textView=(TextView)findViewById(R.id.sek_textView);


    public void onStartButtonClicked(View view) {
        running = true;
      godz_textView.setText(msg);
    }

    public void onStopButtonClicked(View view) {
        running = false;
    }

    public void onResetButtonClicked(View view) {
        running = false;
        second = 0;
    }
    //public void runTimer(){

    //}

}
