package com.dev_thiban.yemeniideas.Bags;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.dev_thiban.yemeniideas.MainActivity;
import com.dev_thiban.yemeniideas.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 2000;
    Timer timer;
    MyTimerTask myTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        myTimerTask = new MyTimerTask();
        timer.schedule(myTimerTask, SPLASH_TIME_OUT);
    }

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }

}
