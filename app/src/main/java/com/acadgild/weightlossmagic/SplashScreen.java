package com.acadgild.weightlossmagic;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.acadgild.weightlossmagic.login.Login;

/**
 * Created by DivyaVipin on 2/27/2017.
 */

public class SplashScreen  extends AppCompatActivity{
    // Splash screen timer
     private static int SPLASH_TIME_OUT = 3000;
    private  int value;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar) findViewById(R.id.imageProgress);
        TextView tx = (TextView)findViewById(R.id.txtViewWeightLoss);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"Fun Raiser.ttf");
        tx.setTypeface(custom_font);
        TextView txtCaption = (TextView)findViewById(R.id.txtViewCaption);
        Typeface caption_font = Typeface.createFromAsset(getAssets(),"DroidSerif-BoldItalic.ttf");
        txtCaption.setTypeface(caption_font);
        new Handler().postDelayed(new Runnable() {
       public void run() {
           for (int i = 0; i <= 100; i++) {
                value = i;

           }
           progressBar.setProgress(value);
                Intent splash = new Intent(SplashScreen.this,Login.class);
                startActivity(splash);
              }
            }, SPLASH_TIME_OUT);
        }
}
